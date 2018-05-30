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
<br/>
<div align="center">搜索结果</div>
<div align="right"><a href="ShopCar">我的购物车</a></div>
<br/><br/><br/>
            <div>
             <form action="SearchFlower">
             <span>&nbsp</span><span>&nbsp</span><span>&nbsp</span>
            <input type="submit" value="搜索"/>
            <input type="text" name="condition"/>
            </form>      
            </div>
            <br/>
<%
List<flower> flowers=(List<flower>)request.getAttribute("flowers");
Iterator<flower> iterator=flowers.iterator();
%>
<table border=0 width="100%" align='center' background="gif/one6.jpg">
<%
while(iterator.hasNext()){%>
<tr align="left">
<%
for(int i=1;i<=5&&iterator.hasNext();i++){
%>
<td >
<% flower flo=iterator.next(); %>
<img src=<%=flo.getUrl() %>/><br/>

<%=flo.getName() %>|<%=flo.getPrice() %><br/>
<a href="ShoppingCart?flowerid=<%=flo.getId()%>">添加到购物车</a>

</td>
<%}%>
</tr> 
	
<%} %>
</table>
</body>
</html>