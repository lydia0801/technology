(function($){
	
	$.fn.serializeObject = function(){
		var obj = {};
		$.each($(this).serializeArray(),function(i,v){
			var name = v.name;
			var value = v.value;
			if(obj[name]==null){
				obj[name]=value;
			}else{
				obj[name] += ","+value;
			}
		});
		return obj;
	}
	
	window.ns = function(obj){
		var nss = obj.split(/\./);
		var ws = "window";
		for(var i=0;i<nss.length;i++){
			ws += "." + nss[i];
			if(eval(ws+"==null")){
				eval(ws+"={};")
			}
		}
	}
	

	$.load=function(file,fn){
		if(fn==null){
			fn = function(){
				eval("window."+file+"()");
			}
		}
		try{
			if(eval("window."+file+"==null")){
				$.getScript(file.replace(/\./g,"/")+".js",function(){
					fn();
				});
			}else{
				fn();
			}
		}catch(e){
			$.getScript(file.replace(/\./g,"/")+".js",function(){
				fn();
			});
		}
	}
	$.msg = function(msg,timeout){
		if(timeout==null){
			$.messager.alert("系统提示",msg,"info");
		}else{
			$.messager.show({
				"title":"系统提示",
				"msg":msg,
				"timeout":timeout
			});
		}
	}
	$.err = function(data,timeout){
		if(data.code==0){
			$.messager.confirm("登录提示","您请求的内容需要先登录!<br/>您要先登录吗？",function(r){
				if(r){
					load("login",function(){login().dialog("open");});
				}
			});
		}else{
			if(timeout==null){
				$.messager.alert("错误提示",data.error,"error");
			}else{
				$.messager.show({
					"title":"错误提示",
					"msg":data.error,
					"timeout":timeout
				});
			}
		}
		
	}
	
	$.confirm = function(msg,fn){
		$.messager.confirm("确认提示", msg, function(r){
			if (r){
				fn();
			}
		});
	}
	$.loadArray = function(obj,fn,i){
		if(obj.length>i){
			$.getScript(obj[i].replace(/\./g,"/")+".js",function(){
				$.loadArray(obj,fn,i+1);
			});
		}else{
			fn();
		}
	}
	
	
	window.load = function(obj,fn){
		if($.isArray(obj)){
			if(fn==null)fn=function(){};
			$.loadArray(obj,fn,0);
		}else{
			$.load(obj,fn);
		}
	}
	
	$.extend($.fn.validatebox.defaults.rules, {   
		equals: {   
			validator: function(value,param){   
				return value == $(param[0]).val();   
			},   
			message: '两次输入的内容不一致'  
		},
		regx:{   
			validator: function(value,param){   
				return new RegExp(param[0]).test(value);   
			},   
			message: '您输入的内容不符合要求'  
		}
	});
	

	
	
	
	/**
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI
	 * 
	 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
	 */
	$.fn.panel.defaults.onBeforeDestroy = function() {
		var frame = $('iframe', this);
		try {
			if (frame.length > 0) {
				for ( var i = 0; i < frame.length; i++) {
					frame[i].contentWindow.document.write('');
					frame[i].contentWindow.close();
				}
				frame.remove();
				if ($.browser.msie) {
					CollectGarbage();
				}
			}
		} catch (e) {
		}
	};
	
	/**
	 * 使panel和datagrid在加载时提示
	 * 
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI
	 * 
	 */
	$.fn.panel.defaults.loadingMessage = '加载中....';
	$.fn.datagrid.defaults.loadMsg = '加载中....';
	
	 
	 
	/**
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI
	 * 
	 * 防止panel/window/dialog组件超出浏览器边界
	 * @param left
	 * @param top
	 */
	var easyuiPanelOnMove = function(left, top) {
		var l = left;
		var t = top;
		if (l < 1) {
			l = 1;
		}
		if (t < 1) {
			t = 1;
		}
		var width = parseInt($(this).parent().css('width')) + 14;
		var height = parseInt($(this).parent().css('height')) + 14;
		var right = l + width;
		var buttom = t + height;
		var browserWidth = $(window).width();
		var browserHeight = $(window).height();
		if (right > browserWidth) {
			l = browserWidth - width;
		}
		if (buttom > browserHeight) {
			t = browserHeight - height;
		}
		$(this).parent().css({/* 修正面板位置 */
			left : l,
			top : t
		});
	};
	$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
	$.fn.window.defaults.onMove = easyuiPanelOnMove;
	$.fn.panel.defaults.onMove = easyuiPanelOnMove;
	
	
	/**
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI,jQuery cookie plugin
	 * 
	 * 更换EasyUI主题的方法
	 * 
	 * @param themeName
	 *            主题名称
	 */
	window.changeTheme = function(themeName) {
		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);
	
		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			}
		}
	
		$.cookie('easyuiThemeName', themeName, {
			expires : 7,
			path	: "/"
		});
	};
	
	$.getFileSize=function(size)
	{
		if(size < 1024) {
			return size + " bytes";
		} else if(size < 1048576) {
			return (Math.round(((size*10) / 1024))/10) + " KB";
		} else {
			return (Math.round(((size*10) / 1048576))/10) + " MB";
		}
   }
	   
 
   
   $.fn.fileShower = function(pid,t){
	   var the = $(this);
	   $.post(
			   "files.action",
			   {"pid":pid,"t":t},
			   function(data){
				   for(var i=0;i<data.length;i++){
					   var div = $("<div></div>").addClass("_file_item").appendTo(the);
				   		$("<a href=\"download.action?id="+data[i].fileId+"\">"+data[i].fileName+"</a>").linkbutton({plain:true}).appendTo(div);
				   }
			   },"json"
	   );
	   return the;
   }
   

	
	  $.fn.uploader = function(config){
		   	var the = $(this);
		   	config = $.extend({
				url 	:	"uploader.jsp",
				name	:	"file",
				deleteable:	true   
		  	},config);
		   

		   
		   	var GetFrameWindow = function(frame){
				return frame && typeof(frame)=='object' && frame.tagName == 'IFRAME' && frame.contentWindow;
			}
			
		   
			var Uploader = function (callBack){
				var addWin = $('<div style="overflow: hidden;"/>');
				var upladoer = $('<iframe/>');
				upladoer.attr({'src':config.url,width:'100%',height:'100%',frameborder:'0',scrolling:'no'});
				addWin.window({
					title:"上传文件",
					height:350,
					width:550,
					minimizable:false,
					modal:true,
					collapsible:false,
					maximizable:false,
					resizable:false,
					content:upladoer,
					onClose:function(){
						var fw = GetFrameWindow(upladoer[0]);
						var files = fw.files;
						$(this).window('destroy');
						if(fw.errors.length>0){
							$.messager.error("上传错误","有["+fw.error.length+"]个文件上传错误!");
						}
						callBack.call(this,files);
					},
					onOpen:function(){
						var target = $(this);
						setTimeout(function(){
							var fw = GetFrameWindow(upladoer[0]);
							fw.target = target;
						},100);
					}
				});
			}
			
			$.each(the,function(i,e){
				var one = $(e);
				var btn =		$("<a href=\"javascript:void(0);\">上传附件</div>")
								.appendTo(one)
								.click(function(){
									Uploader(function(files){
										
										for(var i=0;i<files.length;i++){
											var div = $("<div></div>").addClass("_file_item").appendTo(one);
											div.append("<input name=\""+config.name+"\" type=\"hidden\" value=\""+files[i].id+"\"/>");
											$("<a href=\"download.action?id="+files[i].id+"\">"+files[i].name+"</a>").linkbutton({plain:true}).appendTo(div);
											$("<a href=\"javascript:void(0);\">删除</a>").click(function(){
												$(this).parents("._file_item").remove();
											}).linkbutton({plain:true}).appendTo(div);
											
										}
									});
								})
								.linkbutton();
			});
			return the;
	   }
	  
   $.getFileExt=function(fileName)
   {
		return fileName.substr(fileName.lastIndexOf(".")+1).toLowerCase();
   }
})(jQuery);


Date.prototype.format = function(format)
{
		var o = 
		{
			"M+" : this.getMonth()+1, //month
			"d+" : this.getDate(),    //day
			"H+" : this.getHours(),   //hour
			"m+" : this.getMinutes(), //minute
			"s+" : this.getSeconds(), //second
			"q+" : Math.floor((this.getMonth()+3)/3), //quarter
			"S" : this.getMilliseconds() //millisecond
		}
		
		if(/(y+)/.test(format)) 
		format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
		for(var k in o)
		if(new RegExp("("+ k +")").test(format))
		format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
		return format;
}

String.prototype.toDate = function(format){
	format = format==null?"yyyy-MM-dd":format;
	var d = new Date();
		var o = 
		{
			"y+" : "d.setYear(val)",	//year
			"M+" : "d.setMonth(val-1)", //month
			"d+" : "d.setDate(val)",    //day
			"H+" : "d.setHours(val)",   //hour
			"m+" : "d.setMinutes(val)", //minute
			"s+" : "d.setSeconds(val)", //second
			"S+" : "d.setMilliSeconds(val)" //millisecond
		}
	var regx = format
	for(var k in o){
		if(new RegExp("("+ k +")").test(format))
			regx = regx.replace(new RegExp(k),"[0-9]+");
	}
	
	if(!new RegExp("^"+regx+"$").test(this)){
		throw "日期格式不正确:"+format;
	}
	
	for(var k in o){
		if(new RegExp("("+ k +")").test(format)){
			var regx = format;
			for(var temp in o){
				if(temp == k){
					regx = regx.replace(new RegExp(temp),"([0-9]+)");
				}else{
					regx = regx.replace(new RegExp(temp),"[0-9]+");
				}
				
			}
			var val = Number(this.replace(new RegExp("^"+regx+"$"),"$1"));
			try{
				
				if(k=="S+"){
					d.setMilliseconds(val);
				}else{
					eval(o[k].replace("val",val));
				}
			}catch(e){alert(e);}
		}else{
			try{
				var val = k=="M+"?1:0;
				if(k=="S+"){
					d.setMilliseconds(val);
				}else{
					eval(o[k].replace("val",val));
				}
			}catch(e){alert(e);}
		}
	}
	return d;
}



String.prototype.trim = function()
{
return this.replace(/(^\s*)|(\s*$)/g, "");
}

String.prototype.leftTrim = function()
{
return this.replace(/(^\s*)/g, "");
}

String.prototype.rightTrim = function()
{
return this.replace(/(\s*$)/g, "");
}