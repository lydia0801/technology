package com.icss.po;

import java.sql.ResultSet;

import com.icss.commons.RowMapper;

public class FileLevelRowMapper implements RowMapper<FileLevelPO> {

	public FileLevelPO mapRow(ResultSet rs, int index) throws Exception {
		FileLevelPO po = new FileLevelPO();
		po.setFileLevelId(rs.getInt("file_level_id"));
		po.setFileLevelName(rs.getString("file_level_name"));
		return po;
	}

}
