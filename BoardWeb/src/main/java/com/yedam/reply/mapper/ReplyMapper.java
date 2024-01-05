package com.yedam.reply.mapper;

import java.util.List;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo);
	int deleteReply(int replyNo);
}
