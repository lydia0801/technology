package com.icss.actions;

import com.icss.service.UsersService;
import com.icss.service.UsersServiceImp;

public class UserShowAction extends ActionSupport {

	private UsersService service = new UsersServiceImp();
	
	private int id;
	@Override
	public String execute() throws Exception {
		return outJSON(service.get(id));
	}
	public void setId(int id) {
		this.id = id;
	}
}
