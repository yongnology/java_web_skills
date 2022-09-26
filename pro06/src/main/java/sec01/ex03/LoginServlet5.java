package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet5() {
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 실행");
	}
	public void destroy() {
		System.out.println("destroy 메소드 실행");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		String data = "<html><body>";
		data += "아이디 : "+id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "<br>";
		data += "주소" + address;
		data += "</body></html>";
		out.printf(data);
				
	}

}
