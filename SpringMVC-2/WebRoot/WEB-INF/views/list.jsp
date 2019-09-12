<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工列表页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 
		springMVC通过<mvc:default-servlet-handler/>来处理静态资源
		因为静态资源没有映射,将静态资源交给web容器的默认servlet来处理
	 -->
	<script type="text/javascript" src="scripts/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".delete").click(function(){
				var href=$(this).attr("href");
				$("form").attr("action",href).submit();
				return false;
			});
		})
	</script>
  </head>
  
  <body>
  
  		<form action="" method="post">
  			<input type="hidden" name="_method" value="DELETE"/>
  		</form>
  
    	<c:if test="${empty requestScope.emp_list }">
    		没有任何员工信息
    	</c:if>
    	<c:if test="${!empty requestScope.emp_list }">
    		<table border="1" cellpadding="10" cellspacing="0">
    			<tr>
    				<td>GUID</td>
    				<td>用户名</td>
    				<td>密码</td>
    				<td>邮箱</td>
    				<td>性别</td>
    				<td>部门</td>
    				<td>操作</td>
    				<td>操作</td>
    			</tr>
    			<c:forEach items="${requestScope.emp_list }" var="emp">
    				<tr>
    					<td>${emp.guid }</td>
    					<td>${emp.userName }</td>
    					<td>${emp.passWord }</td>
    					<td>${emp.email }</td>
    					<td>${emp.gender==1?"男":"女" }</td>
    					<td>${emp.dept.deptName }</td>
    					<td><a href="springMVC/emps/${emp.guid }">修改<a/></td>
    					<td><a class="delete" href="springMVC/emps/${emp.guid }">删除</a></td>
    				</tr>
    			</c:forEach>
    		</table>
    	</c:if>
  	<br/>
  	<a href="springMVC/emps">添加员工</a>
  </body>
</html>
