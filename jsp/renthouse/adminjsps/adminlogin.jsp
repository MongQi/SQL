<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminlogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   
<form action="<c:url value='/admin/AdminServlet'/>" method="post">  
  
<h1>管理员登录</h1>

<br>
<br>
管理员账号:<br>

    <input type="text" name="username" style="width: 200px" value="${form.username }"><br> 

  <br>
密		码:<br>

    <input type="password" name="password" style="width: 200px" value="${form.password }"><br> 
 
 <br>
  <input type="submit" name="button"  value="进入后台" >


	<br/>  
	 
</form>  
        

</body> 
  </body>
</html>