<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%
System.out.println("---------------------------------");
for(Object nameObject : request.getParameterMap().keySet()){
	String name = (String)nameObject;
	System.out.println(name+":"+request.getParameter(name));
}
%>{"ok":true}