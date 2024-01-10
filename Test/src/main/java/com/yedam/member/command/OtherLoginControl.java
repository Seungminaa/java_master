package com.yedam.member.command;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class OtherLoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();
		String id = req.getParameter("id");
		MemberVO vo = new MemberVO();
		vo = service.memberInfo(id);
		// db에 이번에 접속한 사람의 정보가 없다면 : 첫 접속이면
		if(vo==null) {
			vo = new MemberVO();
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			if(gender.equals("male")||gender.equals("M")) {
				gender="m";
			}else {
				gender="f";
			}
			vo.setId(id);
			vo.setPw(id);
			vo.setName(name);
			vo.setEmail(email);
			vo.setGender(gender);
			
			HttpSession session = req.getSession();
			session.setAttribute("memberInfo", vo);
			RequestDispatcher rd = req.getRequestDispatcher("member/signUpForm.tiles");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else { // 접속한 기록이 있어서 정보를 가지고 있다면
			HttpSession session = req.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("Responsibility", vo.getResponsibility());
			session.setAttribute("mno", vo.getMemberNo());
			session.setAttribute("memberNo", vo.getMemberNo());
			try {
				resp.sendRedirect("main.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
