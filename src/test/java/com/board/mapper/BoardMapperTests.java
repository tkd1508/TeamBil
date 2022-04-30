package com.board.mapper;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.mapper.BoardMapper;
import com.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardMapperTests {
	@Autowired BoardMapper boardmapper;
	
	// insert
	
	@Test public void testInsert() {
		BoardVO dto = new BoardVO(); 
		dto.setTitle("새로 작성하는 글"); dto.setContent("내용"); dto.setWriter("newbie");
		boardmapper.insert(dto);
		log.info(dto+" ================= insert");
		}
	
	// selectAll
	@Test public void testList() {
		log.info(boardmapper.list()+" ================= list"); // toString 같은 느낌
		boardmapper.list().forEach(board -> log.info(board +" ================= forEach")); // 하나하나의 값 출력
		}
	/*
	@Test public void testRead() {
		BoardVO dto = boardmapper.read(3);
		log.info(dto+" ================= read");
		}
	
	@Test public void testDelete() {
		log.info(boardmapper.delete(2)+" ================= delete"); // 삭제 완료되면 1을 반환한다.
		}
	
	@Test public void testUpdate() {
		BoardVO dto = new BoardVO();
		dto.setBno(3);
		dto.setTitle("수정하는 글"); dto.setContent("내용 수정"); dto.setWriter("user00");
		int count = boardmapper.update(dto);
		log.info(count +" ================= update");
		}
		*/
	
	@Test public void testPaging() {
		  // 
	  HashMap<String, Integer> param = new HashMap<String, Integer>();
	  param.put("pstartno", 0);
	  param.put("onepageList", 10);
	  
	  boardmapper.getListWithPaging(param);
	  log.info(".......boardmapper 3.."+boardmapper);
	  log.info(".......listSum 2.."+boardmapper.listSum());
	  
	  }
	
}
