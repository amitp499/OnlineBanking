package com.jp.test;

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
import com.jp.entities.SavingsAccount;
import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class AddBalanaceToAccountTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testAddBalanceToAccounts() {
		
		Transactions trn = new Transactions();
		Accounts acts;		
		
		try {
			acts = Ios.serachByAccountInAccounts(3549777);			
			trn.setAmount(5000.00);
			trn.setBeneAccountNo(3549777);			
			trn.setTransactionInfo("Add Balance to Saving Acount");
			trn.setTransactionType("Credit");
			//trn.setTransactionDateTime(new Date());
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY");
			
			trn.setTransactionDateTime(format.format(new Date()));
			
			
			if (trn.getTransactionType().equalsIgnoreCase("Credit")) {
				acts.getAccountBalance();
				trn.setBalance(acts.getAccountBalance()+trn.getAmount());
				acts.setAccountBalance(trn.getBalance());
			}
			
			trn.setAccounts(acts);
			Ios.addBalanceToAccounts(trn);
			Ios.updateBalanceInAccounts(acts);
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
