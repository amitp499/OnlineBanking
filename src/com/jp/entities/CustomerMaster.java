package com.jp.entities;

import java.io.Serializable;
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


@Entity(name="Customer_Master")
@Table(name="CUSTOMER_MASTER_TBL")
public class CustomerMaster implements Serializable{
	
	static final long serialVersionUID = -4580059503230646675L;
	private Integer loginId;
	private String custPassword;
	private String role;		
	private CustomerDetail customerdetail;
	

	@SequenceGenerator(name="login_id_seq",sequenceName="login_id_seq", initialValue=7000,allocationSize=55)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="login_id_seq")
	@Id
	@Column(name="LOGIN_ID")
	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}



	




	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
	public CustomerDetail getCustomerdetail() {
		return customerdetail;
	}


	

	public void setCustomerdetail(CustomerDetail customerdetail) {
		this.customerdetail = customerdetail;
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
		return "CustomerMaster [loginId=" + loginId + ", custPassword=" + custPassword + 
				" role=" + role + ", customerdetail=" + customerdetail + "]";
	}


	

	
	
	
	
	

}
