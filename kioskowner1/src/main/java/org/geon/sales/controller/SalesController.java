package org.geon.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("sales")
@Log4j
public class SalesController {

	
	@GetMapping({"/main"})
	public void main() {
		log.info("test......................");
	}
	
	@GetMapping({"/today"})
	public void today() {
		log.info("test......................");
	}
	
	@GetMapping({"/hour"})
	public void hour() {
		log.info("test......................");
	}
	
	@GetMapping({"/time"})
	public void time() {
		log.info("test......................");
	}
}
