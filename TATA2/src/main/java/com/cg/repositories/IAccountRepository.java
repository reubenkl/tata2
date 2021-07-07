package com.cg.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.models.Account;
import com.cg.models.Pack;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long>{
	
	@Query(value = "SELECT * FROM Account account WHERE account.registered_date >= :startDate AND account.registered_date <= :endDate", nativeQuery = true)
	public List<Account> countCreatedAccountsInPeriod(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);
	
	
	//changed from add to addAccount
//	Account createAccount(Account account);

//    Account findByAccountId(Long accountId) ;
//
//    Account update(Account account);
    
//    List<Account> findAll();

//    void deleteByAccountId(Long accountId);
//
//    int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate);
//
//    //removed s in accounts
//    int countCreatedAccount(LocalDate startDate, LocalDate endDate);
//
//    /**
//     * finds count of accounts in the application
//     */
//  //removed s in accounts
//    int countAccount();
//
//    void removePackForAccount(Account account, Pack pack);

}
