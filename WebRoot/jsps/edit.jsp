<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑设备</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/jquery/jquery.datepick.css'/>">
<script type="text/javascript"
	src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>

<script type="text/javascript">
	$(function() {
		$("#birthday").datepick({
			dateFormat : "yy-mm-dd"
		});
	});

	function add() {
		$(".error").text("");
		var bool = true;
		if (!$(":text[name=dname]").val()) {
			$("#dnameError").text("设备名称不能为空");
			bool = false;
		}

		if (bool) {
			$("form").submit();
		}
	}
</script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>

<body>
	<h3 align="center">编辑设备</h3>
	<form action="<c:url value='/DeviceServlet'/>" method="post">
		<input type="hidden" name="method" value="edit"> <input
			type="hidden" name="did" value="${device.did }" />
		<table border="0" align="center" width="40%"
			style="margin-left: 100px;">
			<tr>
				<td width="100px">设备名称</td>
				<td width="40%"><input type="text" name="dname"
					value="${device.dname }" /></td>
				<td align="left"><label id="dnameError" class="error">&nbsp;</label>
				</td>
			</tr>

			<tr>
				<td>设备入库时间</td>
				<td><input type="text" name="birthday" id="birthday"
					readonly="readonly" value="${device.birthday }" /></td>
				<td><label id="birthdayError" class="error">&nbsp;</label></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input type="button" value="编辑设备" onclick="add()" /> <input
					type="reset" value="重置" /></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
