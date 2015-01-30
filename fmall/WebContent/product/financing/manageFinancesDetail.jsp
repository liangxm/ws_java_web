<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>易投融——理财产品详情</title>
	<%@include file="../jspBase.jsp" %>
	<link rel="stylesheet" href="script/css/manageFinancesDetail.css"/>
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
		<div id="productDetail_guide">
			<p class="detailGuide">
				<a>首页</a> &gt; <a href="product/financing/manageFinancesProducts.jsp">银行理财产品</a> &gt; “金钥匙·汇利丰”恒利得39期理财产品
			</p>
		</div>
		<div class="mainContent_field">
			<div class="finances_title">
				<span>“金钥匙·汇利丰”恒利得39期理财产品</span>
				<a class="btn store" id="btn_storeFinances">去官网购买</a>
			</div>
			<ul id="productDetail_nav">
				<li class="active">基本信息</li>
				<li>收益说明</li>
				<li>购买信息</li>
				<li>附加条款</li>
			</ul>
			<div id="productDetail_table">
			<ul class="mainTable">
				<li class="mainTable_titleLi">产品信息</li>
				<li>
					<span class="mainTable_title">产品名称</span><span class="mainTable_info">
							<c:if test="${empty financial.productName}">-</c:if>
							<c:if test="${!empty financial.productName}"><c:out value="${financial.productName}" /></c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">产品代码</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.productCode}">-</c:if>
							<c:if test="${!empty financial.productCode}"><c:out value="${financial.productCode}" /></c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">币种</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.currency}">-</c:if>
							<c:if test="${!empty financial.currency}"><c:out value="${financial.currency}" /></c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">银行名称</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.bank}">-</c:if>
							<c:if test="${!empty financial.bank}"><c:out value="${financial.bank}" /></c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">产品类型</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.productType}">-</c:if>
							<c:if test="${!empty financial.productType}"><c:out value="${financial.productType}" /></c:if>					
					</span>
				</li>
				<li>
					<span class="mainTable_title">委托管理期限</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.entrustManagePeriod}">-</c:if>
							<c:if test="${!empty financial.entrustManagePeriod}"><c:out value="${financial.entrustManagePeriod}" /></c:if>天					
					</span>
				</li>
				
				<li class="mainTable_titleLi">收益信息</li>
				<li>
					<span class="mainTable_title">是否保本</span>
					<span class="mainTable_info">
							<c:if test="${financial.keepPrincipal == false}">
								<c:out value="不保本" />
							</c:if> 
							<c:if test="${financial.keepPrincipal == true}">
								<c:out value="保本" />
							</c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">预期最高年收益率</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomeRate}">-</c:if>
							<c:if test="${!empty financial.incomeRate}"><c:out value="${financial.incomeRate}" /></c:if>%						
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">收益类型</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomeType}">-</c:if>
							<c:if test="${!empty financial.incomeType}"><c:out value="${financial.incomeType}" /></c:if>						
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">销售起始日期</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.salesStartDate}">-</c:if>
							<c:if test="${!empty financial.salesStartDate}">
								<fmt:parseDate var="salesStartDate" value="${financial.salesStartDate}" type="DATE" pattern="yyyyMMdd"/>
								<fmt:formatDate value="${salesStartDate}" pattern='yyyy/MM/dd' /> 
							</c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">销售结束日期</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.salesEndDate}">-</c:if>
							<c:if test="${!empty financial.salesEndDate}">
								<fmt:parseDate var="salesEndDate" value="${financial.salesEndDate}" type="DATE" pattern="yyyyMMdd"/>
								<fmt:formatDate value="${salesEndDate}" pattern='yyyy/MM/dd' /> 
							</c:if>			
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">收益起始日期</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomeStartDate}">-</c:if>
							<c:if test="${!empty financial.incomeStartDate}">
								<fmt:parseDate var="incomeStartDate" value="${financial.incomeStartDate}" type="DATE" pattern="yyyyMMdd"/>
								<fmt:formatDate value="${incomeStartDate}" pattern='yyyy/MM/dd' /> 
							</c:if>	
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">收益结束日期</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomeEndDate}">-</c:if>
							<c:if test="${!empty financial.incomeEndDate}">
								<fmt:parseDate var="incomeEndDate" value="${financial.incomeEndDate}" type="DATE" pattern="yyyyMMdd"/>
								<fmt:formatDate value="${incomeEndDate}" pattern='yyyy/MM/dd' /> 
							</c:if>	
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">投资金额</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.investmentsAmt}">-</c:if>
							<c:if test="${!empty financial.investmentsAmt}"><c:out value="${financial.investmentsAmt}" /></c:if>万元				
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">销售地区</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.salesRegion}">-</c:if>
							<c:if test="${!empty financial.salesRegion}"><c:out value="${financial.salesRegion}" /></c:if>					
					</span>
				</li>
			</ul>
			
			<ul class="mainTable" style="display:none;">
				<li class="mainTable_titleLi">收益说明</li>
				<li>
					<span class="mainTable_title">投资标的</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.investmentTargets}">-</c:if>
							<c:if test="${!empty financial.investmentTargets}"><c:out value="${financial.investmentTargets}" /></c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">预期最高年收益率</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomeRate}">-</c:if>
							<c:if test="${!empty financial.incomeRate}"><c:out value="${financial.incomeRate}" /></c:if>%					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">实际年化收益率</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.actualAnnualYield}">-</c:if>
							<c:if test="${!empty financial.actualAnnualYield}"><c:out value="${financial.actualAnnualYield}" /></c:if>%
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">收益计算方法</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomeCalculate}">-</c:if>
							<c:if test="${!empty financial.incomeCalculate}"><c:out value="${financial.incomeCalculate}" /></c:if>						
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">投资方向说明</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.investmentDirectionDesc}">-</c:if>
							<c:if test="${!empty financial.investmentDirectionDesc}"><c:out value="${financial.investmentDirectionDesc}" /></c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">风险提示</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.riskWarning}">-</c:if>
							<c:if test="${!empty financial.riskWarning}"><c:out value="${financial.riskWarning}" /></c:if>							
					</span>
				</li>
			</ul>
			
			<ul class="mainTable" style="display:none;">
				<li class="mainTable_titleLi">购买信息</li>
				<li>
					<span class="mainTable_title">理财份额面值</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.financialNominalVal}">-</c:if>
							<c:if test="${!empty financial.financialNominalVal}"><c:out value="${financial.financialNominalVal}" /></c:if>						
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">委托起始金额</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.entrustStartAmt}">-</c:if>
							<c:if test="${!empty financial.entrustStartAmt}"><c:out value="${financial.entrustStartAmt}" /></c:if>万元
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">委托金额递增单位</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.entrustAmtIncreUnit}">-</c:if>
							<c:if test="${!empty financial.entrustAmtIncreUnit}"><c:out value="${financial.entrustAmtIncreUnit}" /></c:if>万元			
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">购买方式</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.buyWay}">-</c:if>
							<c:if test="${!empty financial.buyWay}"><c:out value="${financial.buyWay}" /></c:if>	
					</span>
				</li>
			</ul>
			
			<ul class="mainTable" style="display:none;">
				<li class="mainTable_titleLi">附加条款</li>
				<li>
					<span class="mainTable_title">浮动管理费说明</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.floatManageFeeDesc}">-</c:if>
							<c:if test="${!empty financial.floatManageFeeDesc}"><c:out value="${financial.floatManageFeeDesc}" /></c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">账单查询方式</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.billQuery}">-</c:if>
							<c:if test="${!empty financial.billQuery}"><c:out value="${financial.billQuery}" /></c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">收益支付期限</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.incomePayPeriod}">-</c:if>
							<c:if test="${!empty financial.incomePayPeriod}"><c:out value="${financial.incomePayPeriod}" /></c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">是否自动终止</span>
					<span class="mainTable_info">
							<c:if test="${financial.autoTerminateFlag == false}">
								<c:out value="否" />
							</c:if> 
							<c:if test="${financial.autoTerminateFlag == true}">
								<c:out value="是" />
							</c:if>
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">自动终止条件</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.autoTerminateCondition}">-</c:if>
							<c:if test="${!empty financial.autoTerminateCondition}"><c:out value="${financial.autoTerminateCondition}" /></c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">银行是否有权提前终止</span>
					<span class="mainTable_info">
							<c:if test="${financial.bankTerminateFlag == false}">
								<c:out value="否" />
							</c:if> 
							<c:if test="${financial.bankTerminateFlag == true}">
								<c:out value="有" />
							</c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">银行提前终止条件</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.bankTerminateDesc}">-</c:if>
							<c:if test="${!empty financial.bankTerminateDesc}"><c:out value="${financial.bankTerminateDesc}" /></c:if>					
					</span>
				</li>
				
				<li>
					<span class="mainTable_title">客户是否有权赎回</span>
					<span class="mainTable_info">
							<c:if test="${financial.clientRedemptionFlag == false}">
								<c:out value="否" />
							</c:if> 
							<c:if test="${financial.clientRedemptionFlag == true}">
								<c:out value="有" />
							</c:if>					
					</span>
				</li>
				<li>
					<span class="mainTable_title">客户赎回条件</span>
					<span class="mainTable_info">
							<c:if test="${empty financial.clientRedemptionCondition}">-</c:if>
							<c:if test="${!empty financial.clientRedemptionCondition}"><c:out value="${financial.clientRedemptionCondition}" /></c:if>					
					</span>
				</li>
			</ul>
			</div>
		</div>
		<div class="mainContent_ad">
			<p class="productNav_titleP">新发高收益理财产品一览</p>
			<ul class="productNav_list"> 
				<li class="productNav_listTitle" style="height:40px;line-height:20px;">
					<span class="productNav_type" style="line-height:40px;">机构名称</span>
					<span class="productNav_type" style="line-height:40px;width:79px;">产品名称</span>
					<span class="productNav_type" style="line-height:40px;">收益类型</span>
					<span class="productNav_type">预期年华<br>收益率</span>
				</li>
				<li class="">
					<span class="productNav_type">招商银行</span>
					<span class="productNav_type" style="width:79px;" title="1年什么什么什么">1年什么什么什么</span>
					<span class="productNav_type">浮动</span>
					<span class="productNav_type">6.30%</span>
				</li>
				<li class="">
					<span class="productNav_type">招商银行</span>
					<span class="productNav_type" style="width:79px;" title="1年什么什么什么">1年什么什么什么</span>
					<span class="productNav_type">浮动</span>
					<span class="productNav_type">6.30%</span>
				</li>
				<li class="">
					<span class="productNav_type">招商银行</span>
					<span class="productNav_type" style="width:79px;" title="1年什么什么什么">1年什么什么什么</span>
					<span class="productNav_type">浮动</span>
					<span class="productNav_type">6.30%</span>
				</li>
				<li class="">
					<span class="productNav_type">招商银行</span>
					<span class="productNav_type" style="width:79px;" title="1年什么什么什么">1年什么什么什么</span>
					<span class="productNav_type">浮动</span>
					<span class="productNav_type">6.30%</span>
				</li>
				<li class="">
					<span class="productNav_type">招商银行</span>
					<span class="productNav_type" style="width:79px;" title="1年什么什么什么">1年什么什么什么</span>
					<span class="productNav_type">浮动</span>
					<span class="productNav_type">6.30%</span>
				</li>
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