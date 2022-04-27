package com.board.service;

import java.util.List;

import com.board.dto.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	public BoardVO get(int bno);
	public boolean modify(BoardVO board);
	public boolean remove(int bno);
	public List<BoardVO> list();
	
}
