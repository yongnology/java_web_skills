package sec01.ex01;

import java.io.IOException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
    public ThirdServlet() {
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ThirdServlet init 메소드 호출");
	}

	public void destroy() {
		System.out.println("ThirdServlet destroy 메소드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ThirdServlet doGet 메소드 호출");
	}

}
