package com.dbcp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aop.simple.TxService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트시 스프링 컨테이너가 생성된다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
// 생성된 스프링 컨테이너에 스프링 bean의 hikariCPconfig의 정보를 읽어오기 위한 위치 설정이 필요하다.
public class Tx_InsertTest {
	
	@Setter(onMethod_ = {@Autowired})
	private TxService txservice;
	
	@Test
	public void test() {
		String str = "Starry" + "Starry night" + "Paint your palette blue and grey" + "Look out on a summer's day";
		
		log.info(str.getBytes().length);
		try {
			txservice.addData(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
