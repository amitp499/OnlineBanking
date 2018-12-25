package com.jp.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.BeneficiaryDetails;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})

public class AddNewBeneficiaryTest {

	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testAdditionOfBeneficiary() {
		
		
		try {

			BeneficiaryDetails bd = new BeneficiaryDetails();
			bd.setBeneficiartName("Sunil");
			bd.setBeneficiaryAccountNo(354543);
			bd.setBeneficiaryIfscCode("HDFC4254");
			bd.setCustomerDetail(Ios.serachUserIdCustomerMaster(300));
			assertTrue(Ios.addNewBeneDetails(bd));
		} catch (OnlineBankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
