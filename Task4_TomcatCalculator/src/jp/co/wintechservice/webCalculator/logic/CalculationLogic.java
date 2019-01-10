package jp.co.wintechservice.webCalculator.logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.wintechservice.webCalculator.beans.Calc;

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
	    Calc calc = (Calc)session.getAttribute("calc");

	    //初回calcインスタンス作成、初期値0セット
	    if (calc == null){
            calc = new Calc();
            session.setAttribute("calc",calc);
            calc.setResult("0");
        }




	    //num(数字、小数点)が押下された場合
	    if (request.getParameterMap().containsKey("num")) {
	        String num = request.getParameter("num");
	        //numが小数点かつresultが整数の場合
	        if (num.equals(".") && !calc.getResult().contains(".")) {
	            calc.setResult(calc.getResult() + ".");
	        }
	        //numが数字の場合
	        else {
	          //result又はxが0ならresultを空にする(先頭の0削除)
	            if (calc.getResult().equals("0") || calc.getX() == 0) {
	                calc.setResult("");
	            }
	            //数字を連結して結果レジスタにセット
	            calc.setResult(calc.getResult() + num);
	            //
	        }
	        calc.setX(Double.parseDouble(calc.getResult()));
        }


	    //CE,C,戻 が押下された場合(保留)
	    if (request.getParameterMap().containsKey("Del")) {
	        String del = request.getParameter("del");
	        if (del.equals("CE")) {
	            calc.setResult("0");
	        } else if (del.equals("C")) {
	            calc.setResult("0");
	            calc.setX(0);
	            calc.setY(0);
	        } else if (del.equals("戻")){

	        }
        }

	    //operatorが押下された場合
	    if (request.getParameterMap().containsKey("operator")){
            String operator = request.getParameter("operator");
            //
            if (session.getAttribute("operator") == null){
                calc.setY(calc.getX());
                calc.setX(0);
                session.setAttribute("operator", operator);
            }
          //四則演算
            if (operator.equals("+")) {
                calc.add();
            } else if (operator.equals("-")) {
                calc.substract();
            } else if (operator.equals("×")) {
                calc.multiply();
            } else if (operator.equals("÷")) {
                try {
                    calc.divide();
                } catch (ArithmeticException e) {
                    System.out.print("0で割ることはできません");
                }
            }

	     }

	}

}
