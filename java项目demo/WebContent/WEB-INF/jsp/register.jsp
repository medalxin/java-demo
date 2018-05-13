<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style>
	* { margin:0; padding:0;}
	.box { width:350px; height:300px; margin:250px auto; border:1px solid #000; box-shadow:0 2px 10px #000; text-align:center; font-size:15px;}
	.box h2 { color:red; margin:40px auto 5px; font-size:25px;}
	.box input { margin-top:10px;}
</style>
</head>
<body>
	<div class="box">
		<h2>智能小区物业管理系统</h2>
		<form action="${pageContext.request.contextPath }/servlet/userServlet?method=register" method="post">
			用&nbsp;户&nbsp;名:&nbsp;	<input type="text" name="username">
			<br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：	<input type="password" name="password">
			<br/>
			确认密码：	<input type="password" name="passwordCon">
			<br/>
			生&nbsp;&nbsp;&nbsp;&nbsp;日：	<input type="text" name="birthday">
			<br/>
			<br/>
			类&nbsp;型：	<select name="status">
							<option value="1">管理员</option>
							<option value="2">业主</option>
						</select>
			<br/>
				   	<input type="submit" value="提交" style="width:70px; height:25px;">&nbsp;&nbsp;&nbsp;&nbsp;
				   	<input type="button" value="取消" style="width:70px; height:25px;">
		</form>
	</div>
</body>
</html>