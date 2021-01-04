package com.retailBanking.accountsService.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retailBanking.accountsService.Models.AccountsModel;

public interface AccountRepository extends JpaRepository<AccountsModel, Long> {

	@Query("select a from AccountsModel a where a.accountType = ?1 and a.userid=?2")
	List<AccountsModel> findByAccountType(String type , Double id);
	
	@Query("select a from AccountsModel a where a.accountType = ?1 and a.userid=?2")
	List<AccountsModel> fetchAllAccounts(String type, Double id);
	
	@Query("select a from AccountsModel a where a.accountNo=?1")
	List<AccountsModel> getAccountDetailsByAccountNo(long accountNo);

}
