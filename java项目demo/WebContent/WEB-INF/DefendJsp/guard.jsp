<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报修登记</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/guardServlet?method=add" method="post">
		<table>
			<tr>
				<td>员工编号：</td>          
				<td><input type="text" name="workerid"></td>
			</tr>
			<tr>
				<td>事由内容：</td>
				<td><input type="text" name="guardcon"></td>
			</tr>
			<tr>
				<td>负责人：</td>
				<td><input type="text" name="personname"></td>
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