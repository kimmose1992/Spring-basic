package com.sample.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.user.dao.UserDAO;
import com.sample.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = { "file:src/main/webapp/WEB-INF/config/spring/**/*.xml" }
)
public class SQLConnectionTest {

	@Inject
	private UserDAO dao;
	
	@Test
	public void getTime() throws Exception {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void getUserInfo() throws Exception {
		UserVO vo = dao.getUserInfo();
		System.out.println(vo.getUserId());
	}
	
	@Test
	public void insertUser() throws Exception {
		UserVO vo = new UserVO();
		vo.setUserId("dan0e");
		vo.setUserPw("dan0e");
		vo.setUserName("강단영");
		vo.setEmail("dan0e@gmail.com");
		
		dao.insertUser(vo);
	}
}
