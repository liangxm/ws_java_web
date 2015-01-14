<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>竞猜篮球大厅</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
			div{
				float: left;
				padding: 3px;
				width: 50px;
				height: 10px;
				text-align: center;
				border: 1px solid red;
			}
		</style>
	</head>
	<body>
	
	<!-- 这是使用c:choose来实现if else-->
	<table width="200" border="1">
		<tr bgcolor="#FF0000">
			<th width="5">
				场次
			</th>
			<th width="10">
				赛事
			</th>
			<th width="10">
				代购截止
			</th>
			<th width="10">
				客队 vs 主队
			</th>
			<th width="10">
				赔率
			</th>
			<th width="10">
				网易投注比率
			</th>
		</tr>
		<c:forEach items="${list}" var="match" varStatus="var">
			<c:if test="${var.index % 2 == 0}">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:if>
			<c:if test="${var.index % 2 != 0}">
				<tr bgcolor="#999999">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	</body>
</html>