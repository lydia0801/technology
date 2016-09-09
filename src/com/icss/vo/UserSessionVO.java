package com.icss.vo;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class UserSessionVO {
	
	private Integer userId,userRolesId,fileLevelId;
	private String userName,userRealName;
	private Date loginTime;
	private String userRolesName,fileLevelName;
	
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
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	
	@JSON(serialize=true,name="time",format="MM-dd HH:mm:ss")
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getUserRolesName() {
		return userRolesName;
	}
	public void setUserRolesName(String userRolesName) {
		this.userRolesName = userRolesName;
	}
	public String getFileLevelName() {
		return fileLevelName;
	}
	public void setFileLevelName(String fileLevelName) {
		this.fileLevelName = fileLevelName;
	}
	
	

}
