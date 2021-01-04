package com.retailBanking.accountsService.AccountRecordController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retailBanking.accountsService.AccountRecordService.AccountRecordService;
import com.retailBanking.accountsService.AccountTransactionController.AccountTransaction;
import com.retailBanking.accountsService.BusinessLogic.First5Accounts;
import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.Transaction;

@RestController
public class AccountRecordImpl implements AccountRecord {

	Double id;

	String type;

	long accountNo;

	List<AccountsModel> data = new ArrayList<AccountsModel>();

	@Autowired
	AccountRecordService service;

	@Autowired
	First5Accounts firstFiveAccount;

	@Autowired
	AccountTransaction accountTransaction;

	@Override
	@GetMapping("/accountsForHomePage")
	public List<AccountsModel> getaccountsForHomePage(@RequestParam(name = "id") Double id) {
		this.id = id;
		this.type = "savings";
		List<AccountsModel> getThreeAccounts = getAllAccountDetails(type, id).stream().limit(3)
				.collect(Collectors.toList());
		return getThreeAccounts;
	}

	@Override
	@GetMapping("/defaultAccount")
	public List<AccountsModel> getAllAccountDetails(@RequestParam(name = "type") String type,
			@RequestParam(name = "id") Double id) {
		System.out.println(id);
		this.id = id;
		this.type = type;
		List<AccountsModel> accountDetailslist = service.fetchAllAccountsByDefault(type, id);
		data = accountDetailslist;

		return firstFiveAccount.firstFiveAccounts(accountDetailslist);
	}

	@Override
	@GetMapping("/viewMore")
	public List<AccountsModel> getAccountDetailsByType() {
		List<AccountsModel> accountDetailsByTypeList = service.fetchAllAccountByViewMore(type, id);
		return accountDetailsByTypeList;
	}

	@Override
	public List<AccountsModel> getAllAccountsListforType(String type) {

		System.out.println(type);
		List<AccountsModel> data = service.getAllAccountsListforType(type, id);

		return firstFiveAccount.firstFiveAccounts(data);

	}

	@Override
	@PostMapping("/getSpecificAccount")
	public List<AccountsModel> getAccountDetailsByAccountNo(@RequestParam("accountno") String accNo) {

		accountNo = Long.parseLong(accNo);

		List<AccountsModel> accountDetailsByAccountNoList = service.getAccountDetailsByAccountNo(accountNo);
		return accountDetailsByAccountNoList;
	}

	@Override
	@GetMapping("/getCreditCardDetatils")
	public List<CreditCardModel> getCreditCardDetatils() {

		System.out.println(accountNo);
		List<CreditCardModel> creditCardData = new ArrayList<CreditCardModel>();
		try {
			creditCardData = service.getCreditCardDetatils(accountNo);
		} catch (Exception e) {
			// return "Please go to bank and apply for Credit Card";
			System.out.println("Please go to bank and apply for Credit Card");
		}
		return creditCardData;
	}

	@Override
	@PostMapping(value = "/getAccountTransactionData", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Transaction> getAccountTransactionData(@RequestParam("accNo") String accNo) {
		long accountNo = Long.parseLong(accNo);
		List<Transaction> transactionData = new ArrayList<Transaction>();
		try {
		transactionData	= accountTransaction.getTransactionByAccount(accountNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Opps no data found, if problem presists please raise a request to customer care");
		}
		
		return transactionData;

	}

}
