package org.geon.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info(auth);
		model.addAttribute("msg","권한이 없습니다.");
	}
	
	@GetMapping("/customLogin")
	public void login(String error, String logout, Model model) {
		log.info(error);
		log.info(logout);
		
		if(error != null) {
			model.addAttribute("error","로그인에 실패하였습니다.");
		}
		if(logout != null) {
			model.addAttribute("logout","로그아웃 되었습니다.");
		}
	}
	
	@GetMapping("/customLogout")
	public void logout() {
		log.info("logout.....................");
	}
}
