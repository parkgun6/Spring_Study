package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.TotoDTO;
import org.zerock.entity.Todo;
import org.zerock.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*")//todo로 들어오는 모든애를 다 받아들인다. 요즘엔("/todo")를 사용한다.
@Log4j
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoMapper mapper;
	
	@GetMapping("/add")//스프링4.3부터 생겼다. 원래는 리퀘스트 맵핑이다.
	public void add() {
		log.info("get............");
	}
	
	@PostMapping("/add")
	public String addPost(TotoDTO todoDTO) {
		
		log.info(todoDTO);
		
		//todoDTO에서 todo로 바꿔주었다.
		Todo todo = Todo.builder()
				.title(todoDTO.getTitle())
				.complete(todoDTO.isComplete())
				.build();
		
		mapper.insert(todo);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping("list")
	public void list() {
		log.info("list...........");
	}
	
}
