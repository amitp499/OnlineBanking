package com.jp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jp.daos.IOnlineBankingDao;
import com.jp.entities.Accounts;
import com.jp.entities.BeneficiaryDetails;
import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;

@Service("service")
//@Transactional(propagation=Propagation.REQUIRES_NEW)
public class OnlineBankingServiceImpl implements IOnlineBankingService{
	
	private IOnlineBankingDao dao;
	
	
	
	@Autowired
	public OnlineBankingServiceImpl(@Qualifier("dao") IOnlineBankingDao dao) {
		
		this.dao=dao;
		
	}




	@Override
	public boolean registerNewCustoer(CustomerMaster cm) throws OnlineBankingException {
		
		return dao.addNewCustoer(cm);
		//return false;
	}




	@Override
	public boolean openAccount(Accounts ac) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.addAccount(ac);
	}




	@Override
	public CustomerDetail serachUserIdCustomerMaster(Integer customerId) throws OnlineBankingException {
		
		return dao.serachUserIdCustomerMaster(customerId);
	}




	@Override
	public boolean addNewBeneDetails(BeneficiaryDetails bd) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.addNewBene(bd);
	}




	
}
