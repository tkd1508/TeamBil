package com.rely.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.reply.mapper.ReplyMapper;
import com.reply.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class ReplyMapperTests {
	private int[] bnoArr = {1,2,3,4,5};
	@Autowired ReplyMapper replymapper;
	
	@Test
	public void testUpdate() {
		int targetRno=10;
		ReplyVO vo=replymapper.read(targetRno);
		vo.setReply("Update Reply");
		
		int count = replymapper.update(vo);
		
		log.info("UPDATE COUNT:"+count);
	}
	
	@Test
	public void testDelete() {
		int targetRno =1;
		replymapper.delete(targetRno);
	}
	
	@Test
	public void testRead() {
		int targetRno = 5;
		ReplyVO vo = replymapper.read(targetRno);
		
		log.info(vo);
	}
	
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i % 5 ]);
			vo.setReply("댓글 테스트"+i);
			vo.setReplyer("replyer"+i);
			
			replymapper.insert(vo);
		});
	}
	
	@Test
	public void testMapper() {
		log.info(replymapper);
	}
}
