<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工添加页面</title>
    
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
    <form:form action="${pageContext.request.contextPath }/springMVC/emps" method="post" modelAttribute="employee">
    	<!-- springMVC的form标签中的path属性等于html标签中的name属性 -->
    	guid:<form:input path="guid" /><br/>
    	<c:if test="${employee.guid==null }">
    		用户名:<form:input path="userName"/><br/>
    	</c:if>
    	<c:if test="${employee.guid!=null }">
    		<input type="hidden" name="_method" value="PUT"/>
    	</c:if>
    	密码:<form:password path="passWord"/><br/>
    	邮箱:<form:input path="email"/><br/>
    	<%
    		Map<Integer,String> genders = new HashMap<Integer,String>();
    		genders.put(1,"男");
    		genders.put(0,"女");
    		request.setAttribute("genders", genders);
    	 %>
    	性别:<form:radiobuttons path="gender" items="${genders }"/><br/>
    	部门:<form:select path="dept.guid" items="${departments }" itemLabel="deptName" itemValue="guid"></form:select><br/>
    	<input type="submit" value="提交"/>
    </form:form>
    <br/>
    <!-- 测试自定义类型转化器(字符串转换成Employee对象),自定义类型转化器需要实现Converter接口 -->
    <form action="springMVC/testConveter" method="post">
    	<!-- 格式:9-YY-123456-yy@youyuan.com-1-2 -->
    	Employee:<input type="text" name="employee"/><br/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
