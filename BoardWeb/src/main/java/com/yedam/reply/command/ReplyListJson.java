package com.yedam.reply.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.mapperImpl.ReplyServiceImpl;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.vo.ReplyVO;

public class ReplyListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// json 테이터를 생성해서 반환
		// [{"replyNo":4,"boardNo":2,...},{}]
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno));
		int cnt = list.size();
		String json = "[";
		for(int i=0;i<cnt;i++) {
			json += "{\"replyNo\":" + list.get(i).getReplyNo() + ",\"boardNo\":" 
					+ list.get(i).getBoardNo() + ",\"reply\":\"" 
					+ list.get(i).getReply() + "\",\"replyer\":\"" 
					+ list.get(i).getReplyer() + "\"}";
			if(i != cnt-1) {
				json += ",";
			}
		}
		
		json += "]";
		
		try {
			resp.getWriter().print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
