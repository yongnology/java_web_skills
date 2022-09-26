package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value : values) {
				System.out.println("name=" + name + ",value="+ value);
			}
		}
	}
	
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
}
