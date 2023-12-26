package com.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//id, pw -> 정상 -> 목록
		//       -> 비정상 -> 로그인화면
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		MemberService svc = new MemberServiceImpl();
		
		MemberVO vo = svc.login(id, pw);
		
		if(vo != null) {
			//세션객체 로그인 정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("logid", vo.getId());
			session.setAttribute("logName", vo.getName());
			//세션객체에 로그인 아이디값 저장
		}
		
		try {
		if(vo != null) {
			resp.sendRedirect("boardList.do");
		}else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요");
			req.getRequestDispatcher("WEB-INF/member/logForm.jsp").forward(req, resp);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
