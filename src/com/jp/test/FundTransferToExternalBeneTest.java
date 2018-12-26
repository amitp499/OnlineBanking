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
public class FundTransferToExternalBeneTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testFundTransferToBene() {
		
		Transactions trn = new Transactions();
		BeneficiaryDetails bd = new BeneficiaryDetails();
		SavingsAccount acts;		
		
		try {
			
			acts = Ios.serachByAccountInAccounts(3549336);	
			trn.setAmount(100.00);
			trn.setBeneAccountNo(12354543);			
			trn.setTransactionInfo("Transfer Fund to Viral");
			trn.setTransactionType("Debit");
						
			if (trn.getTransactionType().equalsIgnoreCase("Debit")) {
				acts.getAccountBalance();
				trn.setBalance(acts.getAccountBalance()-trn.getAmount());
				acts.setAccountBalance(trn.getBalance());
			}
			
			trn.setAccounts(acts);
			assertTrue(Ios.addBalanceToAccounts(trn));
			assertTrue(Ios.updateBalanceInAccounts(acts));					
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		
	}

}