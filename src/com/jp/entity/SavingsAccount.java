package com.jp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="SavingsAccount")
@DiscriminatorValue(value="SAVINGS")
public class SavingsAccount extends Accounts{
	
	private static final long serialVersionUID = -2166590062012116665L;
		
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
