package com.jp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jp.entities.Accounts;
import com.jp.entities.BeneficiaryDetails;
import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.entities.SavingsAccount;
import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;


@Repository("dao")
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class OnlineBankingDaoImpl implements IOnlineBankingDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addNewCustoer(CustomerMaster cm) throws OnlineBankingException {		
		boolean addCustomerFlag=false;
		
		entityManager.persist(cm);		
		//
		if (entityManager.find(CustomerMaster.class, cm.getLoginId())!=null){
			
			addCustomerFlag=true;
			
		}
		return addCustomerFlag;
	}

	@Override
	public boolean addAccount(Accounts ac) throws OnlineBankingException {
		boolean addAccountFlag=false;
		//System.out.println("saving");
		//System.out.println(ac);
		entityManager.persist(ac);
		
		if (entityManager.find(Accounts.class, ac.getAccountNo())!=null){
			
			addAccountFlag=true;
			
		}
		return addAccountFlag;
	}

	@Override
	public CustomerDetail serachUserIdCustomerMaster(Integer userId) throws OnlineBankingException {
		//System.out.println("cust");
		//System.out.println(entityManager.find(CustomerMaster.class, userId));
		return entityManager.find(CustomerDetail.class, userId);
	}

	@Override
	public boolean addNewBene(BeneficiaryDetails bd) throws OnlineBankingException {
		
		boolean addBeneFlag=false;
		
		//System.out.println(bd);
		entityManager.persist(bd);		
	
		if (entityManager.find(BeneficiaryDetails.class, bd.getBeneficiaryAccountNo())!=null){
			
			addBeneFlag=true;
			
		}
		return addBeneFlag;
	}

	@Override
	public boolean addBalanceToAccounts(Transactions trn) throws OnlineBankingException {
		

		boolean addBalFlag=false;
		System.out.println(trn);
		
		entityManager.persist(trn);		
	
		if (entityManager.find(Transactions.class, trn.getTransactionId())!=null){
			
			addBalFlag=true;
			
		}
		return addBalFlag;
	}

	@Override
	public SavingsAccount serachByAccountInAccounts(Integer acctNo) throws OnlineBankingException {
		
		return entityManager.find(SavingsAccount.class, acctNo);
	}

	@Override
	public Double getAccountBalance(Integer acctNo) throws OnlineBankingException {
		Accounts aa = entityManager.find(Accounts.class, acctNo);
		return aa.getAccountBalance();
	}

	@Override
	public boolean updateBalanceInAccounts(Accounts acct) throws OnlineBankingException {

		boolean updateBalFlag=false;
		//System.out.println(trn);
		
		entityManager.merge(acct);
		
		Accounts updatedAccount = entityManager.find(Accounts.class, acct.getAccountNo());
	
		if (acct.getAccountBalance()==updatedAccount.getAccountBalance()){
			
			updateBalFlag=true;
			
		}
		return updateBalFlag;
	}

	
		
	
	

}
