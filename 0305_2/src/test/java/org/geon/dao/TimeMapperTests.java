package org.geon.dao;

import org.geon.config.RootConfig;
import org.geon.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class TimeMapperTests {

	@Autowired
	TimeMapper mapper;
	
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
}
