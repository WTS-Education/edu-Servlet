package jp.co.wintechservice.webCalculator.logic;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.wintechservice.webCalculator.beans.CalcBean;

/**
 * Servlet implementation class CalclatorLogic
 */
@WebServlet("/CalclatorLogic")
public class CalculationLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculationLogic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public static void calc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    HttpSession session = request.getSession();
	    CalcBean calc = (CalcBean)session.getAttribute("calc");

	    //初回calcインスタンス作成、初期値0セット
	    if (calc == null){
            calc = new CalcBean();
            session.setAttribute("calc",calc);
            calc.setOutput("0");
            calc.setInput("0");
            calc.setOperator("");
        }
	    //計算結果を入れる
	    String resultt;

	    //num(数字、小数点)が押下された場合
	    if (request.getParameterMap().containsKey("num")) {
	        String num = request.getParameter("num");
	        //numが小数点かつ
	        if (num.equals(".") && !calc.getOutput().contains(".")) {
	            calc.setOutput(calc.getOutput() + num);
	        }
	        //numが数字の場合
	        else {
	            if (calc.getOutput() == "0") {
                    String havingFirstZero = calc.getOutput() + num;
                    StringBuilder killingFirstZero = new StringBuilder(havingFirstZero);
                    killingFirstZero.deleteCharAt(0);
                    calc.setOutput(killingFirstZero.toString());
                } else {
                  //直前に演算子を押下していた場合
                    if (session.getAttribute("operator") != null) {
                        calc.setOutput(num);
                        session.setAttribute("operator", null);
                        } else {
                          //押下された数字を連結して出力
                            calc.setOutput(calc.getOutput() + num);
                        }
                }
            }
	    }
	    //operatorが押下された場合
	    else if (request.getParameterMap().containsKey("operator")){
            String operator = request.getParameter("operator");
            BigDecimal result = new BigDecimal(calc.getOutput());
            BigDecimal x = new BigDecimal(calc.getInput());
            //起動して初めてオペレーターが押下された場合
            if (calc.getOperator().isEmpty()) {
                //計算しない
            } else {
//                //イコールが押下された場合
//                if (operator == "=") {
//                    //直前に演算子を押下している場合
//                    if (session.getAttribute("operator") != null) {
//                        //ｘに計算前のresultを控えておく
//                    } else {
//                        //Inputはそのまま
//                    }
//                    session.setAttribute("operator", null);
//                    //オペレータそのまま
//                }
              //足し算
                if (calc.getOperator().equals("足")) {
                    calc.setOutput(x.add(result).toString());
                }
                //引き算
                else if (calc.getOperator().equals("引")) {
                    calc.setOutput(x.subtract(result).toString());
                }
                //掛け算
                else if (calc.getOperator().equals("掛")) {
                    calc.setOutput(x.multiply(result).toString());
                }
                //割り算
                else if (calc.getOperator().equals("割")) {
                    calc.setOutput(x.divide(result, 16, RoundingMode.HALF_UP).toString());
                }
            }
            //計算結果をxに控えておく(=の場合は控えない)
            calc.setInput(calc.getOutput());
            //今回押下された演算子を控えておく
            calc.setOperator(operator);
            session.setAttribute("operator", operator);
	    }


       //CE,C,戻 が押下された場合
         if (request.getParameterMap().containsKey("del")) {
             String del = request.getParameter("del");
             //CE,Cの場合
             if (del.equals("CE")) {
                 calc.setOutput("0");
             } else if (del.equals("C")) {
                 calc.setOutput("0");
                 calc.setInput("0");
                 calc.setOperator("");
             }
             //戻の場合
             else if (del.equals("戻")){
                 //押下された値の桁数
                 int length = String.valueOf(calc.getOutput()).length();
                 //最後尾の数字のインデックス
                 int lengthBack = length - 1;
                 if (length > 0) {
                    StringBuilder back = new StringBuilder(calc.getOutput());
                    back.deleteCharAt(lengthBack);
                    calc.setOutput(back.toString());
                }

             }
         }


	     }
}


