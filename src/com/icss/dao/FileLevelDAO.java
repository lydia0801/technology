package com.icss.dao;

import java.util.List;

import com.icss.po.FileLevelPO;

/**
 * 资源等级操作
 * @author J.L.Zhou
 *
 */
public class FileLevelDAO extends DAOSupport<FileLevelPO> {


	/**
	 * 保存资源等级
	 * @param po
	 * @throws Exception
	 */
	@Override
	public void add(FileLevelPO... po) throws Exception {
		for(FileLevelPO p : po){
			db.execute(
					"INSERT INTO file_level(file_level_id,file_level_name) VALUES(?,?)",
					p.getFileLevelId(),
					p.getFileLevelName()
			);
		}
		
	}

	@Override
	public void delete(FileLevelPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public List<FileLevelPO> findAll() throws Exception {
		return db.list("select * from file_level",new FileLevelPO());
	}

	@Override
	public FileLevelPO findById(FileLevelPO po) throws Exception {
		// TODO Auto-generated method stub
		return db.get("select * from file_level where file_level_id=?",new FileLevelPO(), po.getFileLevelId());
	}

	@Override
	public void modify(FileLevelPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
