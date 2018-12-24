package com.jp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jp.daos.IOnlineBankingDao;
import com.jp.entities.Accounts;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;

@Service("service")
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class OnlineBankingServiceImpl implements IOnlineBankingService{
	
	private IOnlineBankingDao dao;
	
	
	
	@Autowired
	public OnlineBankingServiceImpl(@Qualifier("dao") IOnlineBankingDao dao) {
		
		this.dao=dao;
		
	}




	@Override
	public boolean registerNewCustoer(CustomerMaster cd) throws OnlineBankingException {
		
		return dao.addNewCustoer(cd);
	}




	@Override
	public boolean openAccount(Accounts ac) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.addAccount(ac);
	}




	@Override
	public CustomerMaster serachUserIdCustomerMaster(Integer userId) throws OnlineBankingException {
		
		return dao.serachUserIdCustomerMaster(userId);
	}




	
}
