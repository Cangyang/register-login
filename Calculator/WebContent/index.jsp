<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 
       SimpleDateFormat up = new SimpleDateFormat("yyyy-MM-dd");
       String username = null;
       String lastLoginTime = null;
       String message = null;
       username = (String)session.getAttribute("username");
       lastLoginTime = (String)session.getAttribute("lastLoginTime");
       if(username!=null)
       {
    	   if(lastLoginTime != null){
    		   message = "亲爱的用户 "+username+"，您好！您上次登录时间为  "+lastLoginTime+"";
    	   } else {
    		   message = "亲爱的用户 "+username+" 您好，欢迎您登陆本系统！";
    	   }
%>
<link href="http://fonts.googleapis.com/css?family=Terminal+Dosis&subset=latin" rel="stylesheet" type="text/css" />
<style type="text/css">
.middle { 
    position: relative; 
    border: 2px solid silver; 
    height: 300px; width: 600px; 
    margin: 0 auto; 
    text-align: center;
/*     background: aquamarine; */
    background: beige;
    box-shadow: 10px 10px 5px #888888;
}
.middle tr th { 
    text-align: center; 
    font-size: 16px;
}
.middle .title { 
    margin: 0; 
    text-align: center; 
    font-size: 40px;  
    color: white;
    font-family: "Terminal Dosis", sans-serif; 
    text-shadow: 5px 5px 0 transparent, 2px 2px 0 #888eee; 
    overflow: hidden;
}
#menubar {
    background:-moz-linear-gradient(left,#ace,#f96);/*Mozilla*/
    background:-webkit-gradient(linear,0 50%,100% 50%,from(#ace),to(#f96));/*Old gradient for webkit*/
    background:-webkit-linear-gradient(left,#ace,#f96);/*new gradient for Webkit*/
    background:-o-linear-gradient(left,#ace,#f96); /*Opera11*/
    width: 900px;
    height: 40px;
    margin: 4px auto;
    text-align: center;
    line-height: 40px;
    -moz-border-radius: 5px;      /* Gecko browsers */
    -webkit-border-radius: 5px;   /* Webkit browsers */
    border-radius:5px;            /* W3C syntax */
    font-size: 18px;
    -webkit-text-stroke:1px #fff111;
    text-shadow:2px 2px 8px green;
}
#menubar a {
    background: cadetblue;
    padding: 4px;
    -moz-border-radius: 5px;      /* Gecko browsers */
    -webkit-border-radius: 5px;   /* Webkit browsers */
    border-radius:5px;            /* W3C syntax */
    color: darkslateblue;
    text-decoration: none;
}
#menubar a:hover {
    opacity: 0.5;
    filter:alpha(opacity=50);
}
</style>
<script type="text/javascript" >
//表单验证
function checkform(){
	var num1 = document.getElementById("calAction_cal_num1");
	var num2 = document.getElementById("calAction_cal_num2");
	var flag = document.getElementById("calAction_cal_flag");
	
	if(num1.value==""){
		alert("请输入计算参数一！");
		num1.focus();
		return false;
	}
	if(isNaN(num1.value)){
		alert("参数一请输入数字！");
		num1.focus();
		return false;
	}
	if(num2.value==""){
		alert("请输入计算参数二！");
		num2.focus();
		return false;
	}
	if(isNaN(num2.value)){
		alert("参数二请输入数字！");
		num2.focus();
		return false;
	}
	if(flag.value==""){
		alert("请选择计算方法！");
		flag.focus();
		return false;
	}
	
};

window.onload=function(){
	var result = document.getElementById("calAction_cal_result");
	var flag = document.getElementById("calAction_cal_flag");
	result.disabled = true;
	var text = document.getElementById("text");
	if(!flag.value==""){
		var type = "";
		if(flag.value=="1"){
			type = "加法";
		}
		if(flag.value=="2"){
			type = "减法";
		}
		if(flag.value=="3"){
			type = "乘法";
		}
		if(flag.value=="4"){
			type = "除法";
		}
		text.innerHTML = "计算类型-" + type;
	}
};


</script>
<title>洪华奥是个大胖子</title>
</head>
<body>
<div id="menubar"><%=message %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout">注销</a></div>

<s:form name="calAction" action="calAction" method="post" theme="simple" align="center" onsubmit="return checkform(this)">
<table class="middle">
<tr><th class="title" colspan="5">简单计算器实现</th></tr>
<tr>
  <td><p>计算参数一</p></td>
  <td><p id="text">计算类型</p></td>
  <td><p>计算参数二</p></td>
  <td>&nbsp;</td>
  <td><p>计算结果</p></td>
</tr>
<tr>
  <td><s:textfield name="cal.num1"/></td>
  <td><s:select name="cal.flag" headerValue="--请选择计算类型--" headerKey="" list="#{'1':'+','2':'-','3':'*','4':'/'}" /></td>
  <td><s:textfield name="cal.num2"/></td>
  <td><s:submit value="计算结果" /></td>
  <td><s:textfield name="cal.result"/></td>
</tr>
<tr><td><s:actionmessage cssStyle="color: red; list-style-type:none;"/></td></tr>
</table>
</s:form>
<%
       }else {
%>
<div class="error">
<p>本站禁止非法登陆后台！</p>
</div>
<%     }%>
</body>
</html>