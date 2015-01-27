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
      <title>今日彩票</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
      <link href="libs/custom/css/basic.css" rel="stylesheet">

      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
   </head>
   <body>
	<div id="ceiling_banner"><span class="banner-text">专业化彩票分析网站（v1.0）</span></div>
	<div class="container-fluid">
		<p class="table-bordered table-hover table-condensed" style="marigin-top:100px;"></p>
		<div class="row-fluid">
			<div class="span12">
				<table class="table table-bordered table-hover table-condensed">
					<caption>今日比赛回顾</caption>
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
										<div><span>开赛时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.startTime)}</span></div>
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
										<div>${myTag:getHostRate(match.mixBidCounts,1,0)}</div>
										<div>${myTag:getHostRate(match.mixBidCounts,1,1)}</div>
									</td>
								</tr>
							</c:if>
							<c:if test="${var.index % 2 != 0}">
								<tr class="warning">
									<td>${myTag:substr(match.matchCode,9,12)}</td>
									<td>${match.leagueName}</td>
									<td>
										<div><span>截止时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.buyEndTime)}</span></div>
										<div><span>开赛时间：</span><span>${myTag:formatDate("yyyy-MM-dd HH:mm",match.startTime)}</span></div>
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
	<div class="privacy_link">
	  <a href="author.html" target="_blank">author</a>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</body>
</html>