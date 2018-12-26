package com.jp.daos;

import javax.transaction.Transaction;

import com.jp.entities.Accounts;
import com.jp.entities.BeneficiaryDetails;
import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.entities.SavingsAccount;
import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;

public interface IOnlineBankingDao {
	
	
	public boolean addNewCustoer(CustomerMaster cd) throws OnlineBankingException;
	
	public boolean addAccount(Accounts ac) throws OnlineBankingException;
	
	public CustomerDetail serachUserIdCustomerMaster(Integer customerId) throws OnlineBankingException;
	
	public boolean addNewBene(BeneficiaryDetails bd) throws OnlineBankingException;
	
	public boolean addBalanceToAccounts(Transactions trn) throws OnlineBankingException;
	
	public SavingsAccount serachByAccountInAccounts(Integer acctNo) throws OnlineBankingException;
	
	public Double getAccountBalance(Integer acctNo) throws OnlineBankingException;
	
	public boolean updateBalanceInAccounts(Accounts acct) throws OnlineBankingException;
	
	public BeneficiaryDetails serachByBeneAccount(Integer beneAcctNo) throws OnlineBankingException;
	
//	public Integer serachByBeneAccount(Integer beneAcctNo) throws OnlineBankingException;
	
	

}
