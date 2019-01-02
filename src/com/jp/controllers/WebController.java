package com.jp.controllers;




import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jp.entities.Accounts;
import com.jp.entities.BeneficiaryDetails;
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
			  System.out.println(tranList);
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return tranList;
		
	}
	
	@RequestMapping(value = "/addNewBeneficiary/{beneName}/{beneActNo}/{beneIfscCode}/{custId}", method = RequestMethod.POST, headers = "Accept=application/json")		
	public boolean addNewBeneficiary(@PathVariable("beneName") String beneName, 
			@PathVariable("beneActNo") Integer beneActNo,
			@PathVariable("beneIfscCode") String beneIfscCode,
			@PathVariable("custId") Integer custId
			){
						
		boolean addBeneFlag=false;
		
		try {
												
			BeneficiaryDetails bd = new BeneficiaryDetails();
			bd.setBeneficiartName(beneName);
			bd.setBeneficiaryAccountNo(beneActNo);
			bd.setBeneficiaryIfscCode(beneIfscCode);
			bd.setCustomerDetail(ioS.serachUserIdCustomerMaster(custId));
			
			
			addBeneFlag=ioS.addNewBeneDetails(bd);
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return addBeneFlag;
		
	}
	
	@RequestMapping(value = "/fundTransfer/{custAcctNo}/{trAmount}/{trComments}/{beneActNo}", method = RequestMethod.POST, headers = "Accept=application/json")		
	public boolean fundTransferInternalBene(@PathVariable("custAcctNo") Integer custAcctNo, 
			@PathVariable("trAmount") Double trAmount,
			@PathVariable("trComments") String trComments,
			@PathVariable("beneActNo") Integer beneActNo
			){
					
		boolean frmBalUpdate=false;
		boolean frmAddBal=false;
		boolean frmTrnSuccess=true;
		
		boolean toBalUpdate=false;
		boolean toAddBal=false;
		boolean toTrnSuccess=true;
		
		boolean TrnSuccess=false;
		
		
		Transactions frmtrn = new Transactions();
		Transactions totrn = new Transactions();	
		BeneficiaryDetails beneD = null;
		Accounts frmActs;		
		Accounts toActs;				
		
		try {
			
		
			 beneD = ioS.serachByBeneAccount(beneActNo);
			 
			
			if (beneD!=null){
				
			
			frmActs = ioS.serachByAccountInAccounts(custAcctNo);		//account to debit		
			
			frmtrn.setAmount(trAmount);
			frmtrn.setBeneAccountNo(beneActNo);			//account to credit
			frmtrn.setTransactionInfo(trComments);
			frmtrn.setTransactionType("Debit");
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY");			
			frmtrn.setTransactionDateTime(format.format(new Date()));
			//frmtrn.setTransactionDateTime(Calendar.getInstance());
						
			if (frmtrn.getTransactionType().equalsIgnoreCase("Debit")) {
				frmActs.getAccountBalance();
				frmtrn.setBalance(frmActs.getAccountBalance()-frmtrn.getAmount());
				frmActs.setAccountBalance(frmtrn.getBalance());
			}
			
			frmtrn.setAccounts(frmActs);
			frmAddBal = ioS.addBalanceToAccounts(frmtrn);
			frmBalUpdate = ioS.updateBalanceInAccounts(frmActs);
			
			}
			if (frmAddBal==false || frmBalUpdate==false ){
				frmTrnSuccess=false;
			}
			
			
						
			
			
			//--------------------------------------------------		
			if (beneD.getBeneficiaryIfscCode().substring(0, 3).equalsIgnoreCase("ONB") && frmTrnSuccess ){
				
				toActs = ioS.serachByAccountInAccounts(beneActNo);	//account to credit
				totrn.setAmount(trAmount);
				totrn.setBeneAccountNo(custAcctNo);			//account debitted
				totrn.setTransactionInfo("Credit to "+toActs.getCustomerDetail().getCustomerName());
				totrn.setTransactionType("Credit");
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-YYYY");			
				totrn.setTransactionDateTime(format1.format(new Date()));

							
				if (totrn.getTransactionType().equalsIgnoreCase("Credit")) {
					toActs.getAccountBalance();
					totrn.setBalance(toActs.getAccountBalance()+totrn.getAmount());
					toActs.setAccountBalance(totrn.getBalance());
				}
				
				totrn.setAccounts(toActs);
				toAddBal = ioS.addBalanceToAccounts(totrn);
				toBalUpdate = ioS.updateBalanceInAccounts(toActs);
				 
			 }
			
			
			if (toAddBal==false || toBalUpdate==false){
				toTrnSuccess=false;
			}
			
			if (toTrnSuccess==true && frmTrnSuccess==true){
				TrnSuccess=true;
			}
			
			
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return TrnSuccess;
		
	}
	
	@RequestMapping(value = "/viewBeneficiary/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<BeneficiaryDetails> viewBeneficiary(@PathVariable("customerId") Integer customerId){
		
		ArrayList<BeneficiaryDetails> beneList= null;
		
		try {
			
			beneList = ioS.getBeneficiaryListByCustomerId(customerId);
			
		} catch (OnlineBankingException e) {
			
			e.printStackTrace();
		}
		return beneList;
		
	}
}
