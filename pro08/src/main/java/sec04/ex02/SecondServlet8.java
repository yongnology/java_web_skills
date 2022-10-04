// HttpServletRequest를 이용한 dispatch 포워딩 시 바인딩

package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second8")
public class SecondServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second8 페이지");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String address=(String)request.getAttribute("address");
		
		out.println("<html><body>");
		out.println("<h2>주소 : " + address+ "<br>");
		out.println("redirect를 이용한 바인딩 실습</h2>");
		out.println("</body></html>");
	}

}
