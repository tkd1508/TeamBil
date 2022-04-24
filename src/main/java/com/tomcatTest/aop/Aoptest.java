package com.tomcatTest.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component // root-context에 component-scan 
@Log4j
public class Aoptest {

	@Around("execution(* com.tomcatTest.test.*HomeController.*(..))" + " or execution(* com.tomcatTest.test.*TestMapper.*(..))")
	
	public Object logTime( ProceedingJoinPoint pjp) {
		log.info("... @Around multi-settion 이전 : ");
		long start = System.currentTimeMillis();
		log.info("... Target : "+ pjp.getTarget());
		log.info("... param : "+ Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try { result = pjp.proceed(); } catch (Throwable e) { e.printStackTrace(); }
		
		long end = System.currentTimeMillis();
		log.info("... Time : "+ (end+start));
		log.info("... @Around multi-settion 이후 : ");
		return result;
	}
}