package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

public class MainExe {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO vo : list) {
//			System.out.println(vo.toString());
//		}
		BoardVO vo = new BoardVO();
		vo.setTitle("tttttt");
		vo.setContent("cdcdcdcd");
		vo.setWriter("wwwwwwww");
		vo.setBoardNo(4);
		
		if(mapper.updateBoard(vo)==1) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
	}
}
