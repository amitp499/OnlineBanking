package com.jp.services;

import com.jp.exceptions.OnlineBankingException;

public interface IOnlineBankingEmailService {

	public boolean sendCustomerRegistrationEmail(String customerEmailId, Integer loginId, String password) throws OnlineBankingException;
	
}

