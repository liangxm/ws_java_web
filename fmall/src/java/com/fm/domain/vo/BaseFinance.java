package com.fm.domain.vo;

public class BaseFinance {

	String currency;
	String incomeType;
	String salesStatus;
	String timeLimite;
	String purchaseAmount;
	String expectedBenefits;
	String riskLevel;
	String productType;
	String issueBank;
	String salesRegion;
	String pageNumber;
	
	public BaseFinance(){
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	public String getTimeLimite() {
		return timeLimite;
	}

	public void setTimeLimite(String timeLimite) {
		this.timeLimite = timeLimite;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getExpectedBenefits() {
		return expectedBenefits;
	}

	public void setExpectedBenefits(String expectedBenefits) {
		this.expectedBenefits = expectedBenefits;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getIssueBank() {
		return issueBank;
	}

	public void setIssueBank(String issueBank) {
		this.issueBank = issueBank;
	}

	public String getSalesRegion() {
		return salesRegion;
	}

	public void setSalesRegion(String salesRegion) {
		this.salesRegion = salesRegion;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
}