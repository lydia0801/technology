package com.icss.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.icss.service.FileService;
import com.icss.service.FileServiceImp;

public class UploadAction extends ActionSupport {

	
	private FileService fileService = new FileServiceImp();
	
	private File aaa;
	private String aaaFileName;
	private String aaaContentType;
	private String bbb;
	@Override
	public String execute() throws Exception {
		System.out.println("-------------------");
		System.out.println(aaa);
		System.out.println(bbb);
		System.out.println(aaaFileName);
		System.out.println(aaaContentType);
		System.out.println(fileService.getFileSize(aaa));
		System.out.println(fileService.save(aaa));

		
		return "json";
	}
	public void setAaa(File aaa) {
		this.aaa = aaa;
	}
	public void setBbb(String bbb) {
		this.bbb = bbb;
	}
	

	
	public void setAaaFileName(String aaaFileName) {
		this.aaaFileName = aaaFileName;
	}
	public void setAaaContentType(String aaaContentType) {
		this.aaaContentType = aaaContentType;
	}
	public boolean getOk(){
		return true;
	}
	
}
