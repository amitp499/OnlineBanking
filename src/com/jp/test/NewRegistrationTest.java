package com.jp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/spring.xml")
public class NewRegistrationTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	
	@Test
	public void testNewRegistration() {
		
		CustomerMaster cm = new CustomerMaster();
		CustomerDetail cd = new CustomerDetail();
		
		cm.setLoginId(123456);
		
		cm.setCustPassword("abcd");
		cm.setRole("customer");
				
		cd.setCustomerId(9817548);
		cd.setCustomerAadharId(1985471);
		cd.setCustomerAddress("Mubai");
		cd.setCustomerBranch("Andheri");
		cd.setCustomerCity("Thane");
		cd.setCustomerCountry("India");
		cd.setCustomerDOB("17-Sep-1987");
		cd.setCustomerEmail("amitp@gail.co");
		cd.setCustomerGender("Male");
		cd.setCustomerMobileNo(80825);
		cd.setCustomerName("Ait");
		cd.setCustomerPanCard("6532514");
		cd.setCustomerPhotoPath("sadsf");
		cd.setCustomerSignaturePath("jhkh");
		cd.setCustomerState("MH");
		
		
		cm.setCustomermaster(cd);
		cd.setCustomerdetails(cm);
		
		try {
			on.addNewCustoer(cm);
		} catch (OnlineBankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	

}
