<%@page import="mapper.flowermapper"%>
<%@page import="entity.shoppingcart"%>
<%@page import="entity.flower"%>
<%@page import="sqlSession.sqlsesssion" %>
<%@page import="mapper.shoppingcartmapper"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" import="java.util.*" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%
List<shoppingcart> shopcarts=(List<shoppingcart>)request.getAttribute("shopcarts");
Iterator<shoppingcart> iterator=shopcarts.iterator();
%>
<%
SqlSession sqlSession=sqlsesssion.getSqlSession();
flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
%>
<br/>
 
<div align="center">
<div>Shopping Cart</div>
<table id="dg" style="width:100%" title="My Flowers" 
 align="center" border=1> 
   
    <thead>
    <tr>
    <th>Id</th>
    <th>花名</th>
    <th>价格</th>
    <th>数量</th>
    <th>操作</th>
   </tr>
    </thead>
    <% double sum=0; %>
    <%while(iterator.hasNext()){ %>
    
     	<tr>
     	<% shoppingcart ord=iterator.next(); %>
     	<%flower flo=flowermapper.getFlowerById(ord.getFlowerid()); %>
     	<td align="center" valign="middle"><%=ord.getId() %></td>
     	<td align="center" valign="middle"><%=ord.getFlowername()%></td>
     <td align="center" valign="middle"><%=flo.getPrice()%></td>
     	<td align="center" valign="middle"><%=ord.getCount() %></td>
     	<td align="center" valign="middle">
     	<a href="Confirm?id=<%=ord.getId()%>"  plain="true">确认订单</a>|
     	<a href="Cancel?id=<%=ord.getId()%>" onClick="return confirm('确定取消吗?');">取消订单</a>
     	</td>
     	</tr>
     	<%sum+=ord.getCount()*flo.getPrice(); %>
    <%} %>
    </table>
    <br/>
    <div align="right">商品总价:<%=sum %></div>
    <br/><br/><br/>
    <a href="DeleteAll">一键确认</a>
  </div>
  
</body>
</html>