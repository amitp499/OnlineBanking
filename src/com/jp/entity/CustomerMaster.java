package com.jp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Customer_Master")
@Table(name="CUSTOMER_MASTER_TBL")
public class CustomerMaster {
	
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
	private String customerPhotoPath;
	private String customerSignaturePath;
	private CustomerDetails customerdetails;
	
	
	@Column(name="CUSTOMER_PHOTO_PATH")
	public String getCustomerPhotoPath() {
		return customerPhotoPath;
	}


	public void setCustomerPhotoPath(String customerPhotoPath) {
		this.customerPhotoPath = customerPhotoPath;
	}

	@Column(name="CUSTOMER_SIGNATURE_PATH")
	public String getCustomerSignaturePath() {
		return customerSignaturePath;
	}


	public void setCustomerSignaturePath(String customerSignaturePath) {
		this.customerSignaturePath = customerSignaturePath;
	}
	
	
	@Id	
	@OneToOne
	@JoinColumn(name="CUSTMER_ID")
	public CustomerDetails getCustomerdetails() {
		return customerdetails;
	}


	public void setCustomerdetails(CustomerDetails customerdetails) {
		this.customerdetails = customerdetails;
	}


	public CustomerMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Column(name="CUSTMER_NAME")
	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Column(name="CUSTMER_MOBLILENO")
	public Integer getCustomerMobileNo() {
		return customerMobileNo;
	}



	public void setCustomerMobileNo(Integer customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}


	@Column(name="CUSTMER_GENDER")
	public String getCustomerGender() {
		return customerGender;
	}



	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}


	@Column(name="CUSTMER_EMAIL")
	public String getCustomerEmail() {
		return customerEmail;
	}


	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	@Column(name="CUSTMER_DATEOFBIRTH")
	public String getCustomerDOB() {
		return customerDOB;
	}



	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}


	@Column(name="CUSTMER_CITY")
	public String getCustomerCity() {
		return customerCity;
	}


	
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}


	@Column(name="CUSTMER_ADDRESS")
	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	@Column(name="CUSTMER_STATE")
	public String getCustomerState() {
		return customerState;
	}



	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}


	@Column(name="CUSTMER_COUNTRY")
	public String getCustomerCountry() {
		return customerCountry;
	}



	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}


	@Column(name="CUSTMER_BRANCH")
	public String getCustomerBranch() {
		return customerBranch;
	}



	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}


	@Column(name="CUSTMER_AADHARID")
	public Long getCustomerAadharId() {
		return customerAadharId;
	}



	public void setCustomerAadharId(Long customerAadharId) {
		this.customerAadharId = customerAadharId;
	}


	@Column(name="CUSTMER_PANCARD")
	public String getCustomerPanCard() {
		return customerPanCard;
	}


	
	public void setCustomerPanCard(String customerPanCard) {
		this.customerPanCard = customerPanCard;
	}
	
	
	
	
	

}
