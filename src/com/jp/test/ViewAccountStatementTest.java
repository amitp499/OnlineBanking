package com.jp.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:WebContent/WEB-INF/spring.xml", "file:WebContent/WEB-INF/springWebCust.xml"})
public class ViewAccountStatementTest {

	@Autowired
	@Qualifier("service")
	private IOnlineBankingService Ios;
	
	@Test
	public void testViewAccountStatement() {
		
		ArrayList<Transactions> tranList;
		try {
			tranList = Ios.viewAccountStatement(3549777, "29-Dec-2018", "29-Dec-2018");
			assertNotNull(tranList);
		} catch (OnlineBankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
