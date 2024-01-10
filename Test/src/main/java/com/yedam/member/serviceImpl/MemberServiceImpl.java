package com.yedam.member.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.mapper.MemberMapper;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return mapper.loginCheck(vo);
	}

	@Override
	public MemberVO memberInfo(String id) {
		// TODO Auto-generated method stub
		return mapper.memberInfo(id);
	}

	@Override
	public boolean addMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertMember(vo)>0;
	}
	
}
