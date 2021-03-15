package org.zerock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.service.BoardService;
import org.zerock.service.SampleService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ServiceTest {

	@Autowired
	SampleService service;
	
	@Autowired
	BoardService boardService;
	
	@Test
	public void show() {
		log.info(service.getClass().getName());
		
		log.info(service.doA());

	}
	
	@Test
	public void boardTest() {
		boardService.getTime();
	}
	
}
