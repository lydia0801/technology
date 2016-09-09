package com.icss.actions;

import org.apache.struts2.ServletActionContext;

import com.icss.vo.UserSessionVO;

public class SessionAction {

	private UserSessionVO user;
	public String execute(){
		user = (UserSessionVO) ServletActionContext.getRequest().getSession().getAttribute("user");
		return "json";
	}
	public UserSessionVO getUser() {
		return user;
	}
	
}
