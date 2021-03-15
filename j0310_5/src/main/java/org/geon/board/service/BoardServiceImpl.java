package org.geon.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.geon.board.domain.Board;
import org.geon.board.dto.BoardDTO;
import org.geon.board.mapper.BoardMapper;
import org.geon.common.dto.PageDTO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

//자동주입을 하면 코드가 깔끔해진다
@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;
	
	
	
	//인터페이스에 있는 default메서드를 활용한 코드
	//vo를 사용했다.
	@Override
	public void register(BoardDTO boardDTO) {
		
		//인터페이스에 있는 toDomain을 활용해서 DTO를 VO로 변환해주었다.
		Board vo = toDomain(boardDTO);
		log.info(vo);
		
		mapper.insert(vo);
		
	}
	
	//인터페이스에 있는 default메서드를 활용하지 않은 코드
	@Override
	public List<BoardDTO> getPageList(PageDTO pageDTO) {

		return mapper.getList(
				pageDTO.getSkip(), 
				pageDTO.getPerSheet(), 
				pageDTO.getArr(),
				pageDTO.getKeyword())
		.stream().map(board -> toDTO(board)).collect(Collectors.toList());
	}

	@Override
	public int getTotalCount(PageDTO dto) {
		//이 사이에 아무것도 안들어갔지만 나중에 AOP할때 부가적인 기능이 추가된다
		return mapper.getTotalCount(dto.getArr(),dto.getKeyword());
	}

	@Override
	public BoardDTO readOne(Integer bno) {
		return toDTO(mapper.selectOne(bno));
	}

	@Override
	public void update(BoardDTO boardDTO) {
		Board vo = toDomain(boardDTO);
		log.info(vo);
		mapper.update(vo);
	}

	@Override
	public void delete(Integer bno) {
		mapper.delete(bno);
	}

	

}
