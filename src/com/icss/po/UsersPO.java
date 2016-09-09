package com.icss.po;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.icss.commons.RowMapper;

public class UsersPO implements Serializable,RowMapper<UsersPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1281833895254377666L;
	private Integer userId,userRolesId,fileLevelId;
	private String userName,userPwd,userRealName;
	private Boolean userState;
	private Date userTime;
	
	
	
	public UsersPO(Integer userId) {
		super();
		this.userId = userId;
	}
	public UsersPO(Integer userId, Integer userRolesId, Integer fileLevelId,
			String userName, String userPwd, String userRealName,
			Boolean userState, Date userTime) {
		super();
		this.userId = userId;
		this.userRolesId = userRolesId;
		this.fileLevelId = fileLevelId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRealName = userRealName;
		this.userState = userState;
		this.userTime = userTime;
	}
	public UsersPO() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserRolesId() {
		return userRolesId;
	}
	public void setUserRolesId(Integer userRolesId) {
		this.userRolesId = userRolesId;
	}
	public Integer getFileLevelId() {
		return fileLevelId;
	}
	public void setFileLevelId(Integer fileLevelId) {
		this.fileLevelId = fileLevelId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public Boolean getUserState() {
		return userState;
	}
	public void setUserState(Boolean userState) {
		this.userState = userState;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm")
	public Date getUserTime() {
		return userTime;
	}
	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}
	
	public UsersPO mapRow(ResultSet rs, int index) throws Exception {
		UsersPO po = new UsersPO();
		po.setFileLevelId(rs.getInt("file_Level_Id"));
		po.setUserId(rs.getInt("user_Id"));
		po.setUserName(rs.getString("user_Name"));
		po.setUserPwd(rs.getString("user_Pwd"));
		po.setUserRealName(rs.getString("user_Real_Name"));
		po.setUserRolesId(rs.getInt("user_Roles_Id"));
		po.setUserState(rs.getBoolean("user_State"));
		po.setUserTime(rs.getTimestamp("user_Time"));
		return po;
	}
	
	
}
