package com.icss.po;

import java.io.Serializable;
import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class UserRolesPO implements Serializable,RowMapper<UserRolesPO> {

	private Integer userRolesId;
	private String userRolesName;
	
	
	
	
	public UserRolesPO() {
		super();
	}
	
	
	public UserRolesPO(Integer userRolesId) {
		super();
		this.userRolesId = userRolesId;
	}


	public UserRolesPO(Integer userRolesId, String userRolesName) {
		super();
		this.userRolesId = userRolesId;
		this.userRolesName = userRolesName;
	}
	public Integer getUserRolesId() {
		return userRolesId;
	}
	public void setUserRolesId(Integer userRolesId) {
		this.userRolesId = userRolesId;
	}
	public String getUserRolesName() {
		return userRolesName;
	}
	public void setUserRolesName(String userRolesName) {
		this.userRolesName = userRolesName;
	}

	public UserRolesPO mapRow(ResultSet rs, int index) throws Exception {
		return new UserRolesPO(rs.getInt("user_roles_id"),rs.getString("user_roles_Name"));
	}
	
	
}
