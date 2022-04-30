package com.board.mapper;

import java.util.HashMap;
import java.util.List;

import com.board.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> list();
	public void insert(BoardVO board);
	public BoardVO read(int bno);
	public int delete(int bno);
	public int update(BoardVO board); 
	public BoardVO selectBno(BoardVO board);
	
	// public List<BoardVO> paginglist();
	public int listSum();
	public List<BoardVO> getListWithPaging( HashMap<String, Integer> param );
	
}
