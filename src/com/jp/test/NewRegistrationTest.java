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
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class NewRegistrationTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	
	@Test
	public void testNewRegistration() {
		
		CustomerMaster cm = new CustomerMaster();
		CustomerDetail cd = new CustomerDetail();
		
		
		cm.setCustPassword("abcd");
		cm.setRole("customer");
				
	
		cd.setCustomerAadharId(2980471);
		cd.setCustomerAddress("Mubai");
		cd.setCustomerBranch("Andheri");
		cd.setCustomerCity("Thane");
		cd.setCustomerCountry("India");
		cd.setCustomerDOB("17-Sep-1987");
		cd.setCustomerEmail("amitp@gail.co");
		cd.setCustomerGender("Male");
		cd.setCustomerMobileNo(8082295);
		cd.setCustomerName("Ait");
		cd.setCustomerPanCard("Q6532534");
		cd.setCustomerPhotoPath("sadsf");
		cd.setCustomerSignaturePath("jhkh");
		cd.setCustomerState("MH");
		
		
		cm.setCustomerdetail(cd);
		cd.setCustomermaster(cm);
		//System.out.println(cd);
		//System.out.println(cm);
		try {
			//Ios.registerNewCustoer(cm);
			assertTrue(Ios.registerNewCustoer(cm));
		} catch (OnlineBankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
