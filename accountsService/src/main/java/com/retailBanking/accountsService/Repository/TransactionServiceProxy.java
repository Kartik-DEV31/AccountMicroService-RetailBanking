package com.retailBanking.accountsService.Repository;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.retailBanking.accountsService.Models.Transaction;

//@FeignClient(name="transaction-service")
//@RibbonClient(name="transaction-service")
@Repository
public interface TransactionServiceProxy{
	
	@GetMapping(value="account/{accountNo}",produces = { MediaType.APPLICATION_JSON_VALUE})
	List<Transaction> getTransactionByAccount(long accNo);


}
