<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <h2>
    	<a href="helloWorld">helloworld</a>
    </h2>
    <br/>
    <h2>
    	<a href="springMVC/testRequestMapping">testRequestMapping</a>
    </h2>
    <br/>
   	<h2>
   		<a href="springMVC/testMethod">testMethod</a>
   	</h2>
   	<br/>
   	<form action="springMVC/testMethod" method="post">
		<button type="submit">testMethod_Post</button>
	</form>
	<br/>
	<h2>
		<a href="springMVC/testParamsAndHeads?username=zhangfuhao&age=92">testParamsAndHeads</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testAntPath/mnzxykd/abc">testAntPath</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testPathVariable/92">testPathVariable</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testPathVariable/92/plus">testPathVariablePlus</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testRestGet/1">testRestGet</a>
	</h2>
	<br/>
	<form action="springMVC/testRestPost" method="post">
		<input type="hidden" name="_method" value="POST"/>
		<button type="submit">testRestPost</button>
	</form>
	<br/>
	<form action="springMVC/testRestPut/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<button type="submit">testRestPut</button>
	</form>
	<br/>
	<form action="springMVC/testRestDelete/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<button type="submit">testRestDelete</button>
	</form>
	<br/>
	<h2>
		<a href="springMVC/testRequestParam?userName=wangwu&age=92">testRequestParam</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testRequestHeader">testRequestHeader</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testCookieValue">testCookieValue</a>
	</h2>
	<br/>
	<form action="springMVC/testPojo" method="post">
		userName:<input type="text" name="userName"/><br/>
		passWord:<input type="password" name="passWord"/><br/>
		email:<input type="text" name="email"/><br/>
		age:<input type="text" name="age"/><br/>
		city:<input type="text" name="address.city"/><br/>
		province:<input type="text" name="address.province"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<br/>
	<h2>
		<a href="springMVC/testServletApi">testServletApi</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testModelAndView">testModelAndView</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testMap">testMap</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testSessionAttribute">testSessionAttribute</a>
	</h2>
	<br/>
	<form action="springMVC/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1"/><br/>
		userName:<input type="text" name="userName" value="Tom"/><br/>
		email:<input type="text" name="email" value="tom@youyuan.com"/><br/>
		age:<input type="text" name="age" value="92"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<br/>
	<h2>
		<a href="springMVC/testViewAndViewResolover">testViewAndViewResolover</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testHelloView">testHelloView</a>
	</h2>
	<br/>
	<h2>
		<a href="springMVC/testRedirect">testRedirect</a>
	</h2>
  </body>
</html>
