package com.icss.commons;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;



import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 文件和流的基本操作
 * @author J.L.Zhou
 *
 */


public final class FileUtil {

	private static FileUtil fileUtil;
	private FileUtil(){}
	
	
	public static FileUtil newInstance(){
		if(fileUtil == null)
		{
			fileUtil = new FileUtil();
		}
		
		return fileUtil;
	}
	

	/**
	 * 将输入流in保存到文件fileName
	 * @param in
	 * @param fileName 完全文件名
	 * @return
	 */
	public void saveFile(InputStream in,java.io.File file)throws Exception
	{
		
		OutputStream out=new FileOutputStream(file);
		byte[] buffer = new byte[8192];
		int bytesRead = 0;
		while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        out.close();
        in.close();
           
		
	}
	
	/**
	 * 获取文件名称，去路径和扩展名
	 * @param a
	 * @return
	 */
	public String getFileName(String fileName)
	{
		try
		{
			if(fileName.lastIndexOf("/")>0)
			{
				return fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
			}else
			{
				return fileName.substring(0,fileName.lastIndexOf("."));
			}
		}catch(Exception ex)
		{
			return fileName;
		}
	}
	
	/**
	 * 获取文件大小描叙
	 * @param size
	 * @return
	 */
	public String getSizeDescribe(long size)
	{
		try
		{
			if(size < 1024) {
				return size + " bytes";
			} else if(size < 1048576) {
				return (Math.round(((size*10) / 1024))/10) + " KB";
			} else {
				return (Math.round(((size*10) / 1048576))/10) + " MB";
			}
		}catch(Exception ex)
		{
			return Long.toString(size);
		}
	}
	
	/**
	 * 获取文件扩展名
	 * @param fileName
	 * @return
	 */
	public String getFileExt(String fileName)
	{
		try
		{
			return fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		}catch(Exception ex)
		{
			return "unknow";
		}
	}
	
	/**
	 * 文件拷贝
	 * @param fileFrom 原文件
	 * @param fileTo 拷贝后的文件
	 
	 */
    public void copy(File fileFrom, File fileTo) throws Exception {   
          
            FileInputStream in = new java.io.FileInputStream(fileFrom);   
            FileOutputStream out = new FileOutputStream(fileTo);   
            byte[] bt = new byte[1024];   
            int count;   
            while ((count = in.read(bt)) > 0) {   
                out.write(bt, 0, count);   
            }   
            in.close();   
            out.close();   
           
    }
	
    public void  delete(File file) throws Exception
    {
    	
    		file.delete();
    
    }
	
	
	/**
	 * 保存对象到fileName的文件
	 * @param fileName
	 * @param obj
	 * @return
	 */
	public boolean saveObject(File file,Object obj)
	{
		try{
			FileOutputStream fo=new FileOutputStream(file);
			ZipOutputStream out = new ZipOutputStream(fo);
			ZipEntry entry = new ZipEntry("data");
			out.putNextEntry(entry);
			ObjectOutputStream so=new ObjectOutputStream(out);
			so.writeObject(obj); 
			so.close();
			out.close();
			fo.close();
		}catch(IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 从fileName对应的文件中读取对象
	 * @param fileName
	 * @return
	 */
	public Object readObject(File file)
	{
		Object obj=null;
		try{
			
			ZipFile zipFile = new ZipFile(file);
			ZipEntry entry = zipFile.getEntry("data");
			ObjectInputStream si=new ObjectInputStream(zipFile.getInputStream(entry));
			obj=si.readObject();
			si.close();
			zipFile.close();
		}catch(Exception e)
		{
			obj=null;
		}
		return obj;

	}
	
	/**
	 * 读取文本文件，编码UTF-8
	 * @param file
	 * @return
	 */
	public String readText(File file){
		return readText(file,"UTF-8");
	}
	/**
	 * 读取文本文件
	 * @param file
	 * @param charset
	 * @return
	 */
	public String readText(File file,String charset){
		BufferedReader reader = null;
		try{
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			reader = new BufferedReader(new InputStreamReader(in, charset));
			StringBuffer text = new StringBuffer();
			String tempString = null;
			while ((tempString = reader.readLine()) != null){
				text.append(tempString);
				text.append("\r\n");
			}
			reader.close();
			in.close();
			fis.close();
			return text.toString();
		}catch(Exception ex){
			return null;
		}
	}
	/**
	 * 保存文本文件，编码UTF-8
	 * @param content
	 * @param file
	 * @return
	 */
	public boolean saveText(String content,File file){
		return saveText(content, file, "UTF-8");
	}
	/**
	 * 保存文本文件
	 * @param content
	 * @param file
	 * @param charset
	 * @return
	 */
	public boolean saveText(String content,File file,String charset){
		try{
			FileOutputStream fos = new FileOutputStream(file);
			Writer out = new OutputStreamWriter(fos, charset);
			out.write(content);
			out.close();
			fos.close();
		}catch(Exception ex){
			return false;
		}
		return true;

	}

	/**
	 * 保存图片
	 * @param in　文件流
	 * @param fileName　保存文件
	 * @param w　适用高
	 * @param h　适用宽
	 * @param auto　小图片是否放大
	 * @param zip　图样压缩比
	 * @return　图片存放地址
	 */
	public void saveImg(InputStream in,java.io.File fileName,int w,int h,boolean auto,float zip)throws Exception
	{
				Image src= ImageIO.read(in);
				int oldW=src.getWidth(null);
				int oldH=src.getHeight(null);
				int newW,newH;
				if(w>oldW&&h>oldH&&auto==false)
				{
					newW=oldW;
					newH=oldH;
				}else
				{
					if(w*oldH>h*oldW)
					{
						newH=h;
						newW=(newH*oldW)/oldH;
					}else
					{
						newW=w;
						newH=(newW*oldH)/oldW;
					}
				}
				BufferedImage tempimg = new BufferedImage(newW, newH, 1);
				tempimg.getGraphics().setColor(new Color(255, 255, 255));
				tempimg.getGraphics().fillRect(0, 0, newW, newH);
				tempimg.getGraphics().drawImage(src, 0, 0, newW, newH, null);
				FileOutputStream tempFile = new FileOutputStream(fileName);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(tempFile);
				
				JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tempimg);
				param.setQuality(zip, true);
				encoder.setJPEGEncodeParam(param);
				   
				   
				encoder.encode(tempimg);
				tempFile.close();
				
		
	}
	
	

	/**
	 * 保存图片
	 * @param in　文件流
	 * @param fileName　保存文件包含路径名
	 * @param s　水印图片地址
	 * @param w　适用宽
	 * @param h　适用高
	 * @param auto　小图片是否自动放大
	 * @param zip　图片压缩比
	 * @param address　水印位置　0中　1　左上　2　右上　3　左下　4　右下
	 * @return 是否保存成功
	 */
	public void saveImg(InputStream in,java.io.File fileName,java.io.File sy,int w,int h,boolean auto,float zip,int address)throws Exception
	{
		
			
				Image src= ImageIO.read(in);
				int oldW=src.getWidth(null);
				int oldH=src.getHeight(null);
				int newW,newH;
				if(w>oldW&&h>oldH&&auto==false)
				{
					newW=oldW;
					newH=oldH;
				}else
				{
					if(w*oldH>h*oldW)
					{
						newH=h;
						newW=(newH*oldW)/oldH;
					}else
					{
						newW=w;
						newH=(newW*oldH)/oldW;
					}
				}
				BufferedImage tempimg = new BufferedImage(newW, newH, 1);
				Image syImg=ImageIO.read(sy);
				tempimg.getGraphics().setColor(new Color(255, 255, 255));
				tempimg.getGraphics().fillRect(0, 0, newW, newH);
				tempimg.getGraphics().drawImage(src, 0, 0, newW, newH, null);
				if(newW>syImg.getWidth(null)&&newH>syImg.getHeight(null))
				{
					int tempx=0;
					int tempy=0;
					if(address>4||address<0)
					{
						address=4;
					}
					if(address==0)
					{
						tempx=((newW-syImg.getWidth(null))/2);
						tempy=((newH-syImg.getHeight(null))/2);
					}else if(address==2)
					{
						tempx=newW-syImg.getWidth(null);
					}else if(address==3)
					{
						tempy=newH-syImg.getHeight(null);
					}else if(address==4)
					{
						tempx=newW-syImg.getWidth(null);
						tempy=newH-syImg.getHeight(null);
					}
			
					tempimg.getGraphics().drawImage(syImg, tempx, tempy, syImg.getWidth(null), syImg.getHeight(null), null);
				}
				FileOutputStream tempFile = new FileOutputStream(fileName);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(tempFile);
				
				JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tempimg);
				param.setQuality(zip, true);
				encoder.setJPEGEncodeParam(param);
				
				encoder.encode(tempimg);
				tempFile.close();
			
	}

	
    
}
