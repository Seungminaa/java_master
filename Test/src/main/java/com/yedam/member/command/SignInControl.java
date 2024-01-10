package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;


public class SignInControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		if (req.getMethod().equals("GET")) {
			//페이지 이동(forward)
			RequestDispatcher rd = req.getRequestDispatcher("member/signInForm.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else if(req.getMethod().equals("POST")) {	
			MemberService service = new MemberServiceImpl();
			String id = req.getParameter("id");
			String pw = req.getParameter("pass");
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pw);
			vo = service.loginCheck(vo);
			if(vo!=null) {
				HttpSession session = req.getSession();
				
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
				session.setAttribute("mno", vo.getMemberNo());
				
				try {
					resp.sendRedirect("main.do");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("member/signInForm.tiles");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
