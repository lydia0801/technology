package com.icss.actions;

import org.apache.struts2.ServletActionContext;

import com.icss.vo.UserSessionVO;

/**
 * 
 * @author Administrator
 *
 */
public class HelloAction {

	public String execute(){
		UserSessionVO user = (UserSessionVO) ServletActionContext.getRequest().getSession().getAttribute("user");
		System.out.println("-----------------------------------");
		return null;
	}
}
