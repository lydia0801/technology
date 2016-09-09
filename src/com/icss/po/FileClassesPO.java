package com.icss.po;

import java.io.Serializable;
import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class FileClassesPO implements Serializable,RowMapper<FileClassesPO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4293818198165427928L;
	private Integer fileClassesId;
	private String fileClassesName,fileClassesExt;
	
	
	
	public FileClassesPO() {
		super();
	}
	public FileClassesPO(Integer fileClassesId) {
		super();
		this.fileClassesId = fileClassesId;
	}
	public FileClassesPO(Integer fileClassesId, String fileClassesName,
			String fileClassesExt) {
		super();
		this.fileClassesId = fileClassesId;
		this.fileClassesName = fileClassesName;
		this.fileClassesExt = fileClassesExt;
	}
	public Integer getFileClassesId() {
		return fileClassesId;
	}
	public void setFileClassesId(Integer fileClassesId) {
		this.fileClassesId = fileClassesId;
	}
	public String getFileClassesName() {
		return fileClassesName;
	}
	public void setFileClassesName(String fileClassesName) {
		this.fileClassesName = fileClassesName;
	}
	public String getFileClassesExt() {
		return fileClassesExt;
	}
	public void setFileClassesExt(String fileClassesExt) {
		this.fileClassesExt = fileClassesExt;
	}
	public FileClassesPO mapRow(ResultSet rs, int index) throws Exception {
		return new FileClassesPO(
				rs.getInt("file_classes_id"),
				rs.getString("file_classes_name"),
				rs.getString("file_classes_ext")
				
		);
	}
}
