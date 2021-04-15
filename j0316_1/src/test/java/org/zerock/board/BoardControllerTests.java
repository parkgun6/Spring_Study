package org.zerock.board;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.log4j.Log4j;


@Log4j
public class BoardControllerTests extends AbstractControllerTests{

	private MockMvc mockMvc;
	
//	@Before
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(new BoardController(null)).build();
//	}
	
	
	@Test
	public void testUpdate() throws Exception {
		log.info(mockMvc);
		
		mockMvc.perform(
		MockMvcRequestBuilders.get("/board/read")
		.param("bno","130"))
		.andDo(print());
	
		
	}
	
}
