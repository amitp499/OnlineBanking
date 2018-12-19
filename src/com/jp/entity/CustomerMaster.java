package com.jp.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="Customer_Master")
@Table(name="CUSTOMER_MASTER_TBL")
public class CustomerMaster implements Serializable{
	
	static final long serialVersionUID = -4580059503230646675L;
	private Integer userId;
	private String custPassword;
	//private Integer customerId;
	private String role;		
	private CustomerDetail customermaster;
	private Set<Accounts> account;
	
	
	@OneToMany(mappedBy="customerMaster", cascade=CascadeType.ALL)
	public Set<Accounts> getAccount() {
		return account;
	}


	public void setAccount(Set<Accounts> account) {
		this.account = account;
	}


	@Id
	@Column(name="USER_ID")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/*public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}*/


	




	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
	public CustomerDetail getCustomermaster() {
		return customermaster;
	}


	

	public void setCustomermaster(CustomerDetail customermaster) {
		this.customermaster = customermaster;
	}
	
	
	
	

	@Column(name="ROLE")
	public String getRole() {
		return role;
	}

	/*@Column(name="CUSTOMER_ID")
	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
*/

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

	


	public CustomerMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CustomerMaster [userId=" + userId + ", custPassword=" + custPassword + 
				" role=" + role + ", customermaster=" + customermaster + ", account=" + account + "]";
	}


	

	
	
	
	
	

}
