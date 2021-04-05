package org.geon.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/customer")
@Log4j
public class CustomerController {

	
	@GetMapping({"/qna"})
	public void qna() {
		log.info("test......................");
	}
	
	@GetMapping({"/faq"})
	public void faq() {
		log.info("test......................");
	}
}
