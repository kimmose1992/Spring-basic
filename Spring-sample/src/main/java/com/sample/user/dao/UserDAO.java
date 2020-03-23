package com.sample.user.dao;

import com.sample.user.vo.UserVO;

public interface UserDAO {

	public String getTime();
	
	public UserVO getUserInfo();
	
	public void insertUser(UserVO vo);
}
