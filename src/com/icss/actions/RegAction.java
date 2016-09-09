package com.icss.actions;

import org.apache.struts2.ServletActionContext;

import com.icss.po.UsersPO;
import com.icss.service.UsersService;
import com.icss.service.UsersServiceImp;
import com.icss.vo.UsersVO;
import com.opensymphony.xwork2.ModelDriven;

public class RegAction implements ModelDriven<UsersVO> {

	private UsersVO usersPO = new UsersVO();
	
	private UsersService usersService = new UsersServiceImp();
	
	private Boolean ok;
	
	private String msg;

	
	public String execute(){
		/**
		System.out.println(usersPO);
		UsersPO po = usersPO;
		System.out.println(usersPO.getSex());
		String sex = ServletActionContext.getRequest().getParameter("sex");
		System.out.println(sex);
		**/
		try {
			usersService.reg(usersPO);
			ok = true;
		} catch (Exception e) {
//			e.printStackTrace();
			msg = e.getMessage();
			ok = false;
		}
		
		return "json";
	}

	public UsersVO getModel() {
		return usersPO;
	}

	public Boolean getOk() {
		return ok;
	}

	public String getMsg() {
		return msg;
	}
	
	
	
	

	
}
