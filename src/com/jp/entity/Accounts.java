package com.jp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Accounts")
@Table(name="Accounts_TBL")

public abstract class Accounts implements Serializable{
	
	private static final long serialVersionUID = 4059544898404831586L;


	@Column(name="ACCOUNT_ID")
	private Integer accountId;
	
	
	private Integer userId;
	
	@Column(name="ACCOUNT_BALANCE")
	private Double accountBalance;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	
	
	public Accounts() {
		
	}
	
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
	
	public Double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	

}
