package com.icss.dao;

import java.util.List;

import com.icss.po.FileContentPO;

public class FileContentDAO extends DAOSupport<FileContentPO> {

	@Override
	public void add(FileContentPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FileContentPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FileContentPO> findAll() throws Exception {
		return db.list("select * from file_content", new FileContentPO());
	}

	@Override
	public FileContentPO findById(FileContentPO po) throws Exception {
		return db.get("select * from file_content where file_content_id=?", new FileContentPO(),po.getFileContentId());
	}

	@Override
	public void modify(FileContentPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
