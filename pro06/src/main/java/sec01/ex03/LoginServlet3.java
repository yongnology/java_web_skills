package sec01.ex03;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {

    public LoginServlet3() {
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	System.out.println("아이디 : " + user_id);
	System.out.println("비밀번호 : "+ user_pw);
	
	}

}
