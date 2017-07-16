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
	<h3 align="center">设备列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>设备编号</th>
			<th>设备名称</th>
			<th>设备入库时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.deviceList}" var="device">
			<tr>
				<td>${device.did}</td>
				<td>${device.dname}</td>
				<td>${device.birthday}</td>
				<td><c:if test="${sessionUser.status eq 1 }">
						<a
							href="<c:url value='/DeviceServlet?method=preEdit&did=${device.did }'/>">编辑</a>
						<a
							href="<c:url value='/DeviceServlet?method=delete&did=${device.did }'/>">删除</a>
					</c:if> <c:if test="${sessionUser.status eq 0 }">
				请联系老师操作设备
			</c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
