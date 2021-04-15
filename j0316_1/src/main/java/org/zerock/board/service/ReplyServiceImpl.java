package org.zerock.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.domain.Reply;
import org.zerock.board.mapper.ReplyMapper;
import org.zerock.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final ReplyMapper mapper;


	@Override
	public List<Reply> getReplyList(Integer bno, PageDTO pageDTO) {
			log.info(pageDTO);
		return mapper.selectList(bno, pageDTO);
	}
}
