package com.sample.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
	locations = { "file:src/main/webapp/WEB-INF/config/spring/**/*.xml" }
)
public class DataSourceTest {

	@Inject
	private DataSource ds;

	@Test
	public void testConnection() throws Exception {
		try {
			Connection conn = ds.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() throws Exception {
		try {
			SqlSession session = sqlFactory.openSession();
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
