<%@page import="entity.flower"%>
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
List<flower> flowers=(List<flower>)request.getAttribute("flowers");
Iterator<flower> iterator=flowers.iterator();
%>
<br/><br/>
<div align="center">
<div>Search Results</div>
<table id="dg" style="width:100%" title="My Flowers" 
 align="center" border=1> 
   
    <thead>
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Operate</th>
   </tr>
    </thead>
    <%while(iterator.hasNext()){ %>
     	<tr>
     	<%flower flo=iterator.next(); %>
     	<td align="center" valign="middle"><%=flo.getId() %></td>
     	<td align="center" valign="middle"><%=flo.getName()%></td>
     <td align="center" valign="middle"><%=flo.getCategory()%></td>
     	<td align="center" valign="middle"><%=flo.getPrice() %></td>
     	<td align="center" valign="middle">
     	<a href="EditFlower?id=<%=flo.getId()%>"   plain="true">编辑</a>|
     	<a href="DeleteFlower?id=<%=flo.getId()%>" onClick="return confirm('确定删除吗?');">删除</a>
     	</td>
     	
     	</tr>
    <%} %>
    </table>
  </div>
  <h2>${meaasge}</h2>
</body>
</html>