package com.jp.daos;

import com.jp.entities.Accounts;
import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;

public interface IOnlineBankingDao {
	
	
	public boolean addNewCustoer(CustomerMaster cd) throws OnlineBankingException;
	
	public boolean addAccount(Accounts ac) throws OnlineBankingException;
	
	public CustomerMaster serachUserIdCustomerMaster(Integer userId) throws OnlineBankingException;

}
