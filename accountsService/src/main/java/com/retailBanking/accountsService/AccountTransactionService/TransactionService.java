package com.retailBanking.accountsService.AccountTransactionService;

import java.math.BigInteger;
import java.util.List;

import com.retailBanking.accountsService.Models.TransactionMicroServiceModel;

public interface TransactionService {

	List<TransactionMicroServiceModel> getTransactionByAccount(BigInteger accNo);
	
	

}
