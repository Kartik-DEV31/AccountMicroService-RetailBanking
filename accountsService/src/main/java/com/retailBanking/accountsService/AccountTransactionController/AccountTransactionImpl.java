package com.retailBanking.accountsService.AccountTransactionController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.retailBanking.accountsService.Exceptions.ExceptionImpl;
import com.retailBanking.accountsService.Models.Transaction;
import com.retailBanking.accountsService.Repository.TransactionServiceProxy;

@RestController
public class AccountTransactionImpl implements AccountTransaction {
	@Autowired
	TransactionServiceProxy repo;
	
	@Autowired
	ExceptionImpl exception;

	
	@Autowired

	@Override
	public List<Transaction> getTransactionByAccount(long accNo) throws Exception {
		List<Transaction> transaction = repo.getTransactionByAccount(accNo);
		
		if (transaction.isEmpty())
				exception.noTransactionFound();
			
		return transaction;
	}

}
