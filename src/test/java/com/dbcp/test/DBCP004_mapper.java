package com.dbcp.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tomcatTest.test.TestMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트시 스프링 컨테이너가 생성된다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
// 생성된 스프링 컨테이너에 스프링 bean의 hikariCPconfig의 정보를 읽어오기 위한 위치 설정이 필요하다.
public class DBCP004_mapper {
	
	@Autowired
	private TestMapper testmapper;
	
	@Test
	public void test() throws Exception {
		
		try {
			log.info(testmapper+".....1 연결완료");
			log.info(testmapper.test()+".....2 실행");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
