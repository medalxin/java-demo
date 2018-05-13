<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保洁绿化</title>
<script type="text/javascript">
function deleteitem(id){
	var b = window.confirm("您确认要删除这条记录吗？");
	if(b){
		window.location.href="${pageContext.request.contextPath }/servlet/cleaningServlet?method=cleaningToDelete&id="+id;
	}
}
</script>
</head>
<body>
 <c:if test="${user!=null }">
                  欢迎您：${user.username }  ${user.password } ${user.birthday }
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=modifyUI">修改</a>
       <a href="${pageContext.request.contextPath }/servlet/userServlet?method=logout">注销</a>
  		<br/>
       	<hr/>
       <a href="${pageContext.request.contextPath }/servlet/cleaningServlet?method=cleaningToAdd">保洁登记</a>
       <a href="${pageContext.request.contextPath }/servlet/cleaningServlet?method=cleaningToQuery">保洁查询</a>
       <a href="${pageContext.request.contextPath }/index.jsp">返回主页面</a>
   </c:if>

   <c:if test="${user==null }">
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=loginUI">登录</a>
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=registerUI">注册</a>
   </c:if>
   
   <c:if test="${empty(cleaningRecordList) }">
                 没有报修记录！！！
   </c:if>
   
   <c:if test="${!empty(cleaningRecordList) }">
        <table width="70%" border="1">
           <tr>
              <td>保洁区域</td>
              <td>保洁时间区间</td>
              <td>保洁负责人</td>
              <td>保洁负责人电话</td>
              <td>保洁备注</td>
              <td>操作</td>
           </tr>
           
           <c:forEach var="item" items="${cleaningRecordList }">
              <tr>
                  <td>${item.cleaningSite }</td>
                  <td>${item.cleaningTime }</td>
                  <td>${item.cleaning }</td>
                  <td>${item.cleaningTel }</td>
                  <td>${item.cleaningRemarks }</td>
                  <td>
                      <a href="javascript:void(0)" onclick="deleteitem(${item.id})">删除</a>
                  </td>
              </tr>
           </c:forEach>
        </table>
   </c:if>      
</body>
</html>