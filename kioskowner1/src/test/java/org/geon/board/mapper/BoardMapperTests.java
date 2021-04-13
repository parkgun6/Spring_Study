package org.geon.board.mapper;

import org.geon.board.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void read() {
		Long bno = 13L;
		
		log.info(mapper.read(bno));
	}
	
	@Test
	public void testGetList() {
		
		mapper.getList(1,10,3).forEach(board -> log.info(board));
	}
	
	@Test
	public void testGetTotalCount() {
		
		log.info(mapper.getTotalCount(3));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = BoardVO.builder().title("testinsert.....").content("test.....").writer("박건").category(1).build();
		
		mapper.insert(board);
	}

	@Test
	public void testUpdate() {
		BoardVO board = BoardVO.builder().bano(15L).title("testinsert.....").content("test.....").writer("박건").category(1).build();
		
		mapper.update(board);
	}
	
	@Test
	public void testDelete() {
		Long bno = 15L;
		
		mapper.delete(bno);
	}
}
