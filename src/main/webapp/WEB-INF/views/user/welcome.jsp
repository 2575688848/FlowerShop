<%@ page language="java"  contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">恭喜你注册成功，5秒后为你自动登录</div>
<%response.setHeader("refresh", "5 ; URL=Login");%>
</body>
</html>