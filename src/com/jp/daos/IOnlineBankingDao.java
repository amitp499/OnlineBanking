package com.jp.daos;

import com.jp.entity.CustomerDetails;
import com.jp.entity.CustomerMaster;

public interface IOnlineBankingDao {
	
	public void addNewCustoer(CustomerMaster cm);
	public void addNewCustoer(CustomerDetails cd);

}
