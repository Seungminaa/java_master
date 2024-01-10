package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SubControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("서브컨트롤");
		
		
	}

}
