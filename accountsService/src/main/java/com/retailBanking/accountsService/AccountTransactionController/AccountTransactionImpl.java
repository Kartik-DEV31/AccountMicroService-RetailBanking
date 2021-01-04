package com.retailBanking.accountsService.AccountTransactionController;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.retailBanking.accountsService.AccountTransactionService.TransactionService;
import com.retailBanking.accountsService.Models.Transaction;

@Controller
public class AccountTransactionImpl implements AccountTransaction {
	@Autowired
	TransactionService service;

	@Override
	public List<Transaction> getTransactionByAccount(long accNo) {
		List<Transaction> transaction = service.getTransactionByAccount(accNo);
		return transaction;
	}

}
