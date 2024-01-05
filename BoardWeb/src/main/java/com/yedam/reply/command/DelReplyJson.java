package com.yedam.reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.mapperImpl.ReplyServiceImpl;
import com.yedam.reply.service.ReplyService;

public class DelReplyJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String rno = req.getParameter("rno");

		ReplyService svc = new ReplyServiceImpl();

		try {
			if (svc.removeReply(Integer.parseInt(rno))) {
				// {"retCode": "OK"}
				resp.getWriter().print("{\"retCode\": \"OK\"}");
			} else {
				// {"retCode": "NG"}
				resp.getWriter().print("{\"retCode\": \"NG\"}");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
