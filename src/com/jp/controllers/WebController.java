package com.jp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.daos.IOnlineBankingDao;
import com.jp.daos.OnlineBankingDaoImpl;
import com.jp.entity.CustomerDetails;
import com.jp.entity.CustomerMaster;

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
		

		CustomerDetails cd = new CustomerDetails();
		CustomerMaster cm = new CustomerMaster();
		
		cd.setCustomerDetailsId(1235);
		cd.setCustomerFullName("Ait");
		cd.setCustPassword("abcd");
		cd.setRole("customer");
		
		
		
		cm.setCustomerId(9817548);
		cm.setCustomerAadharId(1985471);
		cm.setCustomerAddress("Mubai");
		cm.setCustomerBranch("Andheri");
		cm.setCustomerCity("Thane");
		cm.setCustomerCountry("India");
		cm.setCustomerDOB("17-Sep-1987");
		cm.setCustomerEmail("amitp@gail.co");
		cm.setCustomerGender("Male");
		cm.setCustomerMobileNo(80825);
		cm.setCustomerName("Ait");
		cm.setCustomerPanCard("6532514");
		cm.setCustomerPhotoPath("sadsf");
		cm.setCustomerSignaturePath("jhkh");
		cm.setCustomerState("MH");
		
		cd.setCustomermaster(cm);
		cm.setCustomerdetails(cd);
		
		//on.addNewCustoer(cm);
		on.addNewCustoer(cd);
		return "homePage";
	}
}
