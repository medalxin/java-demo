<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智能小区物业管理系统</title>
<style>
	* { margin:0; padding:0;}
	.box { width:350px; height:250px; margin:250px auto; border:1px solid #000; box-shadow:0 2px 10px #000; text-align:center;}
	.box h2 { color:red; margin:50px auto; font-size:25px;}
	.box a { text-decoration:none; font-size:20px;}
</style>
</head>
<body>
     <c:if test="${user.status==1 }">
     	<h3>管理员界面</h3>
     	<hr/>
	   <c:if test="${user!=null }">
	   		<br/>
	                  欢迎您：${user.username } <span id="status"></span>  ${user.birthday }
	       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=modifyUI">修改</a>
	       <a href="${pageContext.request.contextPath }/servlet/userServlet?method=logout">注销</a>
	       <br/><br/><hr/>
	   </c:if>
       <a href="${pageContext.request.contextPath }/servlet/notifyServlet?method=notifyUI">公告管理</a>
       <a href="${pageContext.request.contextPath }/servlet/parkingpotServlet?method=parkingpotUI">车位管理</a>
       <a href="${pageContext.request.contextPath }/servlet/houseUIServlet?method=houseUI">房产管理</a>
       <a href="${pageContext.request.contextPath}/servlet/workerServlet?method=workerUI">人事管理</a>
       <a href="${pageContext.request.contextPath }/servlet/repairServlet?method=repairUI">报修管理</a>
       <a href="${pageContext.request.contextPath }/servlet/defendUIServlet?method=defendUI">保卫绿化</a>
       <a href="${pageContext.request.contextPath }/servlet/costServlet?method=costUI">费用管理</a>
	</c:if>
      <c:if test="${user.status==2 }">
     	<h3>业主界面</h3>
     	<hr/>
	   <c:if test="${user!=null }">
	   		<br/>
	                  欢迎您：${user.username } <span id="status"></span>  ${user.birthday }
	       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=modifyUI">修改</a>
	       <a href="${pageContext.request.contextPath }/servlet/userServlet?method=logout">注销</a>
	       <br/><br/><hr/>
	   </c:if>
       <a href="${pageContext.request.contextPath }/servlet/complaintServlet?method=complaintUI">投诉录入</a>
       <a href="${pageContext.request.contextPath }/servlet/notifyServlet?method=notifyToQuery">查看公告</a>
	</c:if>
	
   <c:if test="${user==null }">
		<div class="box">
			<h2>智能小区物业管理系统</h2>
	       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=loginUI">登录</a>
	       &nbsp; &nbsp;
	       <a href="${pageContext.request.contextPath }/servlet/userUIServlet?method=registerUI">注册</a>
	    </div>
   </c:if>
</body>
</html>