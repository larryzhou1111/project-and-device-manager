<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base target="main">
<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="text-align: center;">

	<h1>高能所设备管理系统</h1>
	<c:if test="${sessionUser.status eq 1 }">
		<a href="<c:url value='/jsps/add.jsp'/>">添加设备</a> 　|　
	</c:if>
	<a href="<c:url value='/DeviceServlet?method=findAll'/>">查询设备</a> |
	<a href="<c:url value='/jsps/query.jsp'/>">高级搜索</a>

	<c:choose>
		<c:when test="${sessionUser.status eq 1 }">教师管理员：${sessionUser.loginname }</c:when>
		<c:when test="${sessionUser.status eq 0 }">学生管理员：${sessionUser.loginname }</c:when>
	</c:choose>
	&nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/DeviceServlet?method=quit'/>">退出</a>

</body>
</html>
