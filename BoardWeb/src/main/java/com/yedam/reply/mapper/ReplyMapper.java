package com.yedam.reply.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO vo);
	ReplyVO selectReply(int replyNo);
	List<ReplyVO> replyListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	int selectCount(int boardNo);
	// 차트 데이터(댓글자, 작성건수)
	List<HashMap<String, Object>> selectReplyCnt();
}
