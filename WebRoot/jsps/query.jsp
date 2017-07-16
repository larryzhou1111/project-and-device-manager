<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>高级搜索</title>

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
	<h3 align="center">高级搜索</h3>
	<form action="<c:url value='/DeviceServlet'/>" method="post">
		<input type="hidden" name="method" value="query" />
		<table border="0" align="center" width="40%"
			style="margin-left: 100px;">
			<tr>
				<td width="100px">设备名称</td>
				<td width="40%"><input type="text" name="dname" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="搜索" /> <input type="reset"
					value="重置" /></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
