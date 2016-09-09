package com.icss.commons;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {

	private String requestEncode = "UTF-8";
	private String responseEncode = "text/html;charset=UTF-8";

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
//		System.out.println("before:执行了："+this.getClass()+"的doFilter方法");
		request.setCharacterEncoding(requestEncode);
//		System.out.println("设置了请求的字符编码为："+requestEncode);
		response.setContentType(responseEncode);
//		System.out.println("设置了响应的文档类型为："+responseEncode);
		
		

		if("GET".equals(request.getMethod().toUpperCase())){
			Iterator<String[]> iter=request.getParameterMap().values().iterator();
		      while(iter.hasNext()){
			       String[] parames=iter.next();
			       for (int i = 0; i < parames.length; i++) {
				       try {
				        	parames[i]=new String(parames[i].getBytes("iso8859-1"),request.getCharacterEncoding());
				       } catch (UnsupportedEncodingException e) {
				         e.printStackTrace();
				       }
			       } 
		      }
		}
		
		arg2.doFilter(arg0, arg1);
//		System.out.println("after:执行了："+this.getClass()+"的doFilter方法");
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		requestEncode = arg0.getInitParameter("requestEncode");
		responseEncode = arg0.getInitParameter("responseEncode");
	}

}
