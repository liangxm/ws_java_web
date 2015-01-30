package com.fmall.product;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fm.dao.comn.IDFacade;
import com.fm.domain.pojo.Financial;
import com.fm.service.intf.FinancialService;

public class Test_Financial {
	BeanFactory context = new ClassPathXmlApplicationContext(
			"classpath:com/fm/config/spring/*.xml");
	
	@Test
	public void test_insert(){
		FinancialService financialService = (FinancialService) context.getBean("financialService");
		Financial financial = new Financial();
		financial.setFinancialId(IDFacade.getPKID());
		financial.setProductName("1年期股票挂钩人民币结构性产品RMBE2013-3");
		financial.setProductCode("RMBE2013-3");
		financial.setProductType("结构性产品");
		financial.setIncomeType("浮动");
		financial.setIncomeRate("00650");
		financial.setRiskLevel("中等");
		financial.setRiskPreference("谨慎型");
		financial.setKeepPrincipal("1");
		financial.setCurrency("人民币");
		financial.setBank("法兴银行");
		financial.setEntrustManagePeriod("1年");
		financial.setSalesStartDate("20130929");
		financial.setSalesEndDate("20131018");
		financial.setIncomeStartDate("20131023");
		financial.setIncomeEndDate("20141028");
		financial.setSalesRegion("上海市,杭州市,武汉市,广州市");
		financial.setInvestmentsAmt("10万元");
		financial.setInvestmentTargets("股票");
		financial.setIncomeCalculate("客户持有本产品至到期日将按照如下规定获得相关收益");
		financial.setInvestmentDirectionDesc("");
		financial.setRiskWarning("本结构性产品是保本浮动收益理财计划有投资风险您只能获得合同明确承诺的收益您应当充分认识投资风险谨慎投资");
		financial.setFinancialNominalVal("1元");
		financial.setEntrustStartAmt("10万元");
		financial.setEntrustAmtIncreUnit("10000");
		financial.setAutoTerminateFlag("0");
		financial.setBankTerminateFlag("1");
		financial.setClientRedemptionFlag("0");
		financial.setBillQuery("需到银行网点或银行网站查询");
		financial.setDateCreated("20131215");
		financial.setDateModified("20131215");
		financial.setDeleted("0");
		financial.setVersion("20131215");
		financialService.insert(financial);
	}
	
}