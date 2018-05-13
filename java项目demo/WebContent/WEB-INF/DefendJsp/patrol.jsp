<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巡查登记</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/patrolServlet?method=add" method="post">
		<table>
			<tr>
				<td>巡查编号：</td>          
				<td><input type="text" name="workId"></td>
			</tr>
			<tr>
				<td>巡查地区：</td>
				<td><input type="text" name="patrolArea"></td>
			</tr>
			<tr>
				<td>巡查人员：</td>
				<td><input type="text" name="patrolPerson"></td>
			</tr>
			<tr>
				<td>巡查结果：</td>
				<td><input type="text" name="patrolResult"></td>
			</tr>
			<tr>
			    <td>
			        <input type="submit" value="提交">
			    </td>
			    <td>
			        <input type="reset" value="重置" >
			    </td>
			</tr>
		</table>
	</form>

</body>
</html>