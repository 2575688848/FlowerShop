<%@ page language="java" import="java.util.*" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.divForm{
position: absolute;/*绝对定位*/
width: 300px;
height: 200px;

/* border: 1px solid black; */
text-align: center;/*(让div中的内容居中)*/
top: 50%;
left: 50%;
margin-top: -200px;
margin-left: -150px;
}
</style>
</head>
<body>


<div class="divForm">
管理员登录
<br/><br/><br/>
<form action="LoginTest" method="post" >
<label style="width:50px;float:left;text-align:right;">账号</label>
<input name="username" type="text"/><br/><br/>
<label style="width:50px;float:left;text-align:right;">密码</label>
<input name="password" type="text"/>
<br>
<input type="submit" value="登录"/>
</form>
<span style="color:red;">${err}</span>
</div>

</body>
</html>