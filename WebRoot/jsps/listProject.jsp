<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户列表</title>

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
	<h3 align="center">项目列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>项目编号</th>
			<th>项目名称</th>
			<th>负责人</th>
			<th>项目总价</th>
			<th>项目余额</th>
			<th>截止日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.projectList}" var="project">
			<tr>
				<td>${project.pid}</td>
				<td>${project.pname}</td>
				<td>${project.principal}</td>
				<td>${project.tprice}</td>
				<td>${project.balance}</td>
				<td>${project.deadline}</td>
				<td><c:if test="${sessionUser.status eq 1 }">
						<a
							href="<c:url value='/ProjectServlet?method=preEdit&pid=${project.pid }'/>">编辑</a>
						<a
							href="<c:url value='/ProjectServlet?method=delete&pid=${project.pid }'/>">删除</a>
					</c:if> <c:if test="${sessionUser.status eq 0 }">
				请联系老师操作项目
			</c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
