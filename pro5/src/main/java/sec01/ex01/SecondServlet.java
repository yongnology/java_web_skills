package sec01.ex01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{

	@Override
	public void init() throws ServletException{
		System.out.println("init 메소드 호출>>>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출 >>>");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory 메소드 호출 >>>");
	}
}
