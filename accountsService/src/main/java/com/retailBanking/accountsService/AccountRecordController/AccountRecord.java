package com.retailBanking.accountsService.AccountRecordController;

import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.TransactionMicroServiceModel;

public interface AccountRecord {

	

	List<AccountsModel> getAllAccountsListforType(String type);

	List<AccountsModel> getAllAccountDetails(String type, Double id);

	List<AccountsModel> getAccountDetailsByType();

	List<AccountsModel> getAccountDetailsByAccountNo(String accNo);

	List<CreditCardModel> getCreditCardDetatils();

	List<TransactionMicroServiceModel> getAccountTransactionData(String accNo);

	List<AccountsModel> getaccountsForHomePage(Double id);

}
