<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'function.jsp' starting page</title>

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

	<table align="center">
		<tr>
			<h1>高能所项目/设备管理系统</h1>
		</tr>
		<tr>
			<td><a href="<c:url value='/jsps/frameProject.jsp'/>">项目管理</a></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><a href="<c:url value='/jsps/frameDevice.jsp'/>">设备管理</a></td>
		</tr>
		<tr>&nbsp;&nbsp;&nbsp;
		</tr>
		<tr>&nbsp;&nbsp;&nbsp;
		</tr>

	</table>

	<h2 align="center">
		欢迎登录本系统,
		<c:choose>
			<c:when test="${sessionUser.status eq 1 }">您是教师管理员:${sessionUser.loginname }</c:when>
			<c:when test="${sessionUser.status eq 0 }">您是学生管理员:${sessionUser.loginname }</c:when>
		</c:choose>
	</h2>

</body>
</html>
