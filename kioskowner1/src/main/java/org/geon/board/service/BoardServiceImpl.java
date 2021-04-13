package org.geon.board.service;

import java.util.List;

import org.geon.board.domain.BoardVO;
import org.geon.board.dto.BoardDTO;
import org.geon.board.mapper.BoardMapper;
import org.geon.common.dto.PageDTO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;
	
	@Override
	public List<BoardVO> getPageList(PageDTO pageDTO,BoardVO boardVO) {
		
		return mapper.getList(
				pageDTO.getSkip(), 
				pageDTO.getPerSheet(), 
				boardVO.getCategory());
				//.stream().map(board -> toDTO(board)).collect(Collectors.toList());
	}

	@Override
	public int getTotalCount(PageDTO pageDTO) {
		return 0;
	}

	@Override
	public void register(BoardDTO boardDTO) {
		
	}

	@Override
	public BoardDTO readOne(Long bno) {
		return null;
	}

	@Override
	public void update(BoardDTO boardDTO) {
		
	}

	@Override
	public void delete(Long bno) {
		
	}

	
	
}
