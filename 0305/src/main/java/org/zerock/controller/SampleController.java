package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.TimeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

//스프링 빈등록이 됐다.
@Controller
@Log4j
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
	
	private final TimeMapper timeMapper;
	
	//파라미터의 제약을 받지않는다.
	//기존 스프링1,2버전은 불가능한 코드
	@RequestMapping("/doA")
	public void doA() {
		log.info("doA.....");
	}
	
	@GetMapping("/doB")
	public void doB(Model model) {//화면에 무언가를 띄우고싶다면 model을 추가해준다.
		log.info("doB.....");
		String now = timeMapper.getTime();
		log.info(now);
		model.addAttribute("time",now);//request.setAttribute
		
	}
}
