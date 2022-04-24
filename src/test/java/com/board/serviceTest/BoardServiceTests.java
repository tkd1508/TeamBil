package com.board.serviceTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.service.BoardService;
import com.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service); // 이건 뭐지?
	}
	
	// register
	
	@Test public void testRegister() {
		BoardVO dto = new BoardVO(); 
		dto.setTitle("새로 작성하는 글"); dto.setContent("내용"); dto.setWriter("newbie");
		service.register(dto);
		log.info(dto.getBno()+" ================= 새로 생성된 글 번호");
		}
	
	// selectAll
	@Test public void testList() {
		log.info(service.list()+" ================= list"); // toString 같은 느낌
		service.list().forEach(board -> log.info(board +" ================= forEach")); // 하나하나의 값 출력
		}
	
	@Test public void testGet() {
		log.info(service.get(4)+" ================= getread");
		}
	
	/*
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
	
	
}
