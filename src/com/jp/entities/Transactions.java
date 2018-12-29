package com.jp.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Transaction")
@Table(name="TRANSACTION_TBL")
public class Transactions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8174998037086640974L;
	private Integer transactionId;
	private Double amount;
	private String transactionType;
	private Integer beneAccountNo;
	private String transactionInfo;
	private Double balance;
	private Accounts accounts;
	private String transactionDateTime;
	
	//@Temporal(value=TemporalType.DATE)
	@Column(name="TRANSACTION_DATETIME")
	public String getTransactionDateTime() {
		return transactionDateTime;
	}


	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}


	@SequenceGenerator(name="transaction_id_seq", sequenceName="transaction_id_seq",allocationSize=33)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="transaction_id_seq")	
	@Id
	@Column(name="TRANSACTION_ID")
	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	@ManyToOne
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


	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", beneAccountNo=" + beneAccountNo + ", transactionInfo=" + transactionInfo
				 + ", balance=" + balance + ", accounts=" + accounts + "]";
	}
	
	
	
	

}
