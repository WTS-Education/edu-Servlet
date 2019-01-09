package jp.co.wintechservice.webCalculator.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.wintechservice.webCalculator.logic.CalculationLogic;

/**
 * 電卓サーブレット(http://localhost:8081/Task4_Tomcatcalc/IndexServlet)
 * @author KohariJunichiro
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

       HttpSession session = request.getSession();
       CalculationLogic calc = (CalculationLogic)session.getAttribute("calc");

       //result又はｘが０ならresultを空にする
       if (calc.getResult().equals("0") || calc.getX() == 0){
           calc.setResult("");
       }

       //押下された数字を連結
       String num = request.getParameter("num");
       calc.setResult(calc.getResult() + num);
       calc.setX(Double.parseDouble(calc.getResult()));

       //四則演算
       String operator = request.getParameter("operator");
       switch(operator)
       {
           case("+"):
               calc.add();
               break;
           case("-"):
               calc.sub();
               break;
           case("*"):
               calc.multi();
               break;
           case("/"):       //論理エラー処理する（あとで）
               calc.div();
               break;

       }


       String view = "/WEB-INF/view/index.jsp";
       RequestDispatcher dispatcher = request.getRequestDispatcher(view);
       dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
