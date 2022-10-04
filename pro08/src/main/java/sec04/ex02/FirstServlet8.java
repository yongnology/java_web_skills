// HttpServletRequest를 이용한 dispatch 포워딩 시 바인딩

package sec04.ex02;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first8")
public class FirstServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		request.setAttribute("address", "서울시 성북구");	// 웹 브라우저의 최초 요청 request에 바인딩
		RequestDispatcher dispatch = request.getRequestDispatcher("second8");
		dispatch.forward(request,response);
	}

}
