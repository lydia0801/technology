package com.icss.actions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.icss.service.FileService;
import com.icss.service.FileServiceImp;

public class DownloadAction extends ActionSupport {
	
	private FileService fileService = new FileServiceImp();
	
	private InputStream inputStream;
	private int size;
	private String contentType;
	private String fileName;

	@Override
	public String execute() throws Exception {
		String uri = "2013/08/19/0bfa2800-5835-441d-bcd1-bb8eab42b808";
		size = 253660;
		contentType = "image/jpeg";
		fileName = "撒旦发射点发.jpg";
		inputStream = new FileInputStream(fileService.read(uri));
		return "download";
	}

	public InputStream getInputStream() {
		return inputStream;  
	}

	public int getSize() {
		return size;
	}

	public String getContentType() {
		return contentType;
	}

	public String getFileName() {
		try {
			return new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			return "unknow";
		}
	}

	
}
