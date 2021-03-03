package org.geon.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.geon.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() throws Exception{
		
		Connection con = dataSource.getConnection();
		
		log.info(con);
		
		con.close();
		
	}
	
	@Test
	public void testMyBatis() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		Connection con = session.getConnection();
		
		log.info(session);
		log.info(con);
		
		session.close();
		con.close();
		                                                    
	}
	
}
