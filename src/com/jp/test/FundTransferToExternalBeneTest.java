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
public class FundTransferToExternalBeneTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testFundTransferToBene() {
		
		Transactions trn = new Transactions();
		BeneficiaryDetails bd = new BeneficiaryDetails();
		Accounts acts;		
		
		try {
			
			acts = Ios.serachByAccountInAccounts(3549294);	
			trn.setAmount(1200.00);
			trn.setBeneAccountNo(12354543);			
			trn.setTransactionInfo("Transfer Fund to Viral");
			trn.setTransactionType("Debit");
			
			//SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY");			
			//trn.setTransactionDateTime(format.format(new Date()));
			
			//trn.setTransactionDateTime(Calendar.getInstance());
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-YYYY 'T' HH:mm:ss");
			String currentDateXmlFormated1 =  sdf1.format(cal1.getTime());
			trn.setTransactionDateTime(currentDateXmlFormated1);
						
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
