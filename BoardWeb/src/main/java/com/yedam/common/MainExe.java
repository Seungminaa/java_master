package com.yedam.common;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.member.mapper.MemberMapper;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;
import com.yedam.reply.mapperImpl.ReplyServiceImpl;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.vo.PageDTO;

public class MainExe {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO vo : list) {
//			System.out.println(vo.toString());
//		}
		ReplyService svc = new ReplyServiceImpl();
		svc.replyListPaging(2, 3).forEach(reply -> System.out.println(reply));
		
		int total = 175;
		PageDTO dto = new PageDTO(2, total);
		
		System.out.println(dto.toString());
		
		List<HashMap<String,Object>> list = svc.chartData();
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));
	}
}
