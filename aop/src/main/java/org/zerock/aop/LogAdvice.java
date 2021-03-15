package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {

	//절대 손으로 치지않는다. 에러가 잘난다.
	//JUnit의 Before가 있으니 import를 조심하자.
	@Before(value =  "execution(* org.zerock..*.*Service*.*(..))")
	public void logBefore() {
		log.info("----------------------------");
	}
	
	//JoinPoint는 그냥 실행못한다
	//proceed를 하는것보다 성능이 조금더 낫다.
	//controller는 Around를 쓰지말고 before만 쓰는게 낫다.
	@Before(value =  "execution(* org.zerock..*.*Controller*.*(..))")
	public void logBeForeController(JoinPoint jp) {
		log.info("----------------------------");
		//메서드의 이름
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		log.info(methodName);
		log.info(Arrays.toString(args));
	}
	
	
	//시큐리티를 체크하는 코드라고 생각하자.
	//@Around(value =  "execution(* org.zerock..*.*Service*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		
		log.info(pjp.getSignature());
		log.info(Arrays.toString(pjp.getArgs()));
		log.info(pjp.getThis());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("end...............");
		
		long end = System.currentTimeMillis();
		
		log.info("Time : " + (end - start));
		
		return result;
	}
	
	
	//시큐리티를 체크하는 코드라고 생각하자.
	@Around(value =  "execution(* org.zerock..*.*Controller*.*(..))")
	public Object logTime2(ProceedingJoinPoint pjp) {
		
		String methodName = pjp.getSignature().getName();
		
		log.info(pjp.getSignature());
		log.info(methodName+":::::::"+Arrays.toString(pjp.getArgs()));
		log.info(pjp.getThis());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("end...............");
		
		long end = System.currentTimeMillis();
		
		log.info(methodName +"Time : " + (end - start));
		
		return result;
	}
	
	
}
