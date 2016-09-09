package com.icss.po;

import java.io.Serializable;
import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class FileContentPO implements Serializable,RowMapper<FileContentPO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9131523955623402001L;
	private Integer fileContentId,fileClassesId;
	private String fileContentName;


	public FileContentPO() {
		super();
	}
	
	public FileContentPO(Integer fileContentId) {
		super();
		this.fileContentId = fileContentId;
	}

	public FileContentPO(Integer fileContentId, Integer fileClassesId,
			String fileContentName) {
		super();
		this.fileContentId = fileContentId;
		this.fileClassesId = fileClassesId;
		this.fileContentName = fileContentName;
	}

	public Integer getFileContentId() {
		return fileContentId;
	}
	public void setFileContentId(Integer fileContentId) {
		this.fileContentId = fileContentId;
	}
	public Integer getFileClassesId() {
		return fileClassesId;
	}
	public void setFileClassesId(Integer fileClassesId) {
		this.fileClassesId = fileClassesId;
	}
	public String getFileContentName() {
		return fileContentName;
	}
	public void setFileContentName(String fileContentName) {
		this.fileContentName = fileContentName;
	}

	public FileContentPO mapRow(ResultSet rs, int index) throws Exception {
		return new FileContentPO(rs.getInt("file_content_id"),rs.getInt("file_classes_id"),rs.getString("file_content_name"));
	}
	
}
