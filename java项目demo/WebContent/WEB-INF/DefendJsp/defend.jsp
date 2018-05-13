<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:if test="${user!=null }">
                  欢迎您：${user.username }  ${user.password } ${user.birthday }
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=modifyUI">修改</a>
       <a href="${pageContext.request.contextPath }/servlet/userServlet?method=logout">注销</a>
       <br/><hr/>
	   <a href="${pageContext.request.contextPath }/servlet/patrolServlet?method=patrolUI">保安巡查</a>
	   <a href="${pageContext.request.contextPath }/servlet/guardServlet?method=guardUI">门卫管理</a>
	   <a href="${pageContext.request.contextPath }/servlet/cleaningServlet?method=cleaningUI">保洁绿化</a>
   </c:if>
   <c:if test="${user==null }">
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=loginUI">登录</a>
       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=registerUI">注册</a>
   </c:if>
</body>
</html>