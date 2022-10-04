// redirect 방식으로 다른 서브릿에게 데이터 전달하기

package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second4")
public class SecondServlet4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name= request.getParameter("name");
		System.out.println("parameter의 name 값 : " + name);
		out.print("<html><body>");
		out.print("이름 : "+ name);
		out.print("<br>");
		out.print("</body></html>");
	}

}
