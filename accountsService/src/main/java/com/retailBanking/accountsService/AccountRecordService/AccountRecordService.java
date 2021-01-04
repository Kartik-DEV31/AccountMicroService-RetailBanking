package com.retailBanking.accountsService.AccountRecordService;

import java.math.BigInteger;
import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;

public interface AccountRecordService {

	 List<AccountsModel> getAllAccountsListforType(String type, Double userId);

	

	List<AccountsModel> fetchAllAccountsByDefault(String type, Double id);



	List<AccountsModel> fetchAllAccountByViewMore(String type, Double id);



	List<AccountsModel> getAccountDetailsByAccountNo(long accountNo);



	List<CreditCardModel> getCreditCardDetatils(long accountNo) throws Exception;
	
}
