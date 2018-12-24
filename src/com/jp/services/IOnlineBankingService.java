package com.jp.services;

import com.jp.entities.Accounts;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;

public interface IOnlineBankingService {
	
	
	public boolean registerNewCustoer(CustomerMaster cd) throws OnlineBankingException;
	
	public boolean openAccount(Accounts ac) throws OnlineBankingException;
	
	public CustomerMaster serachUserIdCustomerMaster(Integer userId) throws OnlineBankingException;

}
