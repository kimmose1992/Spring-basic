package com.sample.user.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sample.user.dao.UserDAO;
import com.sample.user.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public String getTime() {
		return sqlSession.selectOne("user.getTime");
	}

	@Override
	public UserVO getUserInfo() {
		UserVO vo = sqlSession.selectOne("user.getUserInfo");
		return vo;
	}
	
	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert("user.insertUser", vo);
	}
}
