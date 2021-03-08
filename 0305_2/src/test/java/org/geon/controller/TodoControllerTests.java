package org.geon.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.log4j.Log4j;

@Log4j // 상속못받아서 따로 선언해야한다.
public class TodoControllerTests extends AbstractControllerTests {

	@Test
	public void test1() throws Exception {
		log.info(mockMvc);
		
			mockMvc.perform(
					MockMvcRequestBuilders.post("/todo/add")
					.param("title","sample")
					.param("complete", "true"));
		
	}
	
	

}