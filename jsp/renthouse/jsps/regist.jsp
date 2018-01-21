<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册新用户</title>
    
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

<h1>填写个人信息</h1>
<div class="form-w3ls">
     
    <div >
		<div id="signup-agile">   
			<form action="RegistServlet" method="post"> 
				<p class="header">账号:</p>
				<input type="text" name="userid"  style="width:250px" value="${form.userid }"><font color="red">${msg }<b>${errors.userid }</b></font>

				
				<p class="header">用户名:</p>
				<input type="text" name="username"  style="width:250px" value="${form.username }"><font color="red"><b>${errors.username }</b></font>

				
			
				<p class="header">性别:</p><br>
					男：<input type="radio" name="usersex" value="男"/>
					女：<input type="radio" name="usersex" value="女"/><font color="red"><b>${errors.usersex }</b></font>
				<br>
				<br>
				
				<p class="header">电话:</p>
				<input type="text" name="usertel" style="width: 250px" value="${form.usertel }"><font color="red"><b>${errors.usertel }</b></font>

				
				<p class="header">证件号:</p>
				<input type="text" name="uidcard" style="width: 250px" value="${form.uidcard }"><font color="red"><b>${errors.useridcard }</b></font>

				
				<p class="header">密码:</p>
				<input type="password" name="password" style="width: 250px"><font color="red"><b>${errors.password }</b></font>

				
				<p class="header">验证码:</p>
				<input type="text" name="verifyCode" style="width: 200px" ><font color="red"><b>${errors.verifyCode }</b></font>
				<br>
				<img src="/renthouse/VerifyCodeServlet"/>

				
				<input type="submit" class="register" value="注册">
				<br>
				<br>
				
			</form>
		</div> 
    </div><!-- tab-content -->
</div> <!-- /form -->	  

<!-- js files -->
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<!-- /js files -->
</body>
</html>
