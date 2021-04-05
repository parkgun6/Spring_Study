package org.geon.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("service")
@Log4j
public class ServiceController {

	
	@GetMapping({"/","/main"})
	public void main() {
		log.info("test......................");
	}
	
	@GetMapping({"/","/state"})
	public void state() {
		log.info("test......................");
	}
	
	@GetMapping({"/","/request"})
	public void request() {
		log.info("test......................");
	}
}
