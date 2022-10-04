package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * System.out.println("init 메소드 호출"); }
	 * 
	 * public void destroy() { System.out.println("destroy 메소드 호출"); }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
			System.out.println("getServletContext 객체를 가져옴");
		
		List member = new ArrayList();
			System.out.println("member 객체 생성");
		member.add("이순신");
		member.add(30);
		
		context.setAttribute("member", member);
			System.out.println("ServletContext 객체에 데이터를바인딩");
		out.print("<html><body>");
		out.print("이순신과 30설정");
		out.print("</body></html>");
	}

}
