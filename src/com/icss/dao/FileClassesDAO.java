package com.icss.dao;

import java.util.List;

import com.icss.po.FileClassesPO;

public class FileClassesDAO extends DAOSupport<FileClassesPO> {

	@Override
	public void add(FileClassesPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FileClassesPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FileClassesPO> findAll() throws Exception {
		return db.list("select * from file_classes", new FileClassesPO());
	}

	@Override
	public FileClassesPO findById(FileClassesPO po) throws Exception {
		return db.get("select * from file_classes where file_classes_id=?", new FileClassesPO(), po.getFileClassesId());
	}

	@Override
	public void modify(FileClassesPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
