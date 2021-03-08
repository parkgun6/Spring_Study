package org.geon.controller;

import org.geon.mapper.TodoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo")
@Log4j
@RequiredArgsConstructor
public class TodoController {

	@NonNull
	private TodoMapper mapper;
	
	@GetMapping("/add")
	public void add() {
		log.info("get........");
	}
	@GetMapping("/list")
	public void list() {
		log.info("get........");
	}
}
