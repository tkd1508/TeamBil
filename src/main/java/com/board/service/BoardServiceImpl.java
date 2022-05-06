package com.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.mapper.BoardMapper;
import com.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j

public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info(board + "============ 등록?? ");
		mapper.insert(board);
	}

	@Override
	public BoardVO get(int bno) { 
		log.info(bno + "============ 번 게시글 검색 ");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info(board + "============ 수정하기 ");
		return mapper.update(board) == 1; // 업데이트 성공시 1을 반환 실패시 0을 반환하게 됨
	}

	@Override
	public boolean remove(int bno) { 
		log.info(bno + "============ 번 게시글 삭제 ");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> list() { 
		log.info("===========service List");
		return mapper.list();
	}

	@Override
	public BoardVO selectBno(BoardVO board) {
		log.info(board + "============ 번 게시글 검색 ");
		return mapper.selectBno(board);
	}

	@Override
	public int listSum() {
		return mapper.listSum();
	}

	@Override
	public List<BoardVO> getListWithPaging(int pstartno) {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("pstartno", pstartno);
		param.put("onepageList", 10);
		return mapper.getListWithPaging(param);
	}

}
