<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保安巡查</title>
<style>
</style>
</head>
<body>
      <form action="${pageContext.request.contextPath }/servlet/cleaningServlet?method=add" method="post">
	      <table style="float:left;">
	      	<tr>
	      		<td>保洁区域:</td>
	      		<td><input type="text" name="CleaningSite" /></td>
	      	</tr>
	      	<tr>
	      		<td>保洁时间区间:</td>
	      		<td><input type="text" name="CleaningTime" /></td>
	      	</tr>
	      	<tr>
	      		<td>保洁负责人:</td>
	      		<td><input type="text" name="Cleaning" /></td>
	      	</tr>
	      	<tr>
	      		<td>保洁负责人电话:</td>
	      		<td><input type="text" name="CleaningTel" /></td>
	      	</tr>
	      	<tr>
	      		<td>保洁备注:</td>
	      		<td><input name="CleaningRemarks" style="resize:none; width:200px; height:100px;"></input></td>
	      	</tr>
	      	<tr>
	      		<td> <input type="submit" value="提交"></td></td>
	      		<td><input type="button" value="取消" /></td>
	      	</tr>
	      </table>
      </form>
</body>
</html>