package com.fm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.dao.comn.IDFacade;
import com.fm.dao.comn.pagi.PageParameter;
import com.fm.dao.intf.comn.PageResult;
import com.fm.domain.pojo.Financial;
import com.fm.domain.vo.BaseFinance;
import com.fm.service.intf.FinancialService;

/**
 * @author:lxm
 * @date 20131004
 */
@Controller
@RequestMapping(value="/financial")
public class FinancialController {
	
	/**
	 * 返回记录总数
	 * @return
	 */
	@RequestMapping(value="/count")
	public String finance1 (HttpServletRequest r,Model m){
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
		int count = financialService.count();
		m.addAttribute("count", count);
		return "redirect:/datum/dynamic/jsp/finance/demo.jsp";
	}
	
	/**
	 * 插入一条记录
	 * @param r
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/insert")
	public String finance2 (HttpServletRequest r,Model m){
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
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
		m.addAttribute("result", "successful!");
		return "redirect:/datum/dynamic/jsp/finance/demo.jsp";
	}
	
	/**
	 * 更新一条数据
	 * @param r
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/update")
	public String finance3 (HttpServletRequest r,Model m){
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
		Financial financial = new Financial();
		financial.setFinancialId(IDFacade.getPKID());
		financial.setProductName("美联储宽松短期投资");
		financialService.update(financial);
		m.addAttribute("result", "successful!");
		return "redirect:/datum/dynamic/jsp/finance/demo.jsp";
	}
	
	/**
	 * 更新一条数据
	 * @param r
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/get")
	public String finance4 (ModelMap model, HttpServletRequest request,
			HttpServletResponse response){
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
		String key = request.getParameter("financialId");
		Financial financial=null;
		if(key!=null){
			financial = financialService.get(key); 
			model.addAttribute("financial", financial);
		}
		return "/product/financing/manageFinancesDetail.jsp";
	}
	
	/**
	 * 删除一条数据
	 * @param r
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/delete")
	public String finance5 (ModelMap model, HttpServletRequest request,
			HttpServletResponse response){
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
		String key = request.getParameter("financialId");
		if(key!=null){
			financialService.delete(key);
			model.addAttribute("result", "successful!");
		}else{
			model.addAttribute("result", "not a valid financialId!");
		}
		return "redirect:/datum/dynamic/jsp/finance/demo.jsp";
	}
	
	/**
	 * 获取全部记录
	 * @param r
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/select")
	public String finance6 (HttpServletRequest r,Model m){
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
		List<Financial> list = financialService.select();
		for(Financial f:list){
			System.out.println(f.getFinancialId()+" : "+f.getProductName());
		}
		return "redirect:/datum/dynamic/jsp/finance/demo.jsp";
	}
	
	/**
	 * 获取产品列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String finance7(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		return "redirect:/datum/dynamic/jsp/finance/manageFinancesProducts.jsp";
	}	
	
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public @ResponseBody 
    Map<String,Object> demoRequestBody(@RequestBody BaseFinance basefinance) {
    	System.out.println("currency:"+basefinance.getCurrency());
    	System.out.println("incomeType:"+basefinance.getIncomeType());
    	System.out.println("期限"+basefinance.getTimeLimite());
    	Map<String,Object> map = new HashMap<String,Object>();
    	PageResult<Financial> result = null;
		Map<String,Object> param = null;
		PageParameter page = null;
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
    	
		param=new HashMap<String,Object>();
		page = new PageParameter(1,6);
		page.setCurrentPage(Integer.parseInt(basefinance.getPageNumber()));
		param.put("page", page);
		param = getMap(param, basefinance);
		result=financialService.selectPagination(param);
		map.put("pagenumber", result.getCurrentPage());
		map.put("totalcount", result.getTotalCount());
		map.put("pagecount", result.getTotalPage());
		map.put("data", result.getList());
		System.out.println("data:"+result.getList().size());
        return map;
    }
	
    @RequestMapping(value = "/json1", method = RequestMethod.POST)
    public @ResponseBody 
    List<Financial> listRequestBody(@RequestBody BaseFinance basefinance) {
    	List<Financial> financials = null;
    	PageResult<Financial> result = null;
		Map<String,Object> param = null;
		PageParameter page = null;
		BeanFactory context = new ClassPathXmlApplicationContext(
				"classpath:com/fm/config/spring/*.xml");
		FinancialService financialService = (FinancialService) context.getBean("financialService");
    	
		param=new HashMap<String,Object>();
		page = new PageParameter();
		param.put("page", page);
		param = getMap(param, basefinance);
		result=financialService.selectPagination(param);
		financials = result.getList();
        return financials;
    }
    
    private Map<String,Object> getMap(Map<String,Object> params,BaseFinance basefinance){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	if(!"不限".equals(basefinance.getCurrency())){
    		params.put("currency", basefinance.getCurrency());
    	}
    	if(!"不限".equals(basefinance.getIncomeType())){
    		params.put("incomeType", basefinance.getIncomeType());
    	}
    	if(!"不限".equals(basefinance.getSalesStatus())){
    		if("在售".equals(basefinance.getSalesStatus())){
    			params.put("salesStartDate1", "00000000");
    			params.put("salesStartDate2", sdf.format(new Date()));
    		}else{
    			params.put("salesStartDate1", sdf.format(new Date()));
    			params.put("salesStartDate2", "99991230");;
    		}
    	}
    	if(!"不限".equals(basefinance.getTimeLimite())){
    		if("1个月以内".equals(basefinance.getTimeLimite())){
    			params.put("entrustManagePeriod1", "0");
    			params.put("entrustManagePeriod2", "30");
    		}
    		else if("1（含）-3个月".equals(basefinance.getTimeLimite())){
    			params.put("entrustManagePeriod1", "31");
    			params.put("entrustManagePeriod2", "93");
    		}
    		else if("3（含）-6个月".equals(basefinance.getTimeLimite())){
    			params.put("entrustManagePeriod1", "93");
    			params.put("entrustManagePeriod2", "186");
    		}
    		else if("6（含）-12个月".equals(basefinance.getTimeLimite())){
    			params.put("entrustManagePeriod1", "186");
    			params.put("entrustManagePeriod2", "365");
    		}
    		else if("1（含）年以上".equals(basefinance.getTimeLimite())){
    			params.put("entrustManagePeriod1", "365");
    			params.put("entrustManagePeriod2", "10000");
    		}else{
    			params.put("entrustManagePeriod1", "0");
    			params.put("entrustManagePeriod2", "30");
    		}
    	}
    	if(!"不限".equals(basefinance.getPurchaseAmount())){
    		if("5万以下".equals(basefinance.getPurchaseAmount())){
    			System.out.println("type:"+"5万元以下");
    			params.put("investmentsAmt1", "0");
    			params.put("investmentsAmt2", "4.9");
    		}
    		else if("5（含）-10万".equals(basefinance.getPurchaseAmount())){
    			params.put("investmentsAmt1", "5");
    			params.put("investmentsAmt2", "10");
    		}
    		else if("10（含）-20万".equals(basefinance.getPurchaseAmount())){
    			params.put("investmentsAmt1", "10");
    			params.put("investmentsAmt2", "20");
    		}
    		else if("20（含）-50万".equals(basefinance.getPurchaseAmount())){
    			params.put("investmentsAmt1", "20");
    			params.put("investmentsAmt2", "50");
    		}
    		else if("50（含）万以上".equals(basefinance.getPurchaseAmount())){
    			params.put("investmentsAmt1", "50");
    			params.put("investmentsAmt2", "1000");
    		}
    		else{
    			params.put("investmentsAmt1", "0");
    			params.put("investmentsAmt2", "5");
    		}
    	}
    	if(!"不限".equals(basefinance.getExpectedBenefits())){
    		if("0%-5%".equals(basefinance.getExpectedBenefits())){
    			params.put("incomeRate1", "00000");
    			params.put("incomeRate2", "00500");
    		}
    		else if("5%（含）-10%".equals(basefinance.getExpectedBenefits())){
    			params.put("incomeRate1", "00500");
    			params.put("incomeRate2", "01000");
    		}
    		else if("10%以上".equals(basefinance.getExpectedBenefits())){
    			params.put("incomeRate1", "01000");
    			params.put("incomeRate2", "10000");
    		}
    		else{
    			params.put("incomeRate1", "00000");
    			params.put("incomeRate2", "00500");
    		}
    	}
    	if(!"不限".equals(basefinance.getRiskLevel())){
    		params.put("riskLevel", basefinance.getRiskLevel());
    	}
    	if(!"不限".equals(basefinance.getProductType())){
    		params.put("productType", basefinance.getProductType());
    	}
    	if(!"全部银行".equals(basefinance.getIssueBank())){
    		params.put("bank", basefinance.getIssueBank());
    	}
    	params.put("salesRegion", basefinance.getSalesRegion());
    	return params;
    }
    
	public String getCity(String city){
		if("2".equals(city)){
			return "北京";
		}
		else if("3".equals(city)){
			return "成都";
		}
		else{
			return "上海";
		}
	}
	
	public String getValue(String value){
		if(null!=value){
			return value;
		}
		return null;
	}
}
