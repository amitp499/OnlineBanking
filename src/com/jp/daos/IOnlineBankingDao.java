package com.jp.daos;

import com.jp.entity.CustomerMaster;
import com.jp.entity.Accounts;
import com.jp.entity.CustomerDetail;
import com.jp.exceptions.OnlineBankingException;

public interface IOnlineBankingDao {
	
	
	public boolean addNewCustoer(CustomerMaster cd) throws OnlineBankingException;
	
	public boolean addAccount(Accounts ac) throws OnlineBankingException;
	
	public CustomerMaster serachUserIdCustomerMaster(Integer userId) throws OnlineBankingException;

}
