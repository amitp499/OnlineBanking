package com.jp.services;

import com.jp.entity.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;

public interface IOnlineBankingService {
	
	
	public boolean registerNewCustoer(CustomerMaster cd) throws OnlineBankingException;

}
