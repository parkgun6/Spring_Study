package org.zerock.controller;

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
		log.info("accessDenied : " + auth);
		model.addAttribute("msg", "권한이 없는 사용자입니다.");
	}
	
	@GetMapping("/customLogin")
	//에러와 로그아웃은 파라미터로 무조건 받아야한다.
	public void loginInput(String error, String logout, Model model) {
		
		log.info("error : "+ error);
		log.info("logout : "+ logout);
		
		//로그아웃
		if(logout != null) {
			model.addAttribute("logout","LogOut !!!");
		}
	}
	
	@GetMapping("/customLogout")
	//로그아웃은 파라미터에 들어가는것이 없다.
	public void customLogout() {
		
	}
}
