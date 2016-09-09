package com.icss.dao;

import java.util.List;

import com.icss.po.UserRolesPO;

public class UserRolesDAO extends DAOSupport<UserRolesPO> {

	@Override
	public void add(UserRolesPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserRolesPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserRolesPO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return db.list("select * from user_roles", new UserRolesPO());
	}

	@Override
	public UserRolesPO findById(UserRolesPO po) throws Exception {
		return db.get("select * from user_roles where user_roles_id=?", new UserRolesPO(),po.getUserRolesId());
	}

	@Override
	public void modify(UserRolesPO... po) throws Exception {
	}

}
