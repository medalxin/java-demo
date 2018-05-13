<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>
<script type="text/javascript">
function deleteitem(notify_id){
	var b = window.confirm("您确认要删除此条记录吗？");
	if(b){
	window.location.href="${pageContext.request.contextPath }/servlet/notifyServlet?method=notifyToDelete&notify_id="+notify_id;
	}
}

</script>
</head>
<body>
              欢迎您：${user.username } ${user.birthday }
   <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=modifyUI">修改</a>
   <a href="${pageContext.request.contextPath }/servlet/userServlet?method=logout">注销</a>
   <br/>
   <hr/>
  <a href="${pageContext.request.contextPath }/servlet/notifyServlet?method=notifyToAdd">公告录入</a>
  <a href="${pageContext.request.contextPath }/servlet/notifyServlet?method=notifyToQuery">公告查询</a>
   <a href="${pageContext.request.contextPath }/index.jsp">返回主页面</a>
 
 
   <div>
                公告编号：<input type="text" name="notify_id"><input type="button" value="查询" onclick="queryByCondition()">
   </div>
   
   <c:if test="${empty(notifyRecordList)}">
                 没有公告记录！！！
   </c:if>
   
   
   <c:if test="${!empty(notifyRecordList)}">
		<table width="70%" border="1">
			<tr>
				<td>公告编号</td>
				<td>员工编号</td>
				<td>公告内容</td>
				<td>公告时间</td>
				<td>公告标题</td>
				<td>操作</td>
			</tr>
            <c:forEach var="item" items="${notifyRecordList}">
            <tr>
                <td>${item.notify_id}</td>
				<td>${item.worker_id}</td>
				<td>${item.notify_con}</td>
				<td>${item.notify_date}</td>
				<td>${item.notify_title}</td>
				<td>
				   <a href="javascript:void(0)" onclick="deleteitem(${item.notify_id})">删除</a>
				</td>
              </tr>
            </c:forEach>

		</table>


	</c:if>

 
 
</body>
</html>