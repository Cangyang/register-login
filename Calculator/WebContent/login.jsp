<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
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
#register {
    background:-moz-linear-gradient(left,#ace,#f96);/*Mozilla*/
    background:-webkit-gradient(linear,0 50%,100% 50%,from(#ace),to(#f96));/*Old gradient for webkit*/
    background:-webkit-linear-gradient(left,#ace,#f96);/*new gradient for Webkit*/
    background:-o-linear-gradient(left,#ace,#f96); /*Opera11*/
    width: 600px;
    height: 40px;
    margin: 14px auto;
    text-align: center;
    line-height: 40px;
    -moz-border-radius: 5px;      /* Gecko browsers */
    -webkit-border-radius: 5px;   /* Webkit browsers */
    border-radius:5px;            /* W3C syntax */
    font-size: 18px;
    -webkit-text-stroke:1px #fff111;
    text-shadow:2px 2px 8px green;
    box-shadow: 5px 1px 5px #888888;
}
#register a {
    background: cadetblue;
    padding: 4px;
    -moz-border-radius: 5px;      /* Gecko browsers */
    -webkit-border-radius: 5px;   /* Webkit browsers */
    border-radius:5px;            /* W3C syntax */
    color: darkslateblue;
    text-decoration: none;
    cursor: pointer;
    
}
#register a:hover {
    opacity: 0.5;
    filter:alpha(opacity=50);
}
</style>
<script type="text/javascript" >
//表单验证
function checkform(){
	var username = document.getElementById("username");
	var userpass = document.getElementById("userpass");
	if(username.value == ""){
		alert("请输入您的登陆用户名！");
		username.focus();
		return false;
	}
	if(userpass.value == ""){
		alert("请输入您的登陆密码！");
		userpass.focus();
		return false;
	}
}
</script>
</head>
<body>
<s:form name="login" action="login" method="post" theme="simple" align="center" onsubmit="return checkform(this)">
<table class="middle">
<tr><th class="title" colspan="2">用户登录</th></tr>
<tr><th>输入用户名</th><td><s:textfield name="user.username" value="" id="username"/> </td></tr>
<tr><th>输入密码</th><td><s:password name="user.userpass" value="" id="userpass"/> </td></tr>
<tr><td colspan="2"><s:submit value="登录"/></td></tr>
<tr><td><s:actionmessage cssStyle="color: red; list-style-type:none;"/></td></tr>
</table>
</s:form>
<div id="register">现在还没有账号？马上<a href="register">注册</a></div>
</body>
</html>