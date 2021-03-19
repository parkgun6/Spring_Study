package org.geon.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class SecurityTests {

	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Test
	public void test1() {
		log.info(pwEncoder);
	}
	
	@Test
	public void test2() {
		String pw = "member";
		String enPw = pwEncoder.encode(pw);
		
		log.info(enPw);
		//$2a$10$ox7YicwBX1n3NJAWH.Fge.NAZfwRqlZf8tI2sn.JNClDjqcqydr5i
	}
}
