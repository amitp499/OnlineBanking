package com.jp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.daos.IOnlineBankingDao;
import com.jp.daos.OnlineBankingDaoImpl;
import com.jp.entity.CustomerMaster;
import com.jp.entity.CustomerDetail;
import com.jp.exceptions.OnlineBankingException;

@Controller
public class WebController {
	
	@Autowired
	@Qualifier("dao")
	private IOnlineBankingDao on;
	
	@RequestMapping("HomePage.in")
	public String displayHomePage(){
		
		System.out.println("entered");
		return "homePage";
	}
	
	@RequestMapping("CustomerRegistration.in")
	public String customerRegistration(){
		

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
		}
		return "homePage";
	}
}
