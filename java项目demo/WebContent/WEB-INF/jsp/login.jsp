<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
	* { margin:0; padding:0;}
	.box { width:350px; height:250px; margin:250px auto; border:1px solid #000; box-shadow:0 2px 10px #000; text-align:center; font-size:15px;}
	.box h2 { color:red; margin:40px auto 25px; font-size:25px;}
</style>
</head>
<body>
	<div class="box">
		<h2>智能小区物业管理系统</h2>
		<form action="${pageContext.request.contextPath }/servlet/userServlet?method=login" method="post">
			用户名:	<input type="text" name="username">
			<br/>
			<br/>
			密&nbsp;码：	<input type="password" name="password">
			<br/>
			<br/>
			类&nbsp;型：	<input type="radio" name="status" id="admin" value="1" checked>
						<label for="admin">管理员</label>
					<input type="radio" name="status" id="user"  value="2">
					<label for="user">业主</label>
			<br/>
			<br/>
				   	<input type="submit" value="登录" style="width:70px; height:25px;">&nbsp;&nbsp;&nbsp;&nbsp;
				   	<input type="button" value="注册" style="width:70px; height:25px;">
		</form>
	</div>
</body>
</html>