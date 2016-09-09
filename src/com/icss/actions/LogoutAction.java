package com.icss.actions;

import org.apache.struts2.ServletActionContext;

public class LogoutAction {

	public String execute(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "json";
	}
}
