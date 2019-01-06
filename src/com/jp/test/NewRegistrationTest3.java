package com.jp.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingEmailService;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class NewRegistrationTest3 {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	

	@Autowired
	@Qualifier("email_service")
	private IOnlineBankingEmailService Ioes;
	
	
	@Test
	public void testNewRegistration() {
		
		CustomerMaster cm = new CustomerMaster();
		CustomerDetail cd = new CustomerDetail();
				
		cm.setCustPassword("xyze");
		cm.setRole("customer");
					
		cd.setCustomerAadharId(8072132L);
		cd.setCustomerAddress("Andheri");
		cd.setCustomerBranch("Andheri");
		cd.setCustomerCity("Mumbai");
		cd.setCustomerCountry("India");
		cd.setCustomerDOB("17-Sep-1980");
		cd.setCustomerEmail("rdurai81@gmail.com");
		cd.setCustomerGender("Male");
		cd.setCustomerMobileNo(9161046L);
		cd.setCustomerName("Rohit Durai");
		cd.setCustomerPanCard("AA514129");
		cd.setCustomerPhotoPath("sadsf");
		cd.setCustomerSignaturePath("jhkh");
		cd.setCustomerState("MH");
				
		cm.setCustomerdetail(cd);
		cd.setCustomermaster(cm);
	
		try {
			
			assertTrue(Ios.registerNewCustoer(cm));
			assertTrue(Ioes.sendCustomerRegistrationEmail(cd.getCustomerEmail(), cm.getLoginId(), cm.getCustPassword()));
		} catch (OnlineBankingException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	

}
