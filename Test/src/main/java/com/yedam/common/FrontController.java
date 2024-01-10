package com.yedam.common;
// 컨트롤러 : url -> 서블릿 실행

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.command.OtherLoginControl;
import com.yedam.member.command.SignInControl;
import com.yedam.member.command.SignUpControl;


//@WebServlet("*.do")
public class FrontController extends HttpServlet{
	//생명주기 : 생성자 -> init() -> service() -> destroy()
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<String, Control>();
		
	}
	
	//init()
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 메인페이지
		map.put("/main.do", new MainControl());
		map.put("/signIn.do", new SignInControl());
		//카카오 로그인
		map.put("/otherLogin.do", new OtherLoginControl());
		// 회원가입 페이지
		map.put("/signUp.do", new SignUpControl());
		
	}
	
	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//http://localhost/BoardWeb/main.do -> mainControl
		String uri = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = uri.substring(context.length()); //main.do
		System.out.println(path); //main.do
		
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	//destroy()
	@Override
	public void destroy() {
		
	}
}
