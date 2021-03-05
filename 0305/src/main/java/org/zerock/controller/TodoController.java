package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.TodoDTO;
import org.zerock.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*")//todo로 들어오는 모든애를 다 받아들인다. 요즘엔("/todo")를 사용한다.
@Log4j
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoMapper mapper;
	
	@GetMapping({"/add","/add2"})//스프링4.3부터 생겼다. 원래는 리퀘스트 맵핑이다.
	public void add() {
		log.info("get............");
	}
	
//	@PostMapping(value="/add",produces = "text/plain")
//	@ResponseBody
//	public String addPost(TodoDTO todoDTO) {
//		
//		log.info("-----------------------");
//		log.info(todoDTO);
//		
//		return "success";
//	}
	@PostMapping("add")
	public String addPost(@Valid TodoDTO todoDTO, BindingResult result, RedirectAttributes rttr) {
		
		log.info("-----------------------");
		log.info(todoDTO);
		//검증이 잘못됐다는뜻
		if(result.hasErrors()) {
			log.info("has errors"+result);
			return "/todo/add";
		}
		
		//예전엔 파라미터에 메세지를 이렇게 붙여줬다.
		//return "redirect:/todo/list?msg=success";
		
		//1회성으로 세션에 넣어준다.
		rttr.addFlashAttribute("msg","success");
		return "redirect:/todo/list";
	}
	//이방식을 이용해서 ajax를 쓸때도 validation을 사용할 수 있다.
	@PostMapping("add2")
	@ResponseBody
	public Object add2Post(@Valid TodoDTO todoDTO, BindingResult result) {
		
		log.info("-----------------------");
		log.info(todoDTO);
		//검증이 잘못됐다는뜻
		if(result.hasErrors()) {
			log.info("has errors"+result);
			return result.getAllErrors();
		}
		return "redirect:/todo/list";
	}
	
	@GetMapping("list")
	public void list(Model model) {
		log.info("list...........");
		
		List<TodoDTO> list = IntStream.rangeClosed(1, 10).mapToObj(i -> {
			//맵핑해주는것 DTO를 만든다
			TodoDTO dto = new TodoDTO();
			dto.setTno(i);
			dto.setTitle("aaaa"+ i);
			return dto;
		}).collect(Collectors.toList());
		
		model.addAttribute("list",list);
	}
	
}
