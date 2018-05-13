<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function deleteitem(homeid){
	var b=window.confirm("您确认要删除这条记录么？");
	
	if(b){
		window.location.href="${pageContext.request.contextPath }/servlet/houseServlet?method=houseToDelete&homeid="+homeid;
	}
	
}
</script>
</head>
<body>
   <c:if test="${user!=null }">
                欢迎您: ${user.username } ${user.password } ${user.birthday }
      <a href="${pageContext.request.contextPath }/servlet/modifyUserInfUIServlet">修改</a>
      <a href="${pageContext.request.contextPath }/servlet/logoutServlet">注销</a>
      <br/>
              
      <a href="${pageContext.request.contextPath }/servlet/houseToAddUIServlet?method=houseToAdd">房产登记</a>
      <a href="${pageContext.request.contextPath }/servlet/houseServlet?method=houseToQuery">房产查询</a>
      <a href="${pageContext.request.contextPath }/index.jsp">返回主页面</a>
        
   </c:if>
   
   <c:if test="${user==null }">
	
	     
		<a href="servlet/LoginUIServlet" style="text-decoration:none;">登录</a>
		<a href="servlet/RegisterUIServlet" style="text-decoration:none;">注册</a>
	

	</c:if>
	
	<div>
	       房产区域：<input type="text" name="homezone">          <input type="button" value="查询" onclick="">
	</div>
	<c:if test="${empty(houseRecordList) }">
		没有房产记录！！！
	</c:if>
	<c:if test="${!empty(houseRecordList) }">

		<table width="70%" border="1">
			<tr>
				
				<td>业主编号</td>
				<td>房产区域</td>
				<td>房产楼号</td>
				<td>房产单元号</td>
				<td>房间号</td>
				<td>房产面积</td>
				<td>房产类型</td>
				<td>房产备注</td>
				<td>操作</td>
				
			</tr>
			
			<c:forEach var="item" items="${houseRecordList}">
			
			   <tr>
			   
				<td>${item.customerid }</td>
				<td>${item.homezone }</td>
				<td>${item.homebuilding }</td>
				<td>${item.homeunit }</td>
				<td>${item.homenumber }</td>
				<td>${item.homearea }</td>
				<td>${item.hometype }</td>
				<td>${item.homememeo }</td>
				<td>
					<a href="javascript:void(0)" onclick="deleteitem(${item.homeid})">删除</a>
				</td>
				</tr>
			</c:forEach>
			
		</table>
	</c:if>
</body>
</html>