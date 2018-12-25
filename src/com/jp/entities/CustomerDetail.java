package com.jp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Customer_Detail")
@Table(name="CUSTOMER_DETAILS_TBL")
public class CustomerDetail implements Serializable{
	
	
	private static final long serialVersionUID = 6471386886575838136L;
	private Integer customerId;
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
	private Integer customerAadharId;
	private String customerPanCard;
	private String customerPhotoPath;
	private String customerSignaturePath;
	private CustomerMaster customermaster;
	private Set<Accounts> account;
	private Set<BeneficiaryDetails> beneficiaryDetails;
	

	
	
	
	
	@OneToMany(mappedBy="customerDetail", cascade=CascadeType.ALL)
	public Set<BeneficiaryDetails> getBeneficiaryDetails() {
		return beneficiaryDetails;
	}


	public void setBeneficiaryDetails(Set<BeneficiaryDetails> beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}


	@OneToMany(mappedBy="customerDetail", cascade=CascadeType.ALL)
	public Set<Accounts> getAccount() {
		return account;
	}


	public void setAccount(Set<Accounts> account) {
		this.account = account;
	}
		
	
	public CustomerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}




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
	
	@SequenceGenerator(name="customer_id_seq",sequenceName="customer_id_seq", initialValue=5000,allocationSize=75)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_id_seq")
	@Id
	@Column(name="CUSTOMER_ID")	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="customerdetail")
	public CustomerMaster getCustomermaster() {
		return customermaster;
	}




	public void setCustomermaster(CustomerMaster customermaster) {
		this.customermaster = customermaster;
	}


	
	@Column(name="CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Column(name="CUSTOMER_MOBLILENO")
	public Integer getCustomerMobileNo() {
		return customerMobileNo;
	}



	public void setCustomerMobileNo(Integer customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}


	@Column(name="CUSTOMER_GENDER")
	public String getCustomerGender() {
		return customerGender;
	}



	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}


	@Column(name="CUSTOMER_EMAIL")
	public String getCustomerEmail() {
		return customerEmail;
	}


	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	@Column(name="CUSTOMER_DATEOFBIRTH")
	public String getCustomerDOB() {
		return customerDOB;
	}



	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}


	@Column(name="CUSTOMER_CITY")
	public String getCustomerCity() {
		return customerCity;
	}


	
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}


	@Column(name="CUSTOMER_ADDRESS")
	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	@Column(name="CUSTOMER_STATE")
	public String getCustomerState() {
		return customerState;
	}



	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}


	@Column(name="CUSTOMER_COUNTRY")
	public String getCustomerCountry() {
		return customerCountry;
	}



	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}


	@Column(name="CUSTOMER_BRANCH")
	public String getCustomerBranch() {
		return customerBranch;
	}



	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}


	@Column(name="CUSTOMER_AADHARID")
	public Integer getCustomerAadharId() {
		return customerAadharId;
	}

	

	public void setCustomerAadharId(Integer customerAadharId) {
		this.customerAadharId = customerAadharId;
	}


	@Column(name="CUSTOMER_PANCARD")
	public String getCustomerPanCard() {
		return customerPanCard;
	}


	
	public void setCustomerPanCard(String customerPanCard) {
		this.customerPanCard = customerPanCard;
	}




	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNo="
				+ customerMobileNo + ", customerGender=" + customerGender + ", customerEmail=" + customerEmail
				+ ", customerDOB=" + customerDOB + ", customerCity=" + customerCity + ", customerAddress="
				+ customerAddress + ", customerState=" + customerState + ", customerCountry=" + customerCountry
				+ ", customerBranch=" + customerBranch + ", customerAadharId=" + customerAadharId + ", customerPanCard="
				+ customerPanCard + ", customerPhotoPath=" + customerPhotoPath + ", customerSignaturePath="
				+ customerSignaturePath + "]";
	}
	
	
	
	
	
	
	

}
