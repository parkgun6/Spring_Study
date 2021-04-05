package org.geon.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("shop")
@Log4j
public class ShopController {

	
	@GetMapping({"/","/accept"})
	public void test() {
		log.info("test......................");
	}
}
