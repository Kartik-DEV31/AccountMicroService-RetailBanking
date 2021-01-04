package com.retailBanking.accountsService.AccountRecordService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailBanking.accountsService.Exceptions.ExceptionImpl;
import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Repository.CreditCardRepository;
import com.retailBanking.accountsService.Repository.AccountRepository;

@Service
public class AccountRecordServiceImpl implements AccountRecordService {
	@Autowired
	AccountRepository repo;

	@Autowired
	CreditCardRepository crepo;

	@Autowired
	ExceptionImpl exception;

	public List<AccountsModel> getAllAccountsListforType(String type, Double userId) {

		List<AccountsModel> data = repo.findByAccountType(type, userId).stream()
				.sorted((balance1, balance2) -> balance2.getAccountBalance().compareTo(balance1.getAccountBalance()))
				.collect(Collectors.toList());

		return data;
	}

	@Override
	public List<AccountsModel> fetchAllAccountsByDefault(String type, Double id) {

		List<AccountsModel> data = repo.fetchAllAccounts(type, id).stream()
				.sorted((balance1, balance2) -> balance2.getAccountBalance().compareTo(balance1.getAccountBalance()))
				.collect(Collectors.toList());

		return data;

	}

	@Override
	public List<AccountsModel> fetchAllAccountByViewMore(String type, Double id) {
		List<AccountsModel> data = repo.fetchAllAccounts(type, id).stream()
				.sorted((balance1, balance2) -> balance2.getAccountBalance().compareTo(balance1.getAccountBalance()))
				.collect(Collectors.toList());

		return data;
	}

	@Override
	public List<AccountsModel> getAccountDetailsByAccountNo(long accountNo) {

		List<AccountsModel> data = repo.getAccountDetailsByAccountNo(accountNo);

		return data;
	}

	@Override
	public List<CreditCardModel> getCreditCardDetatils(long accountNo) throws Exception {
		List<CreditCardModel> data = crepo.getCreditCardDetatils(accountNo);
		System.out.println("Credit");
		if (data.isEmpty())
			exception.noCreditCardFound();

		return data;
	}

}
