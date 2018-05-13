<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function deleteitem(costid){
	var b = window.confirm("确认要删除这条记录吗？");
	if(b){
		window.location.href="${pageContext.request.contextPath }/servlet/costServlet?method=costToDelete&costid="+costid;
	}
	
}
</script>
</head>
<body>
   <c:if test="${user!=null }">
         欢迎您：${user.username } ${user.password } ${user.birthday }
    <a href="${pageContext.request.contextPath }/servlet/modifyUserInfUIServlet">修改</a>
    <a href="${pageContext.request.contextPath }/servlet/logoutServlet">注销</a>
   <br/>
   <a href="${pageContext.request.contextPath }/servlet/costServlet?method=costToAdd">费用登记</a>
   <a href="${pageContext.request.contextPath }/servlet/costServlet?method=costToQuery">费用查询</a>
   <a href="${pageContext.request.contextPath }/index.jsp">返回主页面</a>
   </c:if>
   <c:if test="${user==null }">

   <a href="servlet/loginUIServlet">登录</a>
   <a href="servlet/registerUIServlet">注册</a>
   </c:if>
   
   <div>
       费用内容：<input type="text" name="content">          <input type="button" value="查询" onclick="">
   </div>
    <c:if test="${empty(costRecordList) }">
                              没有费用记录！！！
    </c:if>
   <c:if test="${!empty(costRecordList) }">
       <table width="70%" border="1">
       <tr>
           
           <td>业主编号</td>
           <td>物业费</td>
           <td>缴费时间</td>
           <td>实交费</td>
           <td>费用备注</td>
           <td>操作</td>
        </tr>
        
       <c:forEach var="item" items="${costRecordList }">
         <tr>
              <td>${item.customerid }</td>
              <td>${item.cost }</td>
              <td>${item.costdate }</td>
              <td>${item.money }</td>
              <td>${item.costmemo }</td>
              <td>
                    <a href="javascript:void(0)" onclick="deleteitem(${item.costid})">删除</a>
              </td>
      </tr>  
        </c:forEach>
       
       </table>
   
   </c:if>
</body>
</html>