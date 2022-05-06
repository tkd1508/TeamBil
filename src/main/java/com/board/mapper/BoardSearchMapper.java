package com.board.mapper;

import java.util.List;

import com.board.vo.BoardVO;

public interface BoardSearchMapper {

	public List<BoardVO> getTotalList();
	public List<BoardVO> getSearchList(String type, String keyword);
	public int ListCount(String type);
	
}
