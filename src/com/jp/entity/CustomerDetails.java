package com.jp.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity(name="Customer_Detail")
@Table(name="CUSTOMER_DETAILS_TBL")
public class CustomerDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4580059503230646675L;
	private Integer customerDetailsId;
	private String custPassword;
	private String customerFullName;
	private String role;
	
	
	private CustomerMaster customermaster;
	
	
	@Id
	@Column(name="CUSTOMERDETAIL_ID")
	public Integer getCustomerDetailsId() {
		return customerDetailsId;
	}


	public void setCustomerDetailsId(Integer customerDetailsId) {
		this.customerDetailsId = customerDetailsId;
	}


	@OneToOne(cascade=CascadeType.ALL, mappedBy="customerdetails")
	public CustomerMaster getCustomermaster() {
		return customermaster;
	}


	public void setCustomermaster(CustomerMaster customermaster) {
		this.customermaster = customermaster;
	}
	
	
	@Column(name="CUSTOMER_FULLNAME")
	public String getCustomerFullName() {
		return customerFullName;
	}



	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	@Column(name="ROLE")
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Column(name="CUSTOMER_PASSWORD")
	public String getCustPassword() {
		return custPassword;
	}


	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	


	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*@Override
	public String toString() {
		return "CustomerDetails [customerDetailsId=" + customerDetailsId + ", custPassword=" + custPassword
				+ ", customerFullName=" + customerFullName + ", role=" + role + ", customermaster=" + customermaster
				+ "]";
	}*/


	
	
	
	
	

}
