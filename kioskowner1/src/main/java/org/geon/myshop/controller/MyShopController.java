package org.geon.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("myshop")
@Log4j
public class MyShopController {

	
	@GetMapping({"/","/main"})
	public void main() {
		log.info("test......................");
	}
	
	@GetMapping({"/shopinfo"})
	public void shopInfo() {
		log.info("test......................");
	}
	
	@GetMapping({"/userinfo"})
	public void userInfo() {
		log.info("test......................");
	}
	
	@GetMapping({"/menu/bestmenu"})
	public void bestMenu() {
		log.info("test......................");
	}
	
	@GetMapping({"/","/eventmenu"})
	public void eventMenu() {
		log.info("test......................");
	}
	
	@GetMapping({"/","/mainmenu"})
	public void mainMenu() {
		log.info("test......................");
	}
	
	@GetMapping({"/","/timemenu"})
	public void timeMenu() {
		log.info("test......................");
	}
	
}
