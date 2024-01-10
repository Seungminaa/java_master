package com.yedam.member.mapper;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO memberInfo(String id);
	public int insertMember(MemberVO vo);
}
