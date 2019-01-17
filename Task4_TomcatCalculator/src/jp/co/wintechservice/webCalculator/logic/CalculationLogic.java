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

	    //num(数字、小数点)が押下された場合
	    if (request.getParameterMap().containsKey("num")) {
	        String num = request.getParameter("num");
	        //numが小数点かつoutputが整数
	        if (num.equals(".") && !calc.getOutput().contains(".")) {
	            calc.setOutput(calc.getOutput() + num);
	        }
	        //numが数字の場合
	        else if(!num.equals(".")) {
	            if (calc.getOutput().indexOf("0") == 0) {
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
	        session.setAttribute("num", num);
	    }
	    //operatorが押下された場合
	    else if (request.getParameterMap().containsKey("operator")){
	        String operator = request.getParameter("operator");
	        //直前にoperator(イコールを除く)を押下していた場合
	        if (session.getAttribute("operator") != null && !operator.equals("=")) {
	            //計算せずにoutputの値を控えておくだけ
	            calc.setInput(calc.getOutput());
	            //新しく押下されたオペレータをセット
	            calc.setOperator(operator);
            } else {
                BigDecimal result = new BigDecimal(calc.getOutput());
                BigDecimal x = new BigDecimal(calc.getInput());
                //前回の計算結果
                String previousResult = calc.getOutput();

                //起動して初めてオペレーターが押下された場合
                if (calc.getOperator().isEmpty()) {
                    //入力された数字を控えておく
                    calc.setInput(calc.getOutput());
                } else {

                  //足し算
                    if (calc.getOperator().equals("+")) {
                        calc.setOutput(x.add(result).toString());
                    }
                    //引き算
                    else if (calc.getOperator().equals("-")) {
                        calc.setOutput(x.subtract(result).toString());
                    }
                    //掛け算
                    else if (calc.getOperator().equals("×")) {
                        calc.setOutput(x.multiply(result).toString());
                    }
                    //割り算
                    else if (calc.getOperator().equals("÷")) {
                        calc.setOutput(x.divide(result, 15, RoundingMode.HALF_UP).stripTrailingZeros().toString());
                    }
                }
                if (operator.equals("=")) {
                    //前回の演算子
                    String previousOperator = calc.getOperator();
                    //直前に数字を押下している場合
                    if (session.getAttribute("num") != null) {
                        //前回の計算結果を控えておく
                        calc.setInput(previousResult);
                        session.setAttribute("num", null);
                        operator = previousOperator;
                    }
                    //直前にイコールを押下していた場合
                    else {
                        operator = previousOperator;
                        //前回の計算結果を控えない
                    }
                } else {
                    //計算結果を控えておく
                    calc.setInput(calc.getOutput());
                }
                //operatorを控えておく
                calc.setOperator(operator);
                session.setAttribute("operator", operator);

            }
	    }


	    //plusAlphaが押下された場合(±、√、x²、1/x)
	    if (request.getParameterMap().containsKey("plusAlpha")) {
	        String plusAlpha = request.getParameter("plusAlpha");
	        if (plusAlpha.equals("±")) {
	            calc.setOutput(String.valueOf(Integer.parseInt(calc.getOutput()) * -1));
            }
	        //百分率
	        else if (plusAlpha.equals("%")) {
                BigDecimal hundred = new BigDecimal(100);
                BigDecimal output = new BigDecimal(calc.getOutput());
                BigDecimal input = new BigDecimal(calc.getInput());
                //output * (input /100)
                String percent = String.valueOf(output.multiply(input.divide(hundred, 15, RoundingMode.HALF_UP)).stripTrailingZeros());
                calc.setOutput(percent);
            }
	        //平方根
	        else if (plusAlpha.equals("√")) {
                String sqrt = String.valueOf(Math.sqrt(Double.parseDouble(calc.getOutput())));
                calc.setOutput(sqrt);
            }
	        //2乗
	        else if (plusAlpha.equals("x²")) {
                BigDecimal square = new BigDecimal(calc.getOutput());
                calc.setOutput(square.multiply(square).toString());
            }
	        //逆数
	        else if (plusAlpha.equals("1/x")) {
                BigDecimal one = new BigDecimal(1);
                BigDecimal inverse = new BigDecimal(calc.getOutput());
                calc.setOutput(one.divide(inverse, 15, RoundingMode.HALF_UP).stripTrailingZeros().toString());
            }

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
                 session.setAttribute("operator", null);
             }
             //戻の場合 //一桁の場合は0にする
             else if (del.equals("◀")){
                 //押下された値の桁数
                 int length = String.valueOf(calc.getOutput()).length();
                 //最後尾の数字のインデックス
                 int lengthBack = length - 1;
                 if (length > 1) {
                    StringBuilder back = new StringBuilder(calc.getOutput());
                    back.deleteCharAt(lengthBack);
                    calc.setOutput(back.toString());
                }

             }
         }


	     }
}


