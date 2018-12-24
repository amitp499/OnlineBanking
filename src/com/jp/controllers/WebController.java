package com.jp.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.daos.IOnlineBankingDao;
import com.jp.daos.OnlineBankingDaoImpl;
import com.jp.entities.Accounts;
import com.jp.entities.CreditCardAccount;
import com.jp.entities.CustomerDetail;
import com.jp.entities.CustomerMaster;
import com.jp.entities.SavingsAccount;
import com.jp.exceptions.OnlineBankingException;

@Controller
public class WebController {
	
	@Autowired
	@Qualifier("dao")
	private IOnlineBankingDao on;
	
	@RequestMapping("HomePage.in")
	public String displayHomePage(){
		
		//System.out.println("entered");
		return "homePage";
	}
	
	@RequestMapping("CustomerRegistration.in")
	public String customerRegistration(){
		
		/*
		try {
			
		//Add Savings Account
		SavingsAccount sb = new SavingsAccount();		
					
		sb.setAccountBalance(500.00);
		sb.setAccountId(545453343);
		sb.setCustomerMaster(on.serachUserIdCustomerMaster(12345));				
		on.addAccount(sb);
			
			
			//Add Savings Account		
		CreditCardAccount cca = new CreditCardAccount();
		cca.setAccountBalance(1500.00);
		cca.setAccountId(23454534);
		cca.setCustomerMaster(on.serachUserIdCustomerMaster(12345));				
		on.addAccount(cca);
		
		} catch (OnlineBankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
	//New Registration 
		/*
		CustomerMaster cm = new CustomerMaster();
		CustomerDetail cd = new CustomerDetail();
		
		cm.setUserId(123456);
		
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
		
		
		
		
		
		
		return "homePage";
	}
}
