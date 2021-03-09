package org.zerock.board.service;

import java.util.List;

import org.zerock.board.domain.Board;
import org.zerock.board.dto.BoardDTO;
import org.zerock.common.dto.PageDTO;

public interface BoardService {
	
	
	//페이지를 만들어주는 메서드다.
	List<BoardDTO> getPageList(PageDTO pageDTO);
	
	int getTotalCount();
	
	//완벽하게 해주려면 트랜잭션을 이용해야한다.
	void register(BoardDTO boardDTO);
	
	//default메서드는 override를 하지않는다.
	//인터페이스도 객체를 가질수 있다.
	default Board toDomain(BoardDTO dto) {
		//DTO에 선언하지않고 서비스에 Domain을 리턴하는 메서드를 만들어놓는다.
		//mapper에서 vo로 나온값을 dto로 치환해준다.
		return Board.builder()
			.bno(dto.getBno())
			.title(dto.getTitle())
			.content(dto.getContent())
			.writer(dto.getWriter())
			.regDate(dto.getRegDate())
			.updatedate(dto.getUpdatedate()).build();
		
	}
}
