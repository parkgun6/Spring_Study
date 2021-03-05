package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@WebAppConfiguration 있어야지만 웹 테스트 가능
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class SampleControllerTests {

	//얘한테 url을 던지면 알아서 찾아서 실행시켜준다.
	@Autowired
	WebApplicationContext ctx;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info("setup...........");
	}
	
	@Test
	public void test1() {
		log.info(ctx);
		log.info(mockMvc);
	}
	
	@Test//서버를 띄우지 않고도 가상의 mvc를 만들어서 테스트를 할 수 있다. 하지만 한글테스트가 불가능하다.
	public void testDoA() throws Exception{
		//static import를 했기때문에 get만써도 동작한다.
		mockMvc.perform(get("/sample/doB"));
	}
}
