package com.board.serviceTest;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.service.BoardService;
import com.board.vo.BoardVO;
import com.board.vo.Cirteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	/*
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service); // 이건 뭐지?
	}
	*/
	/*
	// register
	@Test public void testRegister() {
		BoardVO dto = new BoardVO(); 
		dto.setTitle("새로 작성하는 글"); dto.setContent("내용2"); dto.setWriter("newbie");
		service.register(dto);
		log.info(dto.getBno()+" ================= 새로 생성된 글 번호??");
		//service.selectBno(dto);
		//log.info(service.selectBno(dto).getBno()+ "=========== 새로 생성된 글 번호?? 모달에 n번째 등록 알림 안하기로함.. 그래서 이거는 쓸모없어짐."); 
		}
	
	*/
	/*
	// selectAll
	@Test public void testList() {
		log.info(service.list()+" ================= list"); // toString 같은 느낌
		service.list().forEach(board -> log.info(board +" ================= forEach")); // 하나하나의 값 출력
		}
	*/
	
	/*
	@Test public void testGet() {
		log.info(service.get(6)+" ================= getread");
		}
	
	
	@Test public void testDelete() {
		log.info(service.remove(2)+" ================= delete"); // 삭제 완료되면 1을 반환한다.
		}
	
	@Test public void testUpdate() {
		BoardVO dto = new BoardVO();
		
		if (dto == null) { return; }
		
		dto.setTitle("수정하는 글");
		log.info(service.modify(dto)+" ================= 수정 결과 출력"); 
		}
	*/
	/*
	 @Test public void testGetList() {
		  // 
	  
	  service.listSum();
	  log.info(".......3.."+service);
	  log.info(".......888.."+service.getListWithPaging(0)); // 9~0 까지 10개 출력
	  
	  }
	 
	 @Test public void testPaging() {
		  // 
	  HashMap<String, Integer> param = new HashMap<String, Integer>();
	  param.put("pstartno", 0);
	  param.put("onepageList", 10);
	  
	  service.getListWithPaging(10);
	  log.info(".......boardmapper 3.."+service);
	  log.info(".......listSum 2.."+service.listSum());
	  
	  }
	 */
	 @Test
	public void testSearch() {
		Cirteria cri = new Cirteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = service.getListWithPaging(1);
		list.forEach(board -> log.info("..............."+board));
	}
	
}
