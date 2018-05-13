<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function deleteitem(id){
	var b = window.confirm("您确认要删除这条记录吗？");
	if(b){
		window.location.href="${pageContext.request.contextPath }/servlet/complaintServlet?method=complaintToDelete&id="+id;
	}
}
</script>
</head>
<body >
   <c:if test="${user!=null }">
                  欢迎您：${user.username }  ${user.birthday }
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=modifyUI">修改</a>
       <a href="${pageContext.request.contextPath }/servlet/userServlet?method=logout">注销</a>
       <br/>
       
       <a href="${pageContext.request.contextPath }/servlet/complaintServlet?method=complaintToAdd">投诉登记</a>
       <a href="${pageContext.request.contextPath }/servlet/complaintServlet?method=complaintToQuery">投诉查询</a>
       <a href="${pageContext.request.contextPath }/index.jsp">返回主页面</a>
   </c:if>

   <c:if test="${user==null }">
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=loginUI">登录</a>
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=registerUI">注册</a>
   </c:if>
   
   <div>
                 投诉内容：<input type="text" name="content"><input type="button" value="查询" onclick="queryByCondition()">
   </div>
   
   <c:if test="${empty(complaintRecordList) }">
                 没有投诉记录！！！
   </c:if>
   
   <c:if test="${!empty(complaintRecordList) }">
        <table width="70%" border="1">
           <tr>
              <td>业主编号</td>
              <td>投诉内容</td>
              <td>投诉时间</td>
              <td>操作</td>
           </tr>
           
           <c:forEach var="item" items="${complaintRecordList }">
              <tr>
                  <td>${item.complaintPerson }</td>
                  <td>${item.content }</td>
                  <td>${item.complaintTime }</td>
                  <td>
                      <a href="javascript:void(0)" onclick="deleteitem(${item.id})">删除</a>
                  </td>
              </tr>
           </c:forEach>
        </table>
   </c:if>
</body>
</html>