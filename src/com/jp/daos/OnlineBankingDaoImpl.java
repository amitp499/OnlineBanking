package com.jp.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		
		Query query = entityManager.createQuery("Select c from Customer_Detail c where c.customerId = :userId");
		query.setParameter("userId",userId);
		CustomerDetail act = (CustomerDetail) query.getSingleResult();
		
		//return entityManager.find(Accounts.class, acctNo);
			return act;
		
		//return entityManager.find(CustomerDetail.class, userId);
	}

	@Override
	public boolean addNewBene(BeneficiaryDetails bd) throws OnlineBankingException {
		
		boolean addBeneFlag=false;
			
		entityManager.persist(bd);		
		
		BeneficiaryDetails abd = entityManager.find(BeneficiaryDetails.class, bd.getBeneficiaryId());
		//System.out.println(abd);
		if (abd.getBeneficiaryAccountNo()==bd.getBeneficiaryAccountNo()){
			//System.out.println("entered");
			addBeneFlag=true;
			
		}
		return addBeneFlag;
	}

	@Override
	public boolean addBalanceToAccounts(Transactions trn) throws OnlineBankingException {
		

		boolean addBalFlag=false;

		
		entityManager.persist(trn);		
	
		if (entityManager.find(Transactions.class, trn.getTransactionId())!=null){
			
			addBalFlag=true;
			
		}
		return addBalFlag;
	}

	/*@Override
	public Accounts serachByAccountInAccounts_Old(Integer acctNo) throws OnlineBankingException {
		
		Query query = entityManager.createQuery("Select e from Accounts e where e.accountNo = :acctNo");
		query.setParameter("acctNo",acctNo);
			Accounts act = (Accounts) query.getSingleResult();
		
		//return entityManager.find(Accounts.class, acctNo);
			return act;
	}*/
	
	@Override
	public Accounts serachByCustIdInAccounts(Integer acctNo) throws OnlineBankingException {
		
		Query query = entityManager.createQuery("Select e from Accounts e where e.customerDetail.customerId = :acctNo");
		query.setParameter("acctNo",acctNo);
			Accounts act = (Accounts) query.getSingleResult();
		
		//return entityManager.find(Accounts.class, acctNo);
			return act;
	}
	
	@Override
	public Accounts serachByAccountInAccounts(Integer acctNo) throws OnlineBankingException {
		
		Query query = entityManager.createQuery("Select e from Accounts e where e.accountNo = :acctNo");
		query.setParameter("acctNo",acctNo);
			Accounts act = (Accounts) query.getSingleResult();
		
		//return entityManager.find(Accounts.class, acctNo);
			return act;
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

	@Override
	public BeneficiaryDetails serachByBeneAccount(Integer beneAcctNo) throws OnlineBankingException {
		
		/*BeneficiaryDetails bd = entityManager.find(BeneficiaryDetails.class, beneAcctNo);
		System.out.println(bd);*/
		
		System.out.println(beneAcctNo);
		
			Query query = entityManager.createQuery("select b from Beneficiary b where b.beneficiaryAccountNo = :beneAcctNo");
		
		query.setParameter("beneAcctNo",beneAcctNo);		
		
		BeneficiaryDetails bene = (BeneficiaryDetails) query.getSingleResult();
		
		return bene;
	}

	@Override
	public Set<BeneficiaryDetails> getListOfBene(Integer acctNo) throws OnlineBankingException {
		
		CustomerDetail cdBeneList = entityManager.find(CustomerDetail.class, acctNo);
		Set<BeneficiaryDetails> beneList = cdBeneList.getBeneficiaryDetails();
		return beneList;
	}

	@Override
	public boolean deleteBeneficiary(Integer beneId) throws OnlineBankingException {
		boolean deleteBeneFlag=false;
		boolean deleteFoundFlag=false;
		
		BeneficiaryDetails beneToDelete = entityManager.find(BeneficiaryDetails.class, beneId);
		if (beneToDelete!=null) {
			
			System.out.println(beneToDelete);
			entityManager.remove(beneToDelete);
									
			deleteFoundFlag=true;
		}
		
		if ((entityManager.find(BeneficiaryDetails.class, beneId)==null) && (deleteFoundFlag==true)) {
			
			deleteBeneFlag=true;
		}
		
		return deleteBeneFlag;
	}

	@Override
	public ArrayList<Transactions> viewAccountStatement(Integer accountNo, String fromDate, String toDate) throws OnlineBankingException {
		
		Query query = entityManager.createQuery("select t from Transaction t where t.accounts.accountNo = :accountNo"
				+ " and t.transactionDateTime between :fromDate and :toDate");
		//select * from TRANSACTION_TBL where customer_account_no ='3549777' and transaction_datetime between '29-DEC-18' and '29-DEC-18';	
		query.setParameter("accountNo",accountNo);
		query.setParameter("fromDate",fromDate+" T 00:00:00");
		query.setParameter("toDate",toDate+" T 23:59:59");
		
		ArrayList<Transactions> trnList = (ArrayList<Transactions>) query.getResultList();
		return trnList;
	}

	@Override
	public ArrayList<BeneficiaryDetails> getBeneficiaryListByCustomerId(Integer custId) throws OnlineBankingException {
						
		Query query = entityManager.createQuery("select b from Beneficiary b where b.customerDetail.customerId = :custId");
		
		query.setParameter("custId",custId);		
		
		ArrayList<BeneficiaryDetails> beneList = (ArrayList<BeneficiaryDetails>) query.getResultList();

		return beneList;
	}
	
	@Override
	public CustomerMaster doLogin(Integer loginId) throws OnlineBankingException {
		CustomerMaster loginCustomer =null;
		loginCustomer=	entityManager.find(CustomerMaster.class, loginId);		
		return loginCustomer;
	}


	
		
	
	

}
