<%@page import="entity.flower"%>
<%@ page language="java" import="java.util.*" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="gif/04.jpg" >
<br/>
<div>
  <a href="AdminLogin">管理员登录</a>|<a href="UserLogin">客户登录</a>
</div>
<div align="center">欢迎进入我的花店</div>
<br/><br/><br/>
<%
List<flower> flowers=(List<flower>)request.getAttribute("flowers");
Iterator<flower> iterator=flowers.iterator();
%>
<table border=0 width="100%" align='center'>
<%
while(iterator.hasNext()){%>
<tr align="left">
<%
for(int i=1;i<=5&&iterator.hasNext();i++){
%>
<td>
<% flower flo=iterator.next(); %>
<img src=<%=flo.getUrl() %>/><br/>

<%=flo.getName() %>|<%=flo.getPrice() %>

</td>
<%}%>
</tr> 
	
<%} %>


</table>
<%-- <form action="Login" method="post" >
<label style="width:50px;float:left;text-align:right;">用户名</label>
<input name="username" type="text"/><br/>
<label style="width:50px;float:left;text-align:right;">密码</label>
<input name="password" type="text"/>
<br>
<input type="submit" value="登录"/>
</form>
<span style="color:red;">${errorMsg}</span> --%>
</body>
</html>