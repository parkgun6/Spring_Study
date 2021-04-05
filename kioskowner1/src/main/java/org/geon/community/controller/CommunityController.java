package org.geon.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/community")
@Log4j
public class CommunityController {

	
	@GetMapping({"/free"})
	public void test() {
		log.info("test......................");
	}
}
