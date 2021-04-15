package org.zerock.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board.domain.Reply;
import org.zerock.board.service.ReplyService;
import org.zerock.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
@RequestMapping("/replys")
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyService service;

	@GetMapping(value = "/read/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Reply>> getList(@PathVariable("bno") Integer bno,@PathVariable("page") int page){
		
		PageDTO pageDTO = new PageDTO(page,10);
		log.info(page);
		return new ResponseEntity<>(service.getReplyList(bno,pageDTO),HttpStatus.OK);
	}
}
