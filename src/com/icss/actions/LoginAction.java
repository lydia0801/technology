package com.icss.actions;

import org.apache.struts2.ServletActionContext;

import com.icss.service.UsersService;
import com.icss.service.UsersServiceImp;
import com.icss.vo.UserSessionVO;

public class LoginAction {

	private String userName,userPwd;
	
	private UsersService service = new UsersServiceImp();
	
	private Boolean ok;
	
	private String msg;

	
	public String execute(){
		try{
			UserSessionVO vo = service.login(userName, userPwd);
			ServletActionContext.getRequest().getSession().setAttribute("user", vo);
			ok = true;
		}catch (Exception e) {
			ok = false;
			msg = e.getMessage();
		}
		
		return "json";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Boolean getOk() {
		return ok;
	}

	public String getMsg() {
		return msg;
	}
	
	
	public void validate(){
		
	}
	
	
}
