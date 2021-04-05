package org.geon.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/business")
@Log4j
public class BusinessController {

	
	@GetMapping({"/","/main"})
	public void test() {
		log.info("test......................");
	}
}
