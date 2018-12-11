package com.jp.entity;

public class UserMaster {
	
	private String customerName;
	private Integer customerMobileNo;
	private String customerGender;
	private String customerEmail;
	private String customerDOB;
	private String customerCity;
	private String customerAddress;
	private String customerState;
	private String customerCountry;
	private String customerBranch;
	private Long customerAadharId;
	private String customerPanCard;
	
	
	
	public UserMaster(String customerName, Integer customerMobileNo, String customerGender, String customerEmail,
			String customerDOB, String customerCity, String customerAddress, String customerState,
			String customerCountry, String customerBranch, Long customerAadharId, String customerPanCard) {
		super();
		this.customerName = customerName;
		this.customerMobileNo = customerMobileNo;
		this.customerGender = customerGender;
		this.customerEmail = customerEmail;
		this.customerDOB = customerDOB;
		this.customerCity = customerCity;
		this.customerAddress = customerAddress;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.customerBranch = customerBranch;
		this.customerAadharId = customerAadharId;
		this.customerPanCard = customerPanCard;
		
	}



	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public Integer getCustomerMobileNo() {
		return customerMobileNo;
	}



	public void setCustomerMobileNo(Integer customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}



	public String getCustomerGender() {
		return customerGender;
	}



	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public String getCustomerDOB() {
		return customerDOB;
	}



	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}



	public String getCustomerCity() {
		return customerCity;
	}



	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}



	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}



	public String getCustomerState() {
		return customerState;
	}



	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}



	public String getCustomerCountry() {
		return customerCountry;
	}



	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}



	public String getCustomerBranch() {
		return customerBranch;
	}



	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}



	public Long getCustomerAadharId() {
		return customerAadharId;
	}



	public void setCustomerAadharId(Long customerAadharId) {
		this.customerAadharId = customerAadharId;
	}



	public String getCustomerPanCard() {
		return customerPanCard;
	}



	public void setCustomerPanCard(String customerPanCard) {
		this.customerPanCard = customerPanCard;
	}
	
	

}
