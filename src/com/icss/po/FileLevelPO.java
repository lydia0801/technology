package com.icss.po;

import java.io.Serializable;
import java.sql.ResultSet;

import com.icss.commons.RowMapper;


/**
 * 资源等级数据模型
 * @author J.L.Zhou
 *
 */
public class FileLevelPO implements Serializable,RowMapper<FileLevelPO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9109584585468076817L;
	private Integer fileLevelId;
	private String fileLevelName;
	
	
	
	public FileLevelPO(Integer fileLevelId) {
		super();
		this.fileLevelId = fileLevelId;
	}

	public FileLevelPO(Integer fileLevelId, String fileLevelName) {
		super();
		this.fileLevelId = fileLevelId;
		this.fileLevelName = fileLevelName;
	}
	
	public FileLevelPO() {
		super();
	}
	
	public Integer getFileLevelId() {
		return fileLevelId;
	}
	public void setFileLevelId(Integer fileLevelId) {
		this.fileLevelId = fileLevelId;
	}
	public String getFileLevelName() {
		return fileLevelName;
	}
	public void setFileLevelName(String fileLevelName) {
		this.fileLevelName = fileLevelName;
	}

	public FileLevelPO mapRow(ResultSet rs, int index) throws Exception {
		FileLevelPO po = new FileLevelPO();
		po.setFileLevelId(rs.getInt("file_level_id"));
		po.setFileLevelName(rs.getString("file_level_name"));
		return po;
	}

	
	
}
