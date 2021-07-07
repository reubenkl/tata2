package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.models.Account;
import com.cg.models.Pack;
import com.cg.repositories.IAccountRepository;

@Service
@Component
public class AccountService implements IAccountService{
	
	@Autowired
	IAccountRepository accountRepository;

	//this method will create the account
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account) ;
	}
	
	//this method will get the Account by Id
	@Override
	public Optional<Account> getByAccountId(Long accountId) {
		return accountRepository.findById(accountId);
	}
	
	//this method will update the Account using Id	
	@Override
	public Account updateAccount(Long accountId, Account account) {
		Account existingAccount = accountRepository.getById(accountId);
		BeanUtils.copyProperties(account, existingAccount, "accountId");
		return accountRepository.saveAndFlush(existingAccount);
	}

	//this method will delete the Account by Id
	@Override
	public void deleteByAccountId(Long accountId) {
		accountRepository.deleteById(accountId);
	}
	
	//this account will give the number of accounts between certain time periods
	@Override
	public int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate) {
		List<Account> accountList = accountRepository.countCreatedAccountsInPeriod(startDate, endDate);
		return accountList.size();
	}
//
//	@Override
//	public int countCreatedAccount(LocalDate startDate, LocalDate endDate) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int countAccount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void removePackForAccount(Account account, Pack pack) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

}
