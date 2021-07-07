package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.PackNotFoundException;
import com.cg.models.Account;
import com.cg.models.Pack;
import com.cg.repositories.IAccountRepository;

@Service
@Component
public class AccountService implements IAccountService{
	
	@Autowired
	IAccountRepository accountRepository;
	
	//this method will get all the accounts
	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	//this method will create the account
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account) ;
	}
	
	//this method will get the Account by Id
	@Override
	public Account getByAccountId(Long accountId) {
		Optional<Account> checkAccount = accountRepository.findById(accountId);
		if(!checkAccount.isPresent()) {
			throw new AccountNotFoundException();
		}
		return accountRepository.getById(accountId);
	}
	
	//this method will update the Account using Id	
	@Override
	public Account updateByAccountId(Long accountId, Account account) {
		Optional<Account> checkAccount = accountRepository.findById(accountId);
		if(!checkAccount.isPresent()) {
			throw new AccountNotFoundException();
		}
		Account existingAccount = accountRepository.getById(accountId);
		BeanUtils.copyProperties(account, existingAccount, "accountId");
		return accountRepository.saveAndFlush(existingAccount);
	}

	//this method will delete the Account by Id
	@Override
	public void deleteByAccountId(Long accountId) {
		Optional<Account> checkAccount = accountRepository.findById(accountId);
		if(!checkAccount.isPresent()) {
			throw new AccountNotFoundException();
		}
		accountRepository.deleteById(accountId);
	}
	
	//this account will give the number of accounts between certain time periods
	@Override
	public int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate) {
		List<Account> accountList = accountRepository.countCreatedAccountsInPeriod(startDate, endDate);
		return accountList.size();
	}

	//this method will get the count of all the accounts
	@Override
	public int countAccounts() {
		List<Account> accounts = accountRepository.findAll();
		int count = accounts.size();
		return count;
	}

	//this method will remove pack from an account
	@Override
	public void removePackForAccount(Long accountId, Long packId) {
		Optional<Account> checkAccount = accountRepository.findById(accountId);
		if(!checkAccount.isPresent()) {
			throw new AccountNotFoundException();
		}
		Account localAccount = accountRepository.getById(accountId);
		List<Pack> packs = localAccount.getPacks();
		boolean gotPack = false;
		for(Pack pack : packs) {
			if(pack.getPackId() == packId) {
				packs.remove(pack);
				gotPack = true;
				break;
			}
		}
		if(!gotPack) {
			throw new PackNotFoundException();
		}
		localAccount.setPacks(packs);
		accountRepository.saveAndFlush(localAccount);
	}


}
