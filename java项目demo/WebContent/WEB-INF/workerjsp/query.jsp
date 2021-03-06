<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询删除信息</title>
<script type="text/javascript">
function deleteitem(worker_id){
	var b = window.confirm("您确认要删除这条记录吗？");
	if(b){
		window.location.href="${pageContext.request.contextPath}/servlet/workerServlet?method=ToDelete&worker_id="+worker_id;
	}
}
function show(){
	var txt="Hello World!";
	document.getElementById("show").value = txt;
}
</script>
</head>
<body>
	<div>
		查询员工信息：<input type="text" name="worker_name"><input
			type="button" value="查询" onClick="queryByCondition()">
	</div>

	<c:if test="${empty(workerList) }">
                 没有员工信息！！！
   </c:if>

	<c:if test="${!empty(workerList) }">
		<table width="70%" border="1">
			<tr>
				<td>员工名称</td>
				<td>员工电话</td>
				<td>员工性别</td>
				<td>操作</td>

			</tr>

			<c:forEach var="item" items="${workerList }">
				<tr>
					<td>${item.worker_name }</td>
					<td>${item.worker_tel }</td>
					<td>${item.worker_sex }</td>
					<td>
                      <a href="javascript:void(0)" onClick="deleteitem(${item.worker_id})">删除</a>
                  </td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>