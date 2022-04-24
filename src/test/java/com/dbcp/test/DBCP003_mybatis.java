package com.dbcp.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트시 스프링 컨테이너가 생성된다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
// 생성된 스프링 컨테이너에 스프링 bean의 hikariCPconfig의 정보를 읽어오기 위한 위치 설정이 필요하다.
public class DBCP003_mybatis {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void test() throws Exception {
		
		try {
		Connection conn = ds.getConnection();
		SqlSession session = sqlFactory.openSession();
			log.info(sqlFactory+".....1 ");
			log.info(session+".....2 ");
			
		if(conn != null) {
			log.info(conn+".....3 연결완료");
			
		} }catch(Exception e) {
			e.printStackTrace();
		}
	}
}
