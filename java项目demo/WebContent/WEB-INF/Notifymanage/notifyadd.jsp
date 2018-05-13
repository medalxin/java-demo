<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告登记</title>
</head>
<body>
    
    <form action="${pageContext.request.contextPath}/servlet/notifyServlet?method=add" method="post">
		<table>
			<tr>
				<td>公告编号:</td>
				<td><input type="text" name="notify_id"></td>
			</tr>
			<tr>
				<td>员工编号:</td>
				<td><input type="text" name="worker_id"></td>
			</tr>
			<tr>
				<td>公告内容:</td>
				<td><input type="text" name="notify_con"></td>
			</tr>
			<tr>
				<td>公告日期:</td>
				<td><input type="text" name="notify_date"></td>
			</tr>
			<tr>
				<td>公告标题:</td>
				<td><input type="text" name="notify_title"></td>
			</tr>
			<tr>
			   <td>
			       <input type="submit" value="提交">
			   </td>
			   <td>
			       <input type="button" value="重置">
			   </td>
			</tr>
		</table>
	</form>
    
</body>
</html>