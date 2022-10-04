// ServletContext의 매개변수 설정 기능
// web.xml에서 param 값을 가져오기

package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
			System.out.println("ServletContext 객체를 가져온다.");
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order= context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
			System.out.println("web.xml의 <param-name>태그의 이름으로"
					+ "<param-value>태그의 값인 메뉴 이름등을 받아온다.");
			
		
		out.print("<html><body>");
		out.print("<table border='1' cellspancing='0'><tr>메뉴 이름</tr>");
		out.print("<tr><td>" + menu_member +"</td></tr>");
		out.print("<tr><td>" + menu_order +"</td></tr>");
		out.print("<tr><td>" + menu_goods +"</td></tr>");
		out.print("</table></body></html>");
	}

}
