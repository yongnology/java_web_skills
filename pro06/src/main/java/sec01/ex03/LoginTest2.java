package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디 : "+ id);
		System.out.println("비밀번호 :"+pw);
		if(id!=null && id.length()!=0) {
			if(id.equals("admin")) {
				System.out.println("관리자 로그인");
				out.print("<html><body>");
				out.print("<font size='12'>관리자로 로그인 하셨습니다!! </font>");
				out.print("<br>");
				out.print("<input type='button' value='회원정보 수정하기' />" );
				out.print("<input type='button' value='회원정보 삭제하기' />" );
				out.print("</body></html>");
			} else {
				System.out.println(id+"님 로그인");
				out.print("<html><body>");
				out.print(id + "님!! 로그인 하셨습니다.");
				out.print("</body></html>");
			}
		} else {
			out.print("<html><body>");
			out.print("ID와 비밀번호를 입력하세요!!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8090/pro06/test01/login.html'>로그인창으로 이동");
			out.print("</body></html>");
		}
	}

}
