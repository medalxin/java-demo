<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/servlet/workerServlet?method=add" method="post">
		<table>
		<tr>
				<td>员工号:</td>
				<td><input type="text" name="worker_id"></td>
			</tr>
			<tr>
				<td>员工姓名:</td>
				<td><input type="text" name="worker_name"></td>
			</tr>
			<tr>
				<td>员工性别:</td>
				<td><input type="text" name="worker_sex"></td>
			</tr>
			<tr>
				<td>员工年龄:</td>
				<td><input type="text" name="worker_age"></td>
			</tr>
			<tr>
				<td>员工电话:</td>
				<td><input type="text" name="worker_tel"></td>
			</tr>
			<tr>
				<td>员工办公电话:</td>
				<td><input type="text" name="office_tel"></td>
			</tr>
			<tr>
				<td>员工备注:</td>
				<td><input type="text" name="worker_memo"></td>
			</tr>
			<tr>
				<td>员工身份证号:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>在职岗位:</td>
				<td><input type="text" name="position"></td>
			</tr>
			
			<tr>
				<td>密码:</td>
				<td><input type="text" name="worker_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>