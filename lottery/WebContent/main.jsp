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
		<meta http-equiv="keywords" content="梁小满,彩票,竞猜篮球">
		<meta http-equiv="description" content="This is my page">
		<!-- 包含头部信息用于适应不同设备 -->
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- 包含 bootstrap 样式表 -->
	    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
	</head>
	<body>
	
	<div class="container-fluid">
		<p class="table-bordered table-hover table-condensed" style="font-style: italic;"><font face="monospace">专业化彩票分析网站（v1.0）</font></p>
		<div class="row-fluid">
			<div class="span12">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th>
								场次
							</th>
							<th>
								赛事
							</th>
							<th>
								代购截止和开赛时间
							</th>
							<th>
								客队 vs 主队
							</th>
							<th>
								赔率(胜负)
							</th>
							<th>
								赔率(让分胜负)
							</th>
							<th>
								赔率(大小分)
							</th>
							<th>
								网易投注比率
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="match" varStatus="var">
							<c:if test="${var.index % 2 == 0}">
								<tr class="success">
									<td>${myTag:substr(match.matchCode,9,12)}</td>
									<td>${match.leagueName}</td>
									<td>
										<div><span>截止时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.buyEndTime)}</span></div>
										<div><span>开赛时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.matchDate)}</span></div>
									</td>
									<td>
										<div><span>客队：</span><span>${match.guestName}(${match.visitRankInfo})</span></div>
										<div><span>主队：</span><span>${match.hostName}(${match.hostRankInfo})</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.spTabMix,0,0)}</span></div>
										<div><span>${myTag:getHostRate(match.spTabMix,0,1)}</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.spTabMix,1,0)}</span></div>
										<div><span>${myTag:getHostRate(match.spTabMix,1,1)}</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.spTabMix,2,1)}</span></div>
										<div><span>${myTag:getHostRate(match.spTabMix,2,0)}</span></div>
									</td>
									<td>
										<div>${myTag:getHostRate(match.mixBidCounts,1,0)}</span></div>
										<div>${myTag:getHostRate(match.mixBidCounts,1,1)}</span></div>
									</td>
								</tr>
							</c:if>
							<c:if test="${var.index % 2 != 0}">
								<tr class="warning">
									<td>${myTag:substr(match.matchCode,9,12)}</td>
									<td>${match.leagueName}</td>
									<td>
										<div><span>截止时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.buyEndTime)}</span></div>
										<div><span>开赛时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.matchDate)}</span></div>
									</td>
									<td>
										<div><span>客队：</span><span>${match.guestName}(${match.visitRankInfo})</span></div>
										<div><span>主队：</span><span>${match.hostName}(${match.hostRankInfo})</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.spTabMix,0,0)}</span></div>
										<div><span>${myTag:getHostRate(match.spTabMix,0,1)}</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.spTabMix,1,0)}</span></div>
										<div><span>${myTag:getHostRate(match.spTabMix,1,1)}</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.spTabMix,2,1)}</span></div>
										<div><span>${myTag:getHostRate(match.spTabMix,2,0)}</span></div>
									</td>
									<td>
										<div><span>${myTag:getHostRate(match.mixBidCounts,1,0)}</span></div>
										<div><span>${myTag:getHostRate(match.mixBidCounts,1,1)}</span></div>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</body>
</html>