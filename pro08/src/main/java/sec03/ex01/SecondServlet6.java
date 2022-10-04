// 서블릿을 이용한 dispatch 포워딩,
// get 방식으로 데이터를 전송

package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second6")
public class SecondServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second6 페이지");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String name= request.getParameter("name");	// 다른 서블릿에서 전달된 데이터 가져온다.
			System.out.println("name 값 : "+ name);
		
		out.println("<html><body>");
		out.println("<h2>이름 : " + name+ "<br>");
		out.println("dispatch를 이용한 forward 실습</h2>");
		out.println("</body></html>");
	}

}
