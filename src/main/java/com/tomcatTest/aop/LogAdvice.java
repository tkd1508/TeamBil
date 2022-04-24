package com.tomcatTest.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component // root-context에 component-scan 
@Log4j
public class LogAdvice {

	// @Before("execution(* com.aop.simple.*Simple.*(..))")
	// @Before("execution(* com.aop.simple.*Simple.*(..))" + " or execution(* com.aop.simple.Simple*.doAdd(String, String)) && args(str1, str2)")
	/*public void logBefore() {
		log.info("=========== LogAdvice 연결 완료");
	}*/
	
	/*
	@Before("execution(* com.aop.simple.Simple*.doAdd(String, String)) && args(str1, str2)")
	
	public void logBeforeWithParam(String str1, String str2) {
		log.info(str1 + "....str1");
		log.info(str2 + "....str2");
		log.info("===== cross-cutting core =====");
		
	}
	*/
	
	/*
	@AfterThrowing(pointcut = "execution(* com.aop.simple.Simple*.*(..))", throwing="exception")
	
	public void logException(Exception exception) {
		log.info("===== Exception....!!! =====");
		log.info("Exception : "+ exception);
		log.info("===== cross-cutting core =====");
		
	}
	*/
	
	@Around("execution(* com.aop.simple.Simple*.*(..))")
	
	public Object logTime(ProceedingJoinPoint pjp) {
		
		long start = System.currentTimeMillis();
		
		log.info(pjp.getTarget()+" ..... 타켓 확인");
		log.info(Arrays.toString(pjp.getArgs())+" ..... param 확인");
		
		// invoke method 이건 뭐지?
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info(pjp.getSignature().getName()+ " ==== 타켓 메소드 이름");
		log.info((end-start)+ " ==== 걸린 시간 (어떤 기능이 시간을 잡아먹는지 확인 할 수 있다.)");
		log.info("===== cross-cutting core =====");
		
		return result;
		
	}
	
}
