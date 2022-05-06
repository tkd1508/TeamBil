package com.board.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.mapper.BoardMapper;
import com.board.mapper.BoardSearchMapper;
import com.board.vo.BoardVO;
import com.board.vo.Cirteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class boardTest {
	@Autowired BoardSearchMapper searchMapper;

	@Test
	public void testTotalSearch() {
		log.info(searchMapper.getTotalList()+"================= 전체 글 목록list");
	}
	
	@Test
	public void testSearch() {
		List<BoardVO> dto = searchMapper.getSearchList("T" , "aaa");
		log.info(dto+"================= 검색 글 목록list");
	}
	
	
}
