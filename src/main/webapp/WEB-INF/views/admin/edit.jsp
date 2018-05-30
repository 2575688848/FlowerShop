<%@page import="entity.flower"%>
<%@ page language="java" import="java.util.*" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
flower flo=(flower)request.getAttribute("flower"); 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EditSave?" method="get">
<h1>
<span>Please Edit flower in the fields.</span>
</h1>
<div align="center">
<label>
<span>Id :</span>
<input id="name" type="text" name="id" value="<%=flo.getId() %>"  placeholder="Flower Name" readonly/>
</label>
<label>
<span>Name :</span>
<input id="name" type="text" name="name"  value="<%=flo.getName() %>" placeholder="Flower Name" />
</label>

<label>
<span>Category :</span>
<input id="email" type="text" name="category"  value="<%=flo.getCategory() %>" placeholder="Flower Category" />
</label>

<label>
<span>Price :</span>
<input id="name" type="text" name="price" value="<%=flo.getPrice() %>" placeholder="Flower Price" />
</label>

<label>
<span>Url :</span>
<input id="name" type="text" name="url" value="<%=flo.getUrl() %>" placeholder="Flower Url" />
</label>

<br/><br/>
<label>
<span>&nbsp;</span>
<input type="submit" class="button" value="Save" />
</label>
</div>

</form>
</body>
</html>