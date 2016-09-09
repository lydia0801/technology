package com.icss.actions;

import java.util.List;

import com.icss.po.FileLevelPO;
import com.icss.service.FileService;
import com.icss.service.FileServiceImp;

public class FileLevelAction extends ActionSupport {

	private FileService fileService = new FileServiceImp();
	
	private List<FileLevelPO> list;
	
	public String execute()throws Exception{
		list = fileService.listLevel();
		/**
		ServletActionContext.getResponse().getWriter().print(JSONUtil.serialize(list));
		return null;
		**/
		return outJSON(list);
	}
	
	public List<FileLevelPO> getList(){
		return list;
	}
}
