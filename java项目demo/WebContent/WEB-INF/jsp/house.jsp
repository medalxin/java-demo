<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房产登记</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/servlet/houseServlet?method=add" method="post">
		<table>
		<tr>
				<td>业主编号：</td>
				<td><input type="text" name="customerid"></td>
				
			</tr>
			<tr>
				<td>房间号：</td>
				<td><input type="text" name="hallNo">楼<input type="text" name="houseNo">房间号</td>
				
			</tr>
			<tr>
				<td>房产区域：</td>
				<td><input type="text" name="homezone"></td>
			</tr>
			<tr>
				<td>房产楼号：</td>
				<td><input type="text" name="homebuilding"></td>
			</tr>
			<tr>
				<td>房产单元号：</td>
				<td><input type="text" name="homeunit"></td>
			</tr>
			<tr>
				<td>房产面积：</td>
				<td><input type="text" name="homearea"></td>
			</tr>
			<tr>
				<td>房产类型：</td>
				<td><input type="text" name="hometype"></td>
			</tr>
			<tr>
				<td>房产备注：</td>
				<td><input type="text" name="homememeo"></td>
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