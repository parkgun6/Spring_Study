package org.zerock.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.config.BoardConfig;
import org.zerock.board.domain.Reply;
import org.zerock.board.mapper.ReplyMapper;
import org.zerock.common.config.CommonConfig;
import org.zerock.common.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class, BoardConfig.class})
@Log4j
public class ReplyTests {

	@Autowired
	ReplyMapper mapper;
	

	@Test
	public void getList() {
		PageDTO pageDTO = new PageDTO();
		//List<Reply> replies = mapper.selectList(1058,pageDTO).forEach(res -> log.info(res));
		
	}
}
