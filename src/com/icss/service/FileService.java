package com.icss.service;

import java.io.File;
import java.util.List;

import com.icss.po.FileClassesPO;
import com.icss.po.FileContentPO;
import com.icss.po.FileLevelPO;

public interface FileService {
	
	public final static String BASE_PATH = "d:\\";

	List<FileLevelPO> listLevel()throws Exception;
	
	int getFileSize(File file);
	
	String save(File file)throws Exception;
	
	File read(String uri)throws Exception;
	
	List<FileClassesPO> listClasses()throws Exception;
	
	List<FileContentPO> listContent()throws Exception;
}
