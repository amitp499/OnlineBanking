package com.jp.test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingEmailService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class EmailSendTest {
	
	@Autowired
	@Qualifier("email_service")
	private IOnlineBankingEmailService Ioes;
	
	@Test
	public void testSendEmail() {		
		try {						
			assertTrue(Ioes.sendCustomerRegistrationEmail("amitp499.com", 546325, "abcd124"));
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		
	}

}
