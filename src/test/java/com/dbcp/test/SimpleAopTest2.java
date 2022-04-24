package com.dbcp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aop.simple.Simple;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트시 스프링 컨테이너가 생성된다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class SimpleAopTest2 {
	@Setter(onMethod_ = @Autowired)
	private Simple simple;
	
	@Test
	public void test() {
		log.info(simple);
		log.info(simple.getClass().getName()+" ====== 프록시 객체가 정상적으로 만들어졌는지 확인");
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info(simple.doAdd("123", "456"));
	}
	
}
