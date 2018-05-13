<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>费用登记</title>
</head>
<body>
	<form action="costServlet?method=add" method="post">
		<table>
			<tr>
				<td>业主号</td>
				<td><input type="text" name="customerid"></td>
			</tr>
			<tr>
				<td>物业费用</td>
				<td><input type="text" name="cost"></td>
			</tr>
			<tr>
				<td>实交费用</td>
				<td><input type="text" name="money"></td>
			</tr>
			<tr>
				<td>备注</td>
			<td><input type="text" name="costmemo"></td>
			</tr>
			<tr>
			    <td>
			        <input type="submit" value="提交">
			    </td>
			    <td>
			        <input type="reset" value="重置">
			    </td>
			</tr>
		</table>
	</form>
</body>
</html>