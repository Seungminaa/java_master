package com.yedam.book.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.book.service.BookService;
import com.yedam.book.serviceImpl.BookServiceImpl;
import com.yedam.book.vo.BookVO;
import com.yedam.common.Control;

public class BookListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=utf-8");
				BookService svc = new BookServiceImpl();
				List<BookVO> list = svc.bookList();
				
				req.setAttribute("bookList", list);
		
		try {
			req.getRequestDispatcher("todo/bookList.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
