package com.jp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="CreditCardAccount")
@DiscriminatorValue(value="CREDITCARD")
public class CreditCardAccount extends Accounts {

	
	private static final long serialVersionUID = -647089728077642461L;

	public CreditCardAccount() {
		
		
	}
	
	

}
