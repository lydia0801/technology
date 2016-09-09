<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!DOCTYPE HTML>
<html>
  <head>
    <title>系统登录</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<script type="text/javascript" src="resources/script/jquery-1.8.0.min.js"></script>
	<!-- 第一步：引入jQuery核心库 -->
	<script type="text/javascript" src="resources/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
	<!-- 第二步：引入EasyUI核心库 -->
	<script type="text/javascript" src="resources/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
	<!-- 第三步：引入EasyUI语言环境包 -->
	
	<link rel="stylesheet" type="text/css" href="resources/jquery-easyui-1.3.2/themes/metro/easyui.css" />
	<!-- 第四步：引入EasyUI皮肤 -->
	<link rel="stylesheet" type="text/css" href="resources/jquery-easyui-1.3.2/themes/icon.css" />
	<!-- 第五步：引入EasyUI图标 -->
	
	<link rel="stylesheet" type="text/css" href="resources/style/main.css" />
	<script type="text/javascript" src="resources/script/public.js"></script>
  </head>
  
  <body>
  	<div id="loginDialog">
  	<form style="margin: 10px 0;" method="post">
	<table width="250" border="0" cellspacing="5" cellpadding="0">
	  <tr>
	    <td width="40%" align="right">用户名：</td>
	    <td><input class="easyui-validatebox combo" data-options="required:true,validType:'length[2,20]'" type="text" name="userName" style=" width:100px; padding:2px;"/></td>
	  </tr>
	  <tr>
	    <td align="right">密码：</td>
	    <td><input class="easyui-validatebox combo" data-options="required:true,validType:'length[2,20]'" type="password" name="userPwd" style=" width:100px; padding:2px;"/></td>
	  </tr>
	</table>
	</form>
  	</div>
  	<script type="text/javascript">
  	$(function(){
  		window.sys = {};
		sys.win = null;
		
		sys.open = function(arg){
			sys.win = $("<div></div>").appendTo("body");
			if(arg==null){arg={};}
			var arg1 = $.extend({
				modal:true,
				onClose:function(){
					sys.win.dialog("destroy");
				}
			},arg);
			
			sys.win.dialog(arg1);
		}
		
		var loginDialog = $("#loginDialog");
		var form = loginDialog.find("form");
		
		form.form({
			url:"login.action",
			onSubmit:function(){
				return form.form("validate");
			},
			success:function(data){
				
				//var data = eval("("+data+")");
				
				var data = $.parseJSON(data);
				if(data.ok){
					window.location="main.html";
				}else{
					$.messager.alert("错误提示","用户登录错误<br/>"+data.msg,"error");
				}
				
			}
		});
		
		
		loginDialog.dialog({
			title:"系统登录",
			closable:false,
			buttons:[{
					text:"登录",
					handler:function(){
						form.submit();
					}
				},{
					text:"注册",
					handler:function(){
						sys.open({
							href:"reg.html",
							title:"用户注册",
							width:400,
							height:"auto",
							buttons:[{
								text:"我要注册",
								handler:function(){
									sys.win.find("form").submit();
								}
							}]
						});
					}
				}]
		});
  	
  	}); 	
  	</script>
  </body>