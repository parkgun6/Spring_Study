package org.geon.board.service;

import java.util.List;

import org.geon.board.domain.BoardVO;
import org.geon.common.dto.PageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	BoardService service;
	
	@Test
	public void testGetPageList() {
		List<BoardVO> list = service.getPageList(
				PageDTO.builder().page(1).build(),
				BoardVO.builder().category(1).build());
		
		list.forEach(vo -> {
			log.info(vo);
		});
	}
	
}
