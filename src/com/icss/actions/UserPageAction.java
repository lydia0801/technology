package com.icss.actions;

import com.icss.service.UsersService;
import com.icss.service.UsersServiceImp;

public class UserPageAction extends ActionSupport {

	private UsersService service = new UsersServiceImp();
	
	private int page,rows;
	@Override
	public String execute() throws Exception {
		return outJSON(service.pageUser(page, rows));
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

}
