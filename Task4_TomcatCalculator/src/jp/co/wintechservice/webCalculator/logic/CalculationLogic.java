package jp.co.wintechservice.webCalculator.logic;

import java.io.IOException;

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
            calc.setInput("0");
            calc.setResult(0);
            calc.setX(0);
            calc.setY(0);
            calc.setOperator("");
        }

	    //num(数字、小数点)が押下された場合
	    if (request.getParameterMap().containsKey("num")) {
	        String num = request.getParameter("num");
	        //numが小数点かつinputが整数の場合
	        if (num.equals(".")) {
	            calc.setInput(calc.getInput() + num);
	        }
	        //numが数字の場合
	        else {
//2019/01/16 演算子が入っているときに数字を押した場合の処理がおかしい
	            //先頭の0削除
	            if (calc.getInput() == "0") {
	                String havingFirstZero = calc.getInput() + num;
	                StringBuilder killingFirstZero = new StringBuilder(havingFirstZero);
	                killingFirstZero.deleteCharAt(0);
	                calc.setInput(killingFirstZero.toString());
	            } else {
	                //押下された数字を連結
                    calc.setInput(calc.getInput() + num);
                }
                //ResultをXにセット
                calc.setX(calc.getResult());
                //InputをYにセット
                calc.setY(Double.parseDouble(calc.getInput()));
	        }
        }
	    //operatorが押下された場合
	    else if (request.getParameterMap().containsKey("operator")){
            String operator = request.getParameter("operator");
            //operatorが空の場合
            if (calc.getOperator().isEmpty()) {
                calc.setOperator(operator);
            }

            //足し算
            if (calc.getOperator().equals("+")) {
                calc.setResult(calc.getX() + calc.getY());
            }
            //引き算
            else if (calc.getOperator().equals("-")) {
                calc.setResult(calc.getX() - calc.getY());
            }
            //掛け算
            else if (calc.getOperator().equals("*")) {
                calc.setResult(calc.getX() * calc.getY());
            }
            //割り算
            else if (calc.getOperator().equals("/")) {
                if (calc.getY() == 0) {
                    calc.setInput("0で割ることはできません");
                } else {
                    calc.setResult(calc.getX() / calc.getY());
                }
            }
            //計算結果を出力
            calc.setInput(String.valueOf(calc.getResult()));
            //演算子をセット
            calc.setOperator(operator);
	    }


       //CE,C,戻 が押下された場合
         if (request.getParameterMap().containsKey("del")) {
             String del = request.getParameter("del");
             //CE,Cの場合
             if (del.equals("CE")) {
                 calc.setInput("0");
             } else if (del.equals("C")) {
                 calc.setInput("0");
                 calc.setResult(0);
                 calc.setX(0);
                 calc.setY(0);
                 calc.setOperator("");
             }
             //戻の場合
             else if (del.equals("戻")){
                 //押下された値の桁数
                 int length = String.valueOf(calc.getInput()).length();
                 //最後尾の数字のインデックス
                 int lengthBack = length - 1;
                 if (length > 0) {
                    StringBuilder back = new StringBuilder(calc.getInput());
                    back.deleteCharAt(lengthBack);
                    calc.setInput(back.toString());
                }

             }
         }


	     }
}


