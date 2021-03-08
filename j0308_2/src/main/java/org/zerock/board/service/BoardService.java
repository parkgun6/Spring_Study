package org.zerock.board.service;

import org.zerock.board.domain.Board;
import org.zerock.board.dto.BoardDTO;

public interface BoardService {

	//인터페이스도 객체를 가질수 있다.
	default Board toDomain(BoardDTO dto) {
		
		//DTO에 선언하지않고 서비스에 Domain을 리턴하는 메서드를 만들어놓는다.
		Board.builder()
			.bno(dto.getBno())
			.title(dto.getTitle())
			.content(dto.getContent())
			.writer(dto.getWriter())
			.regDate(dto.getRegDate())
			.updatedate(dto.getUpdatedate()).build();
		return null;
	}
}
