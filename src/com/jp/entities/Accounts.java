package com.jp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Accounts")
@Table(name="ACCOUNTS_TBL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACCOUNT_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Accounts implements Serializable{
	
	private static final long serialVersionUID = 4059544898404831586L;

	
	
	private Integer accountNo;
	
	private Double accountBalance;	
	
	private CustomerDetail customerDetail;
	
	private Set<Transactions> transactions;
	
	


	@OneToMany(mappedBy="accounts",  cascade=CascadeType.ALL)
	public Set<Transactions> getTransactions() {
		return transactions;
	}


	public void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}


	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}


	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}


	@Override
	public String toString() {
		return "Accounts [accountId=" + accountNo +  ", accountBalance=" + accountBalance
				+ "]";
	}


	public Accounts() {
		
	}
	
	@SequenceGenerator(name="account_no_seq", initialValue=10254887,allocationSize=21)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="account_no_seq")
	@Id
	@Column(name="ACCOUNT_NO")
	public Integer getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	
	
	@Column(name="ACCOUNT_BALANCE")
	public Double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	
	
	
	

}