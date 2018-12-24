package com.jp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Transaction")
@Table(name="TRANSACTION_TBL")
public class Transactions {
	
	private Integer transactionId;
	//private Integer accountNo;
	private Double amount;
	private String transactionType;
	private Integer beneAccountNo;
	private String transactionInfo;
	private String dateTime;
	private Double balance;
	private Accounts accounts;
	
		
	@Id
	@Column(name="TRANSACTION_ID")
	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ACCOUNT_NO", referencedColumnName="ACCOUNT_NO")
	public Accounts getAccounts() {
		return accounts;
	}


	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}


	@Column(name="AMOUNT")
	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Column(name="TRANSACTION_TYPE")
	public String getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	@Column(name="BENE_ACCOUNTNO")
	public Integer getBeneAccountNo() {
		return beneAccountNo;
	}



	public void setBeneAccountNo(Integer beneAccountNo) {
		this.beneAccountNo = beneAccountNo;
	}

	
	@Column(name="TRANSACTION_INFO")
	public String getTransactionInfo() {
		return transactionInfo;
	}



	public void setTransactionInfo(String transactionInfo) {
		this.transactionInfo = transactionInfo;
	}


	@Column(name="TRANSACTION_DATETIME")
	public String getDateTime() {
		return dateTime;
	}



	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}


	@Column(name="ACCOUNT_BALANCE")
	public Double getBalance() {
		return balance;
	}



	public void setBalance(Double balance) {
		this.balance = balance;
	}



	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
