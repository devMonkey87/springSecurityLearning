package com.LandetesTest.springsecurity.demo.dao;

import com.LandetesTest.springsecurity.demo.entity.User;

public interface UserDao {

	User findByUserName(String userName);

	void save(User user);

}
