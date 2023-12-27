package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter(title, content, writer) => insert, 목록페이지.
		// get 요청일때 /post 요청일때
		BoardVO vo = new BoardVO();
		if (req.getMethod().equals("GET")) {

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

			// svc의 addBoard() 활용
		} else if (req.getMethod().equals("POST")) {
			// 파일업로드 포함
			String saveLoc = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			MultipartRequest mr = null;

			try {
				// 1.request 2.saveLoc 3.maxSize 4.인코딩 5.리네임정책
				mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				String writer = mr.getParameter("writer");
				// 파일시스템에 바뀐이름을 가져옴
				String image = mr.getFilesystemName("image");

				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setImage(image);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//svc : addBoard()
		BoardService svc = new BoardServiceMybatis();
		try {
			if (svc.addBoard(vo)) {
				// 등록 성공시 목록페이지로 이동
				// sendRedirect : 페이지 지정가능(외부 페이지 가능)
				resp.sendRedirect("boardList.do");
			} else {
				// 등록 실패시 등록페이지로 이동
				resp.sendRedirect("boardForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
