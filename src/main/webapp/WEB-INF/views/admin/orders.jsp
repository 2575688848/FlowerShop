<%@page import="entity.order"%>
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
List<order> orders=(List<order>)request.getAttribute("orders");
Iterator<order> iterator=orders.iterator();
%>
<br/>
 
<div align="center">
<div>Flower Orders</div>
<table id="dg" style="width:100%" title="My Flowers" 
 align="center" border=1> 
   
    <thead>
    <tr>
    <th>Id</th>
    <th>FlowerName</th>
    <th>Username</th>
    <th>Count</th>
    <th>Operate</th>
   </tr>
    </thead>
    <%while(iterator.hasNext()){ %>
     	<tr>
     	<%order ord=iterator.next(); %>
     	<td align="center" valign="middle"><%=ord.getId() %></td>
     	<td align="center" valign="middle"><%=ord.getFlowername()%></td>
     <td align="center" valign="middle"><%=ord.getUsername()%></td>
     	<td align="center" valign="middle"><%=ord.getCount() %></td>
     	<td align="center" valign="middle">
     	<a href="ConfirmOrder?id=<%=ord.getId()%>"   plain="true">确认订单</a>
     	</td>
     	
     	</tr>
    <%} %>
    </table>
    <br/><br/><br/>
    <a href="DeleteOrderAll">一键确认</a>
  </div>
  
</body>
</html>