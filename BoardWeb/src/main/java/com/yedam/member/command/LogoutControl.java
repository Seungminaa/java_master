package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		// 로그아웃, 세선삭제.
		// invalidate() -> 저장된 세션정보 전체를 삭제
		// removeAttribute(String name) -> name에 저장된 세션정보만 삭제
		HttpSession session = req.getSession();
		session.invalidate();
		try {
			resp.sendRedirect("loginForm.do");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
