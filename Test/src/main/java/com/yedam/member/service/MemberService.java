package com.yedam.member.service;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public boolean addMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO memberInfo(String id);
}
