package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.exceptions.AccountNotFoundException;
import com.cg.models.Account;
import com.cg.models.Pack;

@Service
public interface IAccountService {
	
	//changed from add to addAccount
	Account createAccount(Account account);
	
	List<Account> getAll();

    Account getByAccountId(Long accountId);

    Account updateByAccountId(Long accountId, Account account);
    
    void deleteByAccountId(Long accountId);
    
    int countAccounts();

    int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate);


    void removePackForAccount(Long accountId, Long packId);
}
