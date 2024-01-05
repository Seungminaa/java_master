package com.yedam.reply.service;

import java.util.List;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO vo);
	ReplyVO getReply(int replyNo);
	List<ReplyVO> replyListPaging(int boardNo,int page);
	
}
