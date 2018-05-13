<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/servlet/registerServlet?method=register" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="passwordCon"></td>
			</tr>
			<tr>
				<td>生日:</td>
				<td><input type="text" name="birthday"></td>
			</tr>
			<tr>
				<td>
                    <input type="submit" value="提交">                   
                </td>	
                <td>
                    <input type="button" value="注册">                   
                </td>		
			</tr>
		</table>
	</form>

</body>
</html>