package org.gun.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {

	//절대 손으로 치지않는다. 에러가 잘난다.
	//JUnit의 Before가 있으니 import를 조심하자.
	@Before(value =  "execution(* org.zerock..*.*Service*.*(..))")
	public void logBefore() {
		log.info("----------------------------");
	}
	
}
