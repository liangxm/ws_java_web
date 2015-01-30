<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>易投融——银行导航</title>
	<%@include file="../jspBase.jsp" %>
</head>
<body>	
<div id="wrapper">
	<div id="header">
		<p class="header_name">
			<a href="product/financing/manageFinancesProducts.jsp"></a>
		</p>
		<ul class="header_navUl">
			<li><a href="product/financing/aboutJRC.jsp">关于易投融</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="product/financing/businessCoperation.jsp">商务合作</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="product/financing/riskTips.jsp">风险提示</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="product/financing/bankNav.jsp">银行导航</a></li>
		</ul>
		<div class="clearB"></div>
	</div>
	<div id="main_wrapper">
	<div id="main">
		<div id="main_content">
			<div class="articleContent" style="line-height:40px;">
				<span>全国银行：</span>
				<ul class="banklist">
					<li class="bank_detail"><img src="<%=basePath%>images/icon/gs.png" alt="工商银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/zg.png" alt="中国银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/js.png" alt="建设银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/ny.png" alt="农业银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/jt.png" alt="交通银行"></li>
					<li class="bank_detail clearB"><img src="<%=basePath%>images/icon/zs.png" alt="招商银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/yzcx.png" alt="邮政储蓄银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/pa.jpg" alt="平安银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/gd.png" alt="光大银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/ms.png" alt="民生银行"></li>
					<li class="bank_detail clearB"><img src="<%=basePath%>images/icon/pf.png" alt="浦发银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/zx.png" alt="中信银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/xy.png" alt="兴业银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/gf.png" alt="广发银行"></li>
					<li class="bank_detail"><img src="<%=basePath%>images/icon/hx.png" alt="华夏银行"></li>
				</ul>
				<div class="clearB"></div>
				<!-- <span>全国银行：</span><p>工商银行  中国银行  建设银行  农业银行  交通银行  招商银行  邮政储蓄银行 平安银行  光大银行  民生银行  浦发银行	中信银行  兴业银行  广发银行  华夏银行</p> -->
				<span>外资银行：</span><p>花旗银行  汇丰银行  东亚银行  德意志银行  渣打银行  恒生银行  恒丰银行 法兴银行</p>
				<span>地方银行：</span><p>北京银行  上海银行  天津银行  重庆银行  浙商银行  徽商银行  包商银行 晋商银行  河北银行  湖北银行 宁夏银行  吉林银行 内蒙古银行  齐鲁银行  富滇银行  北京农商银行  上海农商银行  天津农商银行   重庆农商银行  广州农商银行  成都农商银行 
				宁波银行  杭州银行  大连银行  广州银行  青岛银行  哈尔滨银行  南京银行  厦门银行 苏州银行 兰州银行 长沙银行 成都银行 深圳银行 西安银行  乌鲁木齐银行  南昌银行  台州银行  东莞银行  张家港银行  渤海银行  长安银行 温州银行 鄂尔多斯银行</p>
				<br><br><br>
			</div>
		</div>
	</div>
	<div class="footer">
		<p class="footer_aboutus">
			温馨提示：易投融所公布的产品信息仅供参考，使用前请核实，做理性投资决策。<br>
			易投融信息技术有限公司 版权所有
		</p>
	</div>
</div>
</div>
</body>
</html>