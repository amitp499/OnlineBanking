package com.jp.controllers;




import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jp.entities.Accounts;
import com.jp.entities.CustomerDetail;
import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IOnlineBankingService;

@RestController
public class WebController {
	
	@Autowired
	@Qualifier("service")
	private IOnlineBankingService ioS;
	
	@RequestMapping("HomePage.in")
	public String displayHomePage(){
				
		return "homePage";
	}
	
	
	@RequestMapping(value = "/viewAccountSummary/{accountNo}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Accounts customerRegistration(@PathVariable("accountNo") Integer accountNo){
		
		Accounts act=null;
		try {
			 act =   ioS.serachByAccountInAccounts(accountNo);
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return act;
	}
	
	@RequestMapping(value = "/viewCustomerProfile/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CustomerDetail viewCustomerProfile(@PathVariable("customerId") Integer customerId){
		
		CustomerDetail cd=null;
		try {
			 cd =   ioS.serachUserIdCustomerMaster(customerId);
			System.out.println(cd);
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return cd;
	}
	
	@RequestMapping(value = "/viewAccountStatement/{accountNo}/{fromDate}/{toDate}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Transactions> viewAccountStatement(@PathVariable("accountNo") Integer accountNo,@PathVariable("fromDate") String fromDate,@PathVariable("toDate") String toDate ){
		
		ArrayList<Transactions> tranList= null;
		
		try {
			
			  tranList = ioS.viewAccountStatement(accountNo, fromDate, toDate);
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return tranList;
		
	}
}
