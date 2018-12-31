package com.jp.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.SavingsAccount;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class OpenNewSavingsAccountTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testOpenSavingsAccounts() {
		
		
		try {
			SavingsAccount sb = new SavingsAccount();		
			
			sb.setAccountBalance(0.00);
			sb.setCustomerDetail(Ios.serachUserIdCustomerMaster(3842925));
			assertTrue(Ios.openAccount(sb));
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
