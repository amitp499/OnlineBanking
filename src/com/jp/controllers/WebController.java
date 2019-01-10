package com.jp.controllers;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.jp.entities.CustomerMaster;
import com.jp.entities.SavingsAccount;
import com.jp.entities.Transactions;
import com.jp.exceptions.OnlineBankingException;
import com.jp.services.IEncyrptDecryptService;
import com.jp.services.IOnlineBankingEmailService;
import com.jp.services.IOnlineBankingService;

@RestController
public class WebController {

	@Autowired
	@Qualifier("service")
	private IOnlineBankingService ioS;

	@Autowired
	@Qualifier("email_service")
	private IOnlineBankingEmailService Ioes;

	@Autowired
	@Qualifier("service_encrypt_decrypt")
	private IEncyrptDecryptService Ieds;

	@RequestMapping("HomePage.in")
	public String displayHomePage() {

		return "homePage";
	}

	// private Map<Integer,List<String>> session= new HashMap<>();

	@RequestMapping(value = "/viewAccountSummary/{accountNo}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Accounts customerRegistration(@PathVariable("accountNo") Integer accountNo) {

		Accounts act = null;
		try {
			// act = ioS.serachByAccountInAccounts(accountNo);
			act = ioS.serachByCustIdInAccounts(accountNo);

		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return act;
	}

	@RequestMapping(value = "/viewCustomerProfile/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CustomerDetail viewCustomerProfile(@PathVariable("customerId") Integer customerId) {

		CustomerDetail cd = null;
		try {
			cd = ioS.serachUserIdCustomerMaster(customerId);
			System.out.println(cd);
		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return cd;
	}

	@RequestMapping(value = "/viewAccountStatement/{accountNo}/{fromDate}/{toDate}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Transactions> viewAccountStatement(@PathVariable("accountNo") Integer accountNo,
			@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {

		ArrayList<Transactions> tranList = null;

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
			@PathVariable("beneActNo") Integer beneActNo, @PathVariable("beneIfscCode") String beneIfscCode,
			@PathVariable("custId") Integer custId) {

		boolean addBeneFlag = false;

		try {

			BeneficiaryDetails bd = new BeneficiaryDetails();
			bd.setBeneficiartName(beneName);
			bd.setBeneficiaryAccountNo(beneActNo);
			bd.setBeneficiaryIfscCode(beneIfscCode);
			bd.setCustomerDetail(ioS.serachUserIdCustomerMaster(custId));

			addBeneFlag = ioS.addNewBeneDetails(bd);

		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return addBeneFlag;

	}

	@RequestMapping(value = "/addNewCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean addNewCustomer(@RequestBody CustomerDetail cd) {

		boolean addCustomerFlag = false;
		boolean addNewCust = false;
		boolean sendEmail = false;
		System.out.println(cd);
		CustomerMaster cm = new CustomerMaster();

		try {

			if (cd != null) {

				cm.setRole("customer");
				cd.setCustomerSignaturePath("customerSignaturePath");
				cd.setCustomerPhotoPath("customerPhotoPath");
				System.out.println(cd);

				String encryptedPassword = Ieds.encrypt(ioS.generatePassword(), cd.getCustomerAadharId().toString());

				cm.setCustPassword(encryptedPassword);

				cm.setCustomerdetail(cd);
				cd.setCustomermaster(cm);

				addNewCust = ioS.registerNewCustoer(cm);

				String decryptedPassword = Ieds.decrypt(cm.getCustPassword(), cd.getCustomerAadharId().toString());

				sendEmail = Ioes.sendCustomerRegistrationEmail(cd.getCustomerEmail(), cm.getLoginId(),
						decryptedPassword);
			}

			if (addNewCust && sendEmail) {
				addCustomerFlag = true;
			}

		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}

		return addCustomerFlag;

	}

	@RequestMapping(value = "/addNewAccount/{accountType}/{customerId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean addNewAccount_Old(@PathVariable("accountType") String accountType,
			@PathVariable("customerId") Integer customerId) {

		boolean addAccountFlag = false;

		try {

			if (accountType != null || customerId != null) {

				Accounts sb = new SavingsAccount();

				sb.setAccountBalance(5000.00);
				sb.setCustomerDetail(ioS.serachUserIdCustomerMaster(customerId));

				addAccountFlag = ioS.openAccount(sb);
			}

		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return addAccountFlag;

	}

	@RequestMapping(value = "/fundTransfer/{custAcctNo}/{trAmount}/{trComments}/{beneActNo}", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean fundTransferInternalBene(@PathVariable("custAcctNo") Integer custAcctNo,
			@PathVariable("trAmount") Double trAmount, @PathVariable("trComments") String trComments,
			@PathVariable("beneActNo") Integer beneActNo) {

		boolean frmBalUpdate = false;
		boolean frmAddBal = false;
		boolean frmTrnSuccess = true;

		boolean toBalUpdate = true;
		boolean toAddBal = true;
		boolean toTrnSuccess = true;

		boolean TrnSuccess = false;

		Transactions frmtrn = new Transactions();
		Transactions totrn = new Transactions();
		BeneficiaryDetails beneD = null;
		Accounts frmActs;
		Accounts toActs;

		try {

			beneD = ioS.serachByBeneAccount(beneActNo);
			//System.out.println(beneD);
			
			frmActs = ioS.serachByAccountInAccounts(custAcctNo);
			//System.out.println(frmActs);

			if (beneD !=null && frmActs!=null) {
																						
				if (frmActs.getAccountBalance() > trAmount) {

				

					frmtrn.setAmount(trAmount);
					frmtrn.setBeneAccountNo(beneActNo); // account to credit
					frmtrn.setTransactionInfo(trComments);
					frmtrn.setTransactionType("Debit");
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY 'T' HH:mm:ss");
					String currentDateXmlFormated = sdf.format(cal.getTime());
					frmtrn.setTransactionDateTime(currentDateXmlFormated);

					if (frmtrn.getTransactionType().equalsIgnoreCase("Debit")) {
						frmActs.getAccountBalance();
						frmtrn.setBalance(frmActs.getAccountBalance() - frmtrn.getAmount());
						frmActs.setAccountBalance(frmtrn.getBalance());
					}

					frmtrn.setAccounts(frmActs);
					frmAddBal = ioS.addBalanceToAccounts(frmtrn);
					frmBalUpdate = ioS.updateBalanceInAccounts(frmActs);

				
			
			if (frmAddBal == false || frmBalUpdate == false) {
				frmTrnSuccess = false;
			}

			// --------------------------------------------------

			if (beneD.getBeneficiaryIfscCode().substring(0, 3).equalsIgnoreCase("ONB") && frmTrnSuccess) {

				toActs = ioS.serachByAccountInAccounts(beneActNo); // account to
																	// credit
				totrn.setAmount(trAmount);
				totrn.setBeneAccountNo(custAcctNo); // account debitted
				totrn.setTransactionInfo("Credit to " + toActs.getCustomerDetail().getCustomerName());
				totrn.setTransactionType("Credit");
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-YYYY 'T' HH:mm:ss");
				String currentDateXmlFormated1 = sdf1.format(cal1.getTime());
				totrn.setTransactionDateTime(currentDateXmlFormated1);

				if (totrn.getTransactionType().equalsIgnoreCase("Credit")) {
					toActs.getAccountBalance();
					totrn.setBalance(toActs.getAccountBalance() + totrn.getAmount());
					toActs.setAccountBalance(totrn.getBalance());
				}

				totrn.setAccounts(toActs);
				toAddBal = ioS.addBalanceToAccounts(totrn);
				toBalUpdate = ioS.updateBalanceInAccounts(toActs);

			}

			if (toAddBal == false || toBalUpdate == false) {
				toTrnSuccess = false;
			}

			if (toTrnSuccess == true && frmTrnSuccess == true) {
				TrnSuccess = true;
			}
			
			}
				
		}

		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return TrnSuccess;

	}

	@RequestMapping(value = "/viewBeneficiary/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<BeneficiaryDetails> viewBeneficiary(@PathVariable("customerId") Integer customerId) {

		ArrayList<BeneficiaryDetails> beneList = null;

		try {

			beneList = ioS.getBeneficiaryListByCustomerId(customerId);

		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return beneList;

	}

	@RequestMapping(value = "/login/{loginId}/{custPassword}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int login(@PathVariable("loginId") Integer id, @PathVariable("custPassword") String pwd) {
		int custId = -1;

		CustomerMaster cust = null;
		try {
			custId = ioS.doLogin(id, pwd);
			// session.put(custId, new ArrayList<String>());
		} catch (OnlineBankingException e) {

			e.printStackTrace();
		}
		return custId;
	}

}
