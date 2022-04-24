package com.board.mapper;

import java.util.List;

import com.board.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> list();
	public void insert(BoardVO board);
	public BoardVO read(int bno);
	public int delete(int bno);
	public int update(BoardVO board); // 그냥 테스트겸 해놨어
	// 브릿지 테스트용
}
