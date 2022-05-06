package com.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.board.vo.Cirteria;
import com.reply.vo.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read(int rno);
	public int delete (int rno);
	public int update(ReplyVO reply);
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Cirteria cri,
			@Param("bno") int bno);
}
