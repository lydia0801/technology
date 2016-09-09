package com.icss.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.icss.commons.FileUtil;
import com.icss.dao.FileClassesDAO;
import com.icss.dao.FileContentDAO;
import com.icss.dao.FileLevelDAO;
import com.icss.po.FileClassesPO;
import com.icss.po.FileContentPO;
import com.icss.po.FileLevelPO;

public class FileServiceImp implements FileService {

	private FileLevelDAO fileLevelDAO = new FileLevelDAO();
	private FileContentDAO fileContentDAO = new FileContentDAO();
	private FileClassesDAO fileClassesDAO = new FileClassesDAO();
	
	public List<FileLevelPO> listLevel() throws Exception {
		return fileLevelDAO.findAll();
	}

	public int getFileSize(File file) {
		InputStream input = null;
		try{
			input = new FileInputStream(file);
			return input.available();
		}catch (Exception e) {
			return 0;
		}finally{
			try {
				if(input!=null)
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public File read(String uri) throws Exception {
		return new File(BASE_PATH+uri);
	}

	public String save(File file) throws Exception {
		String uri = "";
		uri += new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		new File(BASE_PATH+uri).mkdirs();
		uri += UUID.randomUUID().toString();
		FileUtil.newInstance().copy(file, new File(BASE_PATH+uri));
		return uri;
	}

	public List<FileClassesPO> listClasses() throws Exception {
		return fileClassesDAO.findAll();
	}

	public List<FileContentPO> listContent() throws Exception {
		return fileContentDAO.findAll();
	}
	
	

	
}
