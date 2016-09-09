package com.icss.actions;

import com.icss.service.UsersService;
import com.icss.service.UsersServiceImp;

public class UserRolesAction extends ActionSupport {

	private UsersService service = new UsersServiceImp();
	
	@Override
	public String execute() throws Exception {
		return outJSON(service.listRoles());
	}
	

	
}
