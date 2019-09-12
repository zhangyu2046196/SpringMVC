<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2>success</h2><br/>
    <h2>
    	ModelAndView返回类型的返回值(放到了request作用域): ${requestScope.time}<br/>
    	Map返回类型的返回值(map作为参数传进,放到了request作用域):${requestScope.names }<br/>
    	request作用域user:${requestScope.user }<br/>
    	session作用域user:${sessionScope.user }<br/>
    	request作用域school:${requestScope.school }<br/>
    	session作用域school:${sessionScope.school }<br/>
    	request作用域age:${requestScope.age }<br/>
    	session作用域age:${sessionScope.age }<br/>
    	request作用域abc:${requestScope.abc }<br/>
    	<fmt:message key="i18n.userName"></fmt:message><br/>
    	<fmt:message key="i18n.passWord"></fmt:message>
    </h2>
  </body>
</html>
