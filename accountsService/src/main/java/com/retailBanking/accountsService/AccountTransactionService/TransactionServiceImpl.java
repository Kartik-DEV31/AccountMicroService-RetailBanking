package com.retailBanking.accountsService.AccountTransactionService;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailBanking.accountsService.Models.TransactionMicroServiceModel;
import com.retailBanking.accountsService.Repository.TransactionServiceProxy;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionServiceProxy repo;

	@Override
	public List<TransactionMicroServiceModel> getTransactionByAccount(BigInteger accNo) {

		return null;
		// return repo.getTransactionByAccount(accNo);
	}

}
