<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %>
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
	</head>
	<body>
	
	<!-- 这是使用c:choose来实现if else-->
	<table width="95%" border="1">
		<tr bgcolor="#FF0000">
			<th width="5%">
				场次
			</th>
			<th width="15%">
				赛事
			</th>
			<th width="20%">
				代购截止和开赛时间
			</th>
			<th width="20%">
				客队 vs 主队
			</th>
			<th width="20%">
				赔率
			</th>
			<th width="20%">
				网易投注比率
			</th>
		</tr>
		<c:forEach items="${list}" var="match" varStatus="var">
			<c:if test="${var.index % 2 == 0}">
				<tr>
					<td>${myTag:substr(match.matchCode,9,12)}</td>
					<td>${match.leagueName}</td>
					<td>
						<div><span>截止时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.buyEndTime)}</span></div>
						<div><span>开赛时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.matchDate)}</span></div>
					</td>
					<td>
						<div><span>主队：</span><span>${match.hostName}</span></div>
						<div><span>客队：</span><span>${match.guestName}</span></div>
					</td>
					<td>
						<div><span>主胜：</span><span>${match.spTabMix}</span></div>
						<div><span>主负：</span><span>${match.guestName}</span></div>
					</td>
					<td>${match.mixBidCounts}</td>
				</tr>
			</c:if>
			<c:if test="${var.index % 2 != 0}">
				<tr bgcolor="#999999">
					<td>${myTag:substr(match.matchCode,9,12)}</td>
					<td>${match.leagueName}</td>
					<td>
						<div><span>截止时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.buyEndTime)}</span></div>
						<div><span>开赛时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.matchDate)}</span></div>
					</td>
					<td>
						<div><span>主队：</span><span>${match.hostName}</span></div>
						<div><span>客队：</span><span>${match.guestName}</span></div>
					</td>
					<td>
						<div><span>主胜：</span><span>${match.spTabMix}</span></div>
						<div><span>主负：</span><span>${match.guestName}</span></div>
					</td>
					<td>${match.mixBidCounts}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	</body>
</html>