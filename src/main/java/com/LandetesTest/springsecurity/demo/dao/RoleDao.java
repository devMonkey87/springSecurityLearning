package com.LandetesTest.springsecurity.demo.dao;

import com.LandetesTest.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);

}
