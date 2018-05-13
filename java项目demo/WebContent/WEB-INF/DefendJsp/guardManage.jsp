<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function deleteitem(guardid){
	var b = window.confirm("您确认要删除这条记录吗？");
	if(b){
		window.location.href="${pageContext.request.contextPath }/servlet/guardServlet?method=guardToDelete&guardid="+guardid;
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
       
       <a href="${pageContext.request.contextPath }/servlet/guardServlet?method=guardToAdd">门卫登记</a>
       <a href="${pageContext.request.contextPath }/servlet/guardServlet?method=guardToQuery">门卫查询</a>
       <a href="${pageContext.request.contextPath }/index.jsp">返回主页面</a>
   </c:if>

   <c:if test="${user==null }">
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=loginUI">登录</a>
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=registerUI">注册</a>
   </c:if>
   
   <div>
                 事由内容：<input type="text" name="guardcon"><input type="button" value="查询" onclick="queryByCondition()">
   </div>
   
   <c:if test="${empty(guardRecordList) }">
                 没有门卫记录！！！
   </c:if>
   
   <c:if test="${!empty(guardRecordList) }">
        <table width="70%" border="1">
           <tr>
              <td>员工编号</td>
              <td>事由内容</td>
              <td>负责人</td>
               <td>记录时间</td>
              <td>操作</td>
           </tr>
           
           <c:forEach var="item" items="${guardRecordList }">
              <tr>
                  <td>${item.workerid}</td>
                  <td>${item.guardcon }</td>
                  <td>${item.personname}</td>
                  <td>${item.guarddate}</td>
                  <td>
                      <a href="javascript:void(0)" onclick="deleteitem(${item.guardid})">删除</a>
                  </td>
              </tr>
           </c:forEach>
        </table>
   </c:if>
</body>
</html>