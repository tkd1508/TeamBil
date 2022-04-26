package com.board.service;

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
		// TODO Auto-generated method stub
		log.info(board + "============ 등록?? ");
		mapper.insert(board);
	}

	@Override
	public BoardVO get(int bno) { // TODO Auto-generated method stub
		log.info(bno + "============ 번 게시글 검색 ");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info(board + "============ 수정하기 ");
		return mapper.update(board) == 1; // 업데이트 성공시 1을 반환 실패시 0을 반환하게 됨
	}

	@Override
	public boolean remove(int bno) { // TODO Auto-generated method stub
		log.info(bno + "============ 번 게시글 삭제 ");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> list() { // TODO Auto-generated method stub
		log.info("===========service List");
		return mapper.list();
	}

}
