package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		if (req.getMethod().equals("GET")) {
				RequestDispatcher rd = req.getRequestDispatcher("member/signUpForm.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else if(req.getMethod().equals("POST")) {	
			MemberService service = new MemberServiceImpl();
			String id = req.getParameter("id");
			String pass = req.getParameter("pass");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String addr = req.getParameter("addr");
			String phone = req.getParameter("phone");
			String gender= req.getParameter("gender");
			if(gender.equals("female")){
				gender = "f";
			}else if(gender.equals("male")) {
				gender = "m";
			}
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pass);
			vo.setName(name);
			vo.setEmail(email);
			vo.setAdress(addr);
			vo.setPhone(phone);
			vo.setGender(gender);
			System.out.println(vo);
			if(service.addMember(vo)) {
				try {
					resp.sendRedirect("main.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("err");
				try {
					resp.sendRedirect("signUp.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
