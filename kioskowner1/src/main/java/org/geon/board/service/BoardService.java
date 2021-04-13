package org.geon.board.service;

import java.util.List;

import org.geon.board.domain.BoardVO;
import org.geon.board.dto.BoardDTO;
import org.geon.common.dto.PageDTO;

public interface BoardService {

	List<BoardVO> getPageList(PageDTO pageDTO,BoardVO boardVO);
	
	int getTotalCount(PageDTO pageDTO);
	
	void register(BoardDTO boardDTO);
	
	BoardDTO readOne(Long bno);
	
	void update(BoardDTO boardDTO);
	
	void delete(Long bno);
	
	default BoardVO toDomain(BoardDTO dto) {
		return BoardVO.builder()
			.bano(dto.getBano())
			.title(dto.getTitle())
			.content(dto.getContent())
			.writer(dto.getWriter())
			.category(dto.getCategory())
			.enabled(dto.getEnabled())
			.regdate(dto.getRegdate())
			.updateDate(dto.getUpdateDate()).build();
	}
	
	default BoardDTO toDTO(BoardVO board) {

		BoardDTO dto = new BoardDTO();
		dto.setBano(board.getBano());
		dto.setTitle(board.getTitle());
		dto.setContent(board.getContent());
		dto.setWriter(board.getWriter());
		dto.setCategory(board.getCategory());
		dto.setEnabled(board.getEnabled());
		dto.setRegdate(board.getRegdate());
		dto.setUpdateDate(board.getUpdateDate());
		return dto;
	}
}
