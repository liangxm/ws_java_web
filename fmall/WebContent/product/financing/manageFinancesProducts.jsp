<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>易投融——理财产品</title>
	<%@include file="../jspBase.jsp" %>
	<link rel="stylesheet" href="script/css/common/Pager.css"/>
	<link rel="stylesheet" href="script/css/manageFinancesProducts.css"/>
	
	<script src="script/js/common/jquery.pager.js"></script>
	<script src="script/js/manageFinancesProducts.js"></script>
</head>
<body>	
<div id="wrapper">
	<input type="hidden" id="basePath" value="<%=basePath%>"/>
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
		<div id="productDetail_guide">
			<p class="detailGuide">
				<a>首页</a> &gt; <a>银行理财产品</a>
			</p>
		</div>
		<div class="productOption">
			<div class="productOption_item">
				<p class="product_title">币&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;种：</p>
				<ul class="product_options" id="product_currency">
					<li class="active">不限</li>
					<li>人民币</li>
					<li>港元</li>
					<li>澳大利亚元</li>
					<li>美元</li>
					<li>欧元</li>
					<li>英镑</li>
					<li>新西兰元</li>
					<li>其它</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">收益类型：</p>
				<ul class="product_options" id="product_gainType">
					<li class="active">不限</li>
					<li>保本保收益</li>
					<li>保本浮动收益</li>
					<li>非保本浮动收益</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">销售状态：</p>
				<ul class="product_options" id="product_saleStatus">
					<li class="active">不限</li>
					<li>在售</li>
					<li>预售</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">产品期限：</p>
				<ul class="product_options" id="product_timeLimite">
					<li class="active">不限</li>
					<li>1个月以内</li>
					<li>1（含）-3个月</li>
					<li>3（含）-6个月</li>
					<li>6（含）-12个月</li>
					<li>1（含）年以上</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">起购金额：</p>
				<ul class="product_options" id="product_purchaseAmount">
					<li class="active">不限</li>
					<li>5万以下</li>
					<li>5（含）-10万</li>
					<li>10（含）-20万</li>
					<li>20（含）-50万</li>
					<li>50（含）万以上</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">预期收益：</p>
				<ul class="product_options" id="product_expectedBenefits">
					<li class="active">不限</li>
					<li>0%-5%</li>
					<li>5%（含）-10%</li>
					<li>10%以上</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">风险级别：</p>
				<ul class="product_options" id="product_riskLevel">
					<li class="active">不限</li>
					<li>较低</li>
					<li>低</li>
					<li>中等</li>
					<li>高</li>
					<li>较高</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">产品类型：</p>
				<ul class="product_options" id="product_productType">
					<li class="active">不限</li>
					<li>QDII</li>
					<li>结构性产品</li>
					<li>打新股类</li>
					<li>信托类</li>
					<li>其它</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="productOption_item">
				<p class="product_title">发行银行：</p>
				<ul class="product_options" id="product_issueBank">
					<li class="active">全部银行</li>
					<li>工商银行</li>
					<li>中国银行</li>
					<li>建设银行</li>
					<li>农业银行</li>
					<li>交通银行</li>
					<li>招商银行</li>
					<li>邮政储蓄银行</li>
					<li>平安银行</li>
					<li>光大银行</li>
					<li>民生银行</li>
					<li>浦发银行</li>
					<li>中信银行</li>
					<li>兴业银行</li>
					<li>广发银行</li>
					<li>华夏银行</li>
					<li>花旗银行</li>
					<li>汇丰银行</li>
					<li>东亚银行</li>   
					<li>渣打银行</li>
					<li>北京银行</li>
					<li>上海银行</li>
					<li>宁波银行</li>
					<li>其他银行</li>
				</ul>
				<div class="clearB"></div>
			</div>
			<div class="clearB"></div>
		</div>
		<div class="productNavAD">
			<p class="productNav_titleP">人民币储蓄利率表 单位(%)</p>
			<ul class="productNav_list">
				<li class="productNav_listTitle">
					<span class="productNav_type">&nbsp;</span>
					<span class="productNav_3M">三个月</span>
					<span class="productNav_6M">六个月</span>
					<span class="productNav_1Y">一年</span>
					<span class="productNav_2Y">两年</span>
					<span class="productNav_3Y">三年</span>
					<span class="productNav_5Y">五年</span>
				</li>
				<li>
					<span class="productNav_type">整存整取</span>
					<span class="productNav_3M">2.6</span>
					<span class="productNav_6M">2.7</span>
					<span class="productNav_1Y">3</span>
					<span class="productNav_2Y">3.75</span>
					<span class="productNav_3Y">4.25</span>
					<span class="productNav_5Y">4.75</span>
				</li>
				<li>
					<span class="productNav_type">零存整取</span>
					<span class="productNav_3M">&nbsp;</span>
					<span class="productNav_6M">&nbsp;</span>
					<span class="productNav_1Y">2.85</span>
					<span class="productNav_2Y">&nbsp;</span>
					<span class="productNav_3Y">2.95</span>
					<span class="productNav_5Y">3</span>
				</li>
				<li>
					<span class="productNav_type">整存零取</span>
					<span class="productNav_3M">&nbsp;</span>
					<span class="productNav_6M">&nbsp;</span>
					<span class="productNav_1Y">2.85</span>
					<span class="productNav_2Y">&nbsp;</span>
					<span class="productNav_3Y">2.95</span>
					<span class="productNav_5Y">3</span>
				</li>
				<li>
					<span class="productNav_type">存本取息</span>
					<span class="productNav_3M">&nbsp;</span>
					<span class="productNav_6M">&nbsp;</span>
					<span class="productNav_1Y">2.85</span>
					<span class="productNav_2Y">&nbsp;</span>
					<span class="productNav_3Y">2.95</span>
					<span class="productNav_5Y">3</span>
				</li>
				<li class="productNav_other">
					<span class="productNav_type">其他</span>
					<span class="">活期</span>
					<span class="productNav_1D">一天通知</span>
					<span class="productNav_7D">七天通知</span>
				</li>
				<li class="productNav_other">
					<span class="productNav_type">利率</span>
					<span class="">0.35</span>
					<span class="productNav_1D">0.8</span>
					<span class="productNav_7D">1.35</span>
				</li>
			</ul>
		</div>
		<div class="mainContent_field">
			<div id="main_content">
				<ul class="content_title">
					<li>
						<span class="contentList_name">产品名称</span>
						<span class="contentList_bank">银行</span>
						<span class="contentList_start">起购金额<br> (万元)</span>
						<span class="contentList_date">销售日期<br>(年/月/日)</span>
						<span class="contentList_deadline">期限<br>(天)</span>
						<span class="contentList_rate">预期最高<br>年化收益率</span>
						<div class="clearB"></div>
					</li>
				</ul>
				<div class="clearB"></div>
				<ul class="content_list">
				</ul>
				<div id="pager"></div>
			</div>
		</div>
		<div class="mainContent_ad">
			<p class="mainAD_titleP">理财学院</p>
			<ul class="mainAD_list" id="mainad">
				<li>●&nbsp;&nbsp;<a href="product/financing/financeCollege1.jsp">银行理财产品的定义</a></li>
				<li>●&nbsp;&nbsp;<a href="product/financing/financeCollege2.jsp">银行理财产品购买流程</a></li>
				<li>●&nbsp;&nbsp;<a href="product/financing/financeCollege3.jsp">银行理财产品收益类型</a></li>
				<li>●&nbsp;&nbsp;<a href="product/financing/financeCollege4.jsp">银行理财产品的投资领域</a></li>
				<li>●&nbsp;&nbsp;<a href="product/financing/financeCollege5.jsp">怎么买到高收益理财产品</a></li>
				<li>●&nbsp;&nbsp;<a href="product/financing/financeCollege6.jsp">年末理财最佳时机到 专家直击购买理财产品要点</a></li>
			</ul>
		</div>
		<div class="clearB"></div>
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