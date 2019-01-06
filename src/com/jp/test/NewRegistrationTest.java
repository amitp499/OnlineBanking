package com.jp.test;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IEncyrptDecryptService;
import com.jp.services.IOnlineBankingEmailService;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class NewRegistrationTest {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Autowired
	@Qualifier("email_service")
	private IOnlineBankingEmailService Ioes;
	
	@Autowired
	@Qualifier("service_encrypt_decrypt")
	private IEncyrptDecryptService Ieds;
	
	
	
	@Test
	public void testNewRegistration() {
		
		
		CustomerMaster cm = new CustomerMaster();
		CustomerDetail cd = new CustomerDetail();
		
		try {
	
		cm.setRole("customer");
					
		cd.setCustomerAadharId(917254121L);
		cd.setCustomerAddress("Thane");
		cd.setCustomerBranch("Thane");
		cd.setCustomerCity("Thane");
		cd.setCustomerCountry("India");
		cd.setCustomerDOB("17-Sep-1987");
		cd.setCustomerEmail("amitp499@gmail.com");
		cd.setCustomerGender("Male");
		cd.setCustomerMobileNo(2181556499L);
		cd.setCustomerName("Amit");
		cd.setCustomerPanCard("BWMQP2861F");
		cd.setCustomerPhotoPath("sadsf");
		cd.setCustomerSignaturePath("jhkh");
		cd.setCustomerState("MH");
						
		String encryptedPassword = Ieds.encrypt(Ios.generatePassword(), cd.getCustomerAadharId().toString());

		cm.setCustPassword(encryptedPassword);
		
		cm.setCustomerdetail(cd);
		cd.setCustomermaster(cm);
						 					
		assertTrue(Ios.registerNewCustoer(cm));
		
		String decryptedPassword = Ieds.decrypt(cm.getCustPassword(), cd.getCustomerAadharId().toString());
			
		assertTrue(Ioes.sendCustomerRegistrationEmail(cd.getCustomerEmail(), cm.getLoginId(), decryptedPassword));
		
		} catch (OnlineBankingException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
