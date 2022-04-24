package com.board.mapper;

import java.util.List;

import com.board.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> list();
	public void insert(BoardVO board);
	public BoardVO read(int bno);
	public int delete(int bno);
	
}
