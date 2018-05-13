<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报修登记</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/repairServlet?method=add" method="post">
		<table>
			<tr>
				<td>房间号：</td>          
				<td><input type="text" name="hallNo">楼<input type="text" name="houseNo">房间号</td>
			</tr>
			<tr>
				<td>报修内容：</td>
				<td><input type="text" name="content"></td>
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