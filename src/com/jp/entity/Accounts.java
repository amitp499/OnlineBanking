package com.jp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Accounts")
@Table(name="ACCOUNTS_TBL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACCOUNT_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Accounts implements Serializable{
	
	private static final long serialVersionUID = 4059544898404831586L;

	
	
	private Integer accountId;
	
	
//	private Integer userId;
	
	
	private Double accountBalance;	
	
	private CustomerMaster customerMaster;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	public CustomerMaster getCustomerMaster() {
		return customerMaster;
	}


	public void setCustomerMaster(CustomerMaster customerMaster) {
		this.customerMaster = customerMaster;
	}


	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId +  ", accountBalance=" + accountBalance
				+ "]";
	}


	public Accounts() {
		
	}
	
	@Id
	@Column(name="ACCOUNT_ID")
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
	@Column(name="ACCOUNT_BALANCE")
	public Double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	
	
	
	

}
