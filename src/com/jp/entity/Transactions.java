package com.jp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Transaction")
@Table(name="TRANSACTION_TBL")
public class Transactions {
	
	private Integer transactionId;
	private Integer accountNo;
	private Double amount;
	private String transactionType;
	private Integer beneAccountNo;
	

}
