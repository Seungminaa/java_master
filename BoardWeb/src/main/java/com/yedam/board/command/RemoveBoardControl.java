package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.common.Control;

public class RemoveBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// param("bno") - 삭제 - 목록
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceMybatis();

		try {
			if (svc.remBoard(Integer.parseInt(bno))) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("removeForm.do");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
