package com.jp.test;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.Accounts;
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
		Accounts frmActs;		
		Accounts toActs;
		
		try {
			
			frmActs = Ios.serachByAccountInAccounts(3549294);		//account to debit		
			frmtrn.setAmount(750.00);
			frmtrn.setBeneAccountNo(3549315);			//account to credit
			frmtrn.setTransactionInfo("Debit Rohits Account");
			frmtrn.setTransactionType("Debit");
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY");			
			frmtrn.setTransactionDateTime(format.format(new Date()));
			//frmtrn.setTransactionDateTime(Calendar.getInstance());
						
			if (frmtrn.getTransactionType().equalsIgnoreCase("Debit")) {
				frmActs.getAccountBalance();
				frmtrn.setBalance(frmActs.getAccountBalance()-frmtrn.getAmount());
				frmActs.setAccountBalance(frmtrn.getBalance());
			}
			
			frmtrn.setAccounts(frmActs);
			assertTrue(Ios.addBalanceToAccounts(frmtrn));
			assertTrue(Ios.updateBalanceInAccounts(frmActs));		
			
			
			//--------------------------------------------------			
			toActs = Ios.serachByAccountInAccounts(3549315);	//account to credit
			totrn.setAmount(750.00);
			totrn.setBeneAccountNo(3549294);			//account debitted
			totrn.setTransactionInfo("Credit Amit account");
			totrn.setTransactionType("Credit");
			SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-YYYY");			
			totrn.setTransactionDateTime(format1.format(new Date()));
			//totrn.setTransactionDateTime(Calendar.getInstance());
						
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
