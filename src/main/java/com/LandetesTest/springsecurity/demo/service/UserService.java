package com.LandetesTest.springsecurity.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.LandetesTest.springsecurity.demo.entity.User;
import com.LandetesTest.springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(CrmUser crmUser);
}
