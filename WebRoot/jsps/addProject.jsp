<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
	
<script type="text/javascript">
	$(function() {
		$("#deadline").datepick({dateFormat:"yy-mm-dd"});
	});
	
	function add() {
		$(".error").text("");
		var bool = true;
		if(!$(":text[name=pname]").val()) {
			$("#pnameError").text("项目名称不能为空！");
			bool = false;
		}
		if(!$(":text[name=principal]").val()) {
			$("#principalError").text("负责人不能为空！");
			bool = false;
		}
		if(!$(":text[name=tprice]").val()) {
			$("#tpriceError").text("项目总价不能为空！");
			bool = false;
		}
		if(!$(":text[name=balance]").val()) {
			$("#balanceError").text("项目余额不能为空");
			bool = false;
		}
		if(!$(":text[name=deadline]").val()) {
			$("#deadlineError").text("截止日期不能为空");
			bool = false;
		}
		
		if(bool) {
			$("form").submit();
		}
	}
	
</script>
<style type="text/css">
	.error {color:red;}
</style>
  </head>
  
  <body>
<h3 align="center">添加项目</h3>
<form action="<c:url value='/ProjectServlet'/>" method="post">
	<!-- 向servlet传递一个名为method的参数，其值表示要调用servlet的哪一个方法-->
	<input type="hidden" name="method" value="add" />
	
<table border="0" align="center" width="40%" style="margin-left: 100px;">
	
	<!-- 新增项目条目 -->
	<tr>
		<td width="100px">项目名称</td>
		<td width="40%">
			<input type="text" name="pname"/>
		</td>
		
		<td align="left">
			<label id="pnameError" class="error">&nbsp;</label>
		</td>
	</tr>
	
	<tr>
		<td width="100px">负责人</td>
		<td width="40%">
			<input type="text" name="principal"/>
		</td>
		
		<td align="left">
			<label id="principalError" class="error">&nbsp;</label>
		</td>
	</tr>

	<tr>
		<td width="100px">项目总价</td>
		<td width="40%">
			<input type="text" name="tprice"/>
		</td>
		<td align="left">
			<label id="tpriceError" class="error">&nbsp;</label>
		</td>
	</tr>
	
	<tr>
		<td width="100px">项目余额</td>
		<td width="40%">
			<input type="text" name="balance"/>
		</td>
		<td align="left">
			<label id="balanceError" class="error">&nbsp;</label>
		</td>
	</tr>
	<tr>
		<td>截止日期</td>
		<td>
			<input type="text" name="deadline" id="deadline" readonly="readonly"/>
		</td>
		<td>
			<label id="deadlineError" class="error">&nbsp;</label>
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>
			<input type="button" value="添加项目" onclick="add()"/>
			<input type="reset" value="重置"/>
		</td>
		<td>&nbsp;</td>
	</tr>
	
</table>
</form>
  </body>
</html>
