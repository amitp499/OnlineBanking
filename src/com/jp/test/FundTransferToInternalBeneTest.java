package com.jp.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.BeneficiaryDetails;
import com.jp.entities.SavingsAccount;
import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})

public class FundTransferToInternalBeneTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testFundTransferToBene() {
		
		///-----------------Debit------Amit-------------
		Transactions frmtrn = new Transactions();
		Transactions totrn = new Transactions();	
		SavingsAccount frmActs;		
		SavingsAccount toActs;
		
		try {
			
			frmActs = Ios.serachByAccountInAccounts(3549294);				
			frmtrn.setAmount(150.00);
			frmtrn.setBeneAccountNo(3549315);			
			frmtrn.setTransactionInfo("Debit Amits Account");
			frmtrn.setTransactionType("Debit");
						
			if (frmtrn.getTransactionType().equalsIgnoreCase("Debit")) {
				frmActs.getAccountBalance();
				frmtrn.setBalance(frmActs.getAccountBalance()-frmtrn.getAmount());
				frmActs.setAccountBalance(frmtrn.getBalance());
			}
			
			frmtrn.setAccounts(frmActs);
			assertTrue(Ios.addBalanceToAccounts(frmtrn));
			assertTrue(Ios.updateBalanceInAccounts(frmActs));		
			
			
			//--------------------------------------------------			
			toActs = Ios.serachByAccountInAccounts(3549315);	
			totrn.setAmount(150.00);
			totrn.setBeneAccountNo(3549294);			
			totrn.setTransactionInfo("Credit Rohits account");
			totrn.setTransactionType("Credit");
						
			if (totrn.getTransactionType().equalsIgnoreCase("Credit")) {
				toActs.getAccountBalance();
				totrn.setBalance(toActs.getAccountBalance()+totrn.getAmount());
				toActs.setAccountBalance(totrn.getBalance());
			}
			
			totrn.setAccounts(toActs);
			assertTrue(Ios.addBalanceToAccounts(totrn));
			assertTrue(Ios.updateBalanceInAccounts(toActs));	
			
			
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		
	}

}
