<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
	
  </head>
  
 <body>

<h1>修改密码</h1>
<div class="form-w3ls">

  
    <div >
		<div id="signup-agile">   
			<form action="ModifyServlet" method="post"> 
				
				<p class="header">当前账号：</p>
				<input type="text" name="userid"  style="width:250px" >

				<p class="header">原密码：</p>
				<input type="password" name="oldpwd"  style="width:250px" >

				<p class="header">新密码：</p>
				<input type="password" name="newpwd"  style="width:250px" >	
				
				<p class="header">确认密码：</p>
				<input type="password" name="newpwd1" style="width: 250px" ><br>
				<font color="red">${msg }</font><br>
				<input type="submit" class="register" value="修改">
				
				
			</form>
		</div> 
    </div>
</div> 
 

<!-- js files -->
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<!-- /js files -->

 
</body>
</html>
