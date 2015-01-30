package com.fm.domain.pojo;

/**
 * 理财产品实体类
 * @author lxm
 * @version 2013-10-4 23:21:13
 */
public class Financial {
	
	/**主键*/
    private String financialId;

    /**产品名称*/
    private String productName;

    /**产品代码*/
    private String productCode;

    /**产品类型*/
    private String productType;

    /**收益类型*/
    private String incomeType;

    /**产品风险等级*/
    private String riskLevel;

    /**投资者风险偏好*/
    private String riskPreference;

    /**是否保本(0<是>/1<否>)*/
    private String keepPrincipal;

    /**币种*/
    private String currency;

    /**所属银行*/
    private String bank;

    /**委托管理期限*/
    private String entrustManagePeriod;

    /**预期最高年化收益率*/
    private String incomeRate;

    /**销售起始时间（yyyyMMddHHmmss）*/
    private String salesStartDate;

    /**销售结束时间（yyyyMMddHHmmss）*/
    private String salesEndDate;

    /**收益起始时间（yyyyMMddHHmmss）*/
    private String incomeStartDate;

    /**收益结束时间（yyyyMMddHHmmss）*/
    private String incomeEndDate;

    /**投资金额*/
    private String investmentsAmt;

    /**销售地区*/
    private String salesRegion;

    /**投资标的*/
    private String investmentTargets;

    /**实际年化收益率*/
    private String actualAnnualYield;

    /**收益计算方法*/
    private String incomeCalculate;

    /**投资方向说明*/
    private String investmentDirectionDesc;

    /**风险提示*/
    private String riskWarning;

    /**理财份额面值*/
    private String financialNominalVal;

    /**委托起始金额*/
    private String entrustStartAmt;

    /**委托金额递增单位*/
    private String entrustAmtIncreUnit;

    /**购买方式*/
    private String buyWay;

    /**浮动管理费说明*/
    private String floatManageFeeDesc;

    /**账单查询方式*/
    private String billQuery;

    /**收益支付期限*/
    private String incomePayPeriod;

    /**是否自动终止(0<是>/1<否>)*/
    private String autoTerminateFlag;

    /**自动终止条件*/
    private String autoTerminateCondition;

    /**银行是否有权提前终止(0<是>/1<否>)*/
    private String bankTerminateFlag;

    /**银行提前终止条件*/
    private String bankTerminateDesc;

    /**客户是否有权赎回(0<是>/1<否>)*/
    private String clientRedemptionFlag;

    /**客户赎回条件*/
    private String clientRedemptionCondition;

    /**创建日期（yyyyMMddHHmmss）*/
    private String dateCreated;

    /**修改日期（yyyyMMddHHmmss）*/
    private String dateModified;

    /**创建者*/
    private String createdBy;

    /**修改者*/
    private String modifiedBy;

    /**是否生效(0<有效>/1<无效>)*/
    private String deleted;

    /**版本号*/
    private String version;

    public String getFinancialId() {
        return financialId;
    }

    public void setFinancialId(String financialId) {
        this.financialId = financialId == null ? null : financialId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType == null ? null : incomeType.trim();
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    public String getRiskPreference() {
        return riskPreference;
    }

    public void setRiskPreference(String riskPreference) {
        this.riskPreference = riskPreference == null ? null : riskPreference.trim();
    }

    public String getKeepPrincipal() {
        return keepPrincipal;
    }

    public void setKeepPrincipal(String keepPrincipal) {
        this.keepPrincipal = keepPrincipal == null ? null : keepPrincipal.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getEntrustManagePeriod() {
        return entrustManagePeriod;
    }

    public void setEntrustManagePeriod(String entrustManagePeriod) {
        this.entrustManagePeriod = entrustManagePeriod == null ? null : entrustManagePeriod.trim();
    }

    public String getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(String incomeRate) {
        this.incomeRate = incomeRate == null ? null : incomeRate.trim();
    }

    public String getSalesStartDate() {
        return salesStartDate;
    }

    public void setSalesStartDate(String salesStartDate) {
        this.salesStartDate = salesStartDate == null ? null : salesStartDate.trim();
    }

    public String getSalesEndDate() {
        return salesEndDate;
    }

    public void setSalesEndDate(String salesEndDate) {
        this.salesEndDate = salesEndDate == null ? null : salesEndDate.trim();
    }

    public String getIncomeStartDate() {
        return incomeStartDate;
    }

    public void setIncomeStartDate(String incomeStartDate) {
        this.incomeStartDate = incomeStartDate == null ? null : incomeStartDate.trim();
    }

    public String getIncomeEndDate() {
        return incomeEndDate;
    }

    public void setIncomeEndDate(String incomeEndDate) {
        this.incomeEndDate = incomeEndDate == null ? null : incomeEndDate.trim();
    }

    public String getInvestmentsAmt() {
        return investmentsAmt;
    }

    public void setInvestmentsAmt(String investmentsAmt) {
        this.investmentsAmt = investmentsAmt == null ? null : investmentsAmt.trim();
    }

    public String getSalesRegion() {
        return salesRegion;
    }

    public void setSalesRegion(String salesRegion) {
        this.salesRegion = salesRegion == null ? null : salesRegion.trim();
    }

    public String getInvestmentTargets() {
        return investmentTargets;
    }

    public void setInvestmentTargets(String investmentTargets) {
        this.investmentTargets = investmentTargets == null ? null : investmentTargets.trim();
    }

    public String getActualAnnualYield() {
        return actualAnnualYield;
    }

    public void setActualAnnualYield(String actualAnnualYield) {
        this.actualAnnualYield = actualAnnualYield == null ? null : actualAnnualYield.trim();
    }

    public String getIncomeCalculate() {
        return incomeCalculate;
    }

    public void setIncomeCalculate(String incomeCalculate) {
        this.incomeCalculate = incomeCalculate == null ? null : incomeCalculate.trim();
    }

    public String getInvestmentDirectionDesc() {
        return investmentDirectionDesc;
    }

    public void setInvestmentDirectionDesc(String investmentDirectionDesc) {
        this.investmentDirectionDesc = investmentDirectionDesc == null ? null : investmentDirectionDesc.trim();
    }

    public String getRiskWarning() {
        return riskWarning;
    }

    public void setRiskWarning(String riskWarning) {
        this.riskWarning = riskWarning == null ? null : riskWarning.trim();
    }

    public String getFinancialNominalVal() {
        return financialNominalVal;
    }

    public void setFinancialNominalVal(String financialNominalVal) {
        this.financialNominalVal = financialNominalVal == null ? null : financialNominalVal.trim();
    }

    public String getEntrustStartAmt() {
        return entrustStartAmt;
    }

    public void setEntrustStartAmt(String entrustStartAmt) {
        this.entrustStartAmt = entrustStartAmt == null ? null : entrustStartAmt.trim();
    }

    public String getEntrustAmtIncreUnit() {
        return entrustAmtIncreUnit;
    }

    public void setEntrustAmtIncreUnit(String entrustAmtIncreUnit) {
        this.entrustAmtIncreUnit = entrustAmtIncreUnit == null ? null : entrustAmtIncreUnit.trim();
    }

    public String getBuyWay() {
        return buyWay;
    }

    public void setBuyWay(String buyWay) {
        this.buyWay = buyWay == null ? null : buyWay.trim();
    }

    public String getFloatManageFeeDesc() {
        return floatManageFeeDesc;
    }

    public void setFloatManageFeeDesc(String floatManageFeeDesc) {
        this.floatManageFeeDesc = floatManageFeeDesc == null ? null : floatManageFeeDesc.trim();
    }

    public String getBillQuery() {
        return billQuery;
    }

    public void setBillQuery(String billQuery) {
        this.billQuery = billQuery == null ? null : billQuery.trim();
    }

    public String getIncomePayPeriod() {
        return incomePayPeriod;
    }

    public void setIncomePayPeriod(String incomePayPeriod) {
        this.incomePayPeriod = incomePayPeriod == null ? null : incomePayPeriod.trim();
    }

    public String getAutoTerminateFlag() {
        return autoTerminateFlag;
    }

    public void setAutoTerminateFlag(String autoTerminateFlag) {
        this.autoTerminateFlag = autoTerminateFlag == null ? null : autoTerminateFlag.trim();
    }

    public String getAutoTerminateCondition() {
        return autoTerminateCondition;
    }

    public void setAutoTerminateCondition(String autoTerminateCondition) {
        this.autoTerminateCondition = autoTerminateCondition == null ? null : autoTerminateCondition.trim();
    }

    public String getBankTerminateFlag() {
        return bankTerminateFlag;
    }

    public void setBankTerminateFlag(String bankTerminateFlag) {
        this.bankTerminateFlag = bankTerminateFlag == null ? null : bankTerminateFlag.trim();
    }

    public String getBankTerminateDesc() {
        return bankTerminateDesc;
    }

    public void setBankTerminateDesc(String bankTerminateDesc) {
        this.bankTerminateDesc = bankTerminateDesc == null ? null : bankTerminateDesc.trim();
    }

    public String getClientRedemptionFlag() {
        return clientRedemptionFlag;
    }

    public void setClientRedemptionFlag(String clientRedemptionFlag) {
        this.clientRedemptionFlag = clientRedemptionFlag == null ? null : clientRedemptionFlag.trim();
    }

    public String getClientRedemptionCondition() {
        return clientRedemptionCondition;
    }

    public void setClientRedemptionCondition(String clientRedemptionCondition) {
        this.clientRedemptionCondition = clientRedemptionCondition == null ? null : clientRedemptionCondition.trim();
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated == null ? null : dateCreated.trim();
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified == null ? null : dateModified.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }
}