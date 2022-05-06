package com.board.service;

import java.util.List;

import com.board.vo.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	public BoardVO get(int bno);
	public boolean modify(BoardVO board);
	public boolean remove(int bno);
	public List<BoardVO> list();
	public BoardVO selectBno(BoardVO board);
	
	// public List<BoardVO> paginglist();
		public int listSum();
		public List<BoardVO> getListWithPaging( int pstartno );
	
}
