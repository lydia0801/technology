package com.icss.vo;

import java.sql.ResultSet;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.icss.commons.RowMapper;

public class UsersViewVO implements RowMapper<UsersViewVO> {

	private Integer userId,userRolesId,fileLevelId;
	private String userName,userPwd,userRealName;
	private Boolean userState;
	private Date userTime;
	private String fileLevelName,userRolesName;

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

	public String getFileLevelName() {
		return fileLevelName;
	}

	public void setFileLevelName(String fileLevelName) {
		this.fileLevelName = fileLevelName;
	}

	public String getUserRolesName() {
		return userRolesName;
	}

	public void setUserRolesName(String userRolesName) {
		this.userRolesName = userRolesName;
	}

	public UsersViewVO mapRow(ResultSet rs, int index) throws Exception {
		UsersViewVO po = new UsersViewVO();
		po.setFileLevelId(rs.getInt("file_Level_Id"));
		po.setUserId(rs.getInt("user_Id"));
		po.setUserName(rs.getString("user_Name"));
		po.setUserPwd(rs.getString("user_Pwd"));
		po.setUserRealName(rs.getString("user_Real_Name"));
		po.setUserRolesId(rs.getInt("user_Roles_Id"));
		po.setUserState(rs.getBoolean("user_State"));
		po.setUserTime(rs.getTimestamp("user_Time"));
		po.setFileLevelName(rs.getString("file_Level_Name"));
		po.setUserRolesName(rs.getString("user_Roles_Name"));
		return po;
	}
	
	
}
