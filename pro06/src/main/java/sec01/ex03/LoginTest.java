package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 호출");
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle 메소드 호출");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디 : "+ id);
		System.out.println("비밀번호 : " + pw);
		
		if(id!=null && id.length()!=0) {
			out.print("<html><body>");
			out.print(id+"님 안녕하세요. <br>로그인 하셨습니다.");
			out.print("</body></html");
		} else {
			out.print("<html><body>");
			out.print("아이디를 입력하세요<br>");
			out.print("<a href='http://localhost:8090/pro06/test01/login.html'>로그인 창으로 이동");
			out.print("</body></html>");
		}
	}
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

}
