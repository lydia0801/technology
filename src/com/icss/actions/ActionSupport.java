package com.icss.actions;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.annotations.JSON;

import com.icss.vo.UserSessionVO;

public abstract class ActionSupport {
	
	public abstract String execute()throws Exception;
	
	@JSON(serialize=false)
	public UserSessionVO getUser(){
		return (UserSessionVO) ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
	public String outJSON(Object object){
		try {
			ServletActionContext.getResponse().getWriter().print(JSONUtil.serialize(object));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
		
	}

}
