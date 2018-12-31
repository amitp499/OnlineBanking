package com.jp.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
import com.jp.entities.SavingsAccount;
import com.jp.entities.Transactions;
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




	@Override
	public boolean addBalanceToAccounts(Transactions trn) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.addBalanceToAccounts(trn);
	}




	@Override
	public Accounts serachByAccountInAccounts(Integer acctNo) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.serachByAccountInAccounts(acctNo);
	}




	@Override
	public Double getAccountBalance(Integer acctNo) throws OnlineBankingException {
		
		return dao.getAccountBalance(acctNo);
	}




	@Override
	public boolean updateBalanceInAccounts(Accounts acct) throws OnlineBankingException {
		
		return dao.updateBalanceInAccounts(acct);
	}




	@Override
	public BeneficiaryDetails serachByBeneAccount(Integer beneAcctNo) throws OnlineBankingException {
		
		return dao.serachByBeneAccount(beneAcctNo);
	}




	@Override
	public Set<BeneficiaryDetails> getListOfBene(Integer acctNo) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.getListOfBene(acctNo);
	}




	@Override
	public boolean deleteBeneficiary(Integer beneId) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.deleteBeneficiary(beneId);
	}




	@Override
	public ArrayList<Transactions> viewAccountStatement(Integer accountNo, String fromDate, String toDate) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return dao.viewAccountStatement(accountNo, fromDate, toDate);
	}




	@Override
	public ArrayList<BeneficiaryDetails> getBeneficiaryListByCustomerId(Integer custId) throws OnlineBankingException {
		
		return dao.getBeneficiaryListByCustomerId(custId);
	}




	
}
