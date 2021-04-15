package org.geon.adminboard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.geon.adminboard.domain.BoardVO;
import org.geon.adminboard.dto.BoardDTO;
import org.geon.adminboard.mapper.BoardMapper;
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
	public List<BoardDTO> getPageList(PageDTO pageDTO,Integer category) {
		
		return mapper.getList(
				pageDTO.getPage(), 
				pageDTO.getPerSheet(), 
				category,
				pageDTO.getArr(),
				pageDTO.getKeyword())
				.stream().map(board -> toDTO(board)).collect(Collectors.toList());
	}

	@Override
	public int getTotalCount(PageDTO pageDTO,Integer category) {
		return mapper.getTotalCount(
				category,
				pageDTO.getArr(),
				pageDTO.getKeyword());
	}

	@Override
	public void register(BoardDTO boardDTO) {
		BoardVO board = toDomain(boardDTO);
		log.info(board);
		mapper.insert(board);
	}

	@Override
	public BoardDTO readOne(Long bano) {
		return toDTO(mapper.read(bano));
	}

	@Override
	public void update(BoardDTO boardDTO) {
		BoardVO board = toDomain(boardDTO);
		log.info(board);
		
		mapper.update(board);
	}

	@Override
	public void delete(Long bano) {
		mapper.delete(bano);
	}

	
	
}
