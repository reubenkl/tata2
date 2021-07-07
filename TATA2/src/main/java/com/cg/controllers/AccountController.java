package com.cg.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.models.Account;
import com.cg.services.IAccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	IAccountService accountService;
	
	@GetMapping("get")
	public List<Account> getAccounts(){
		return accountService.getAll();
	}
	
	@GetMapping("{accountId}")
	public Account getByAccountId(@PathVariable Long accountId) {
		return accountService.getByAccountId(accountId);
	}
	
	@PostMapping("create")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@RequestMapping(value = "{accountId}", method = RequestMethod.PUT)
	public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
		return accountService.updateByAccountId(accountId, account);
	}
	
	@RequestMapping(value = "{accountId}", method = RequestMethod.DELETE)
	public void deleteAccount(@PathVariable Long accountId) {
		accountService.deleteByAccountId(accountId);
	}
	
	@GetMapping("getCount")
	public int countAccounts() {
		return accountService.countAccounts();
	}
	
	@GetMapping("dates")
	public int countCreatedAccountsInPeriod(@RequestParam("startDate") 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		int count = accountService.countCreatedAccountsInPeriod(startDate, endDate);
		return count;
	}
	
	@GetMapping("deletePack")
	public void removePackForAccount(@RequestParam("accountId") Long accountId, 
									@RequestParam("packId") Long packId) {
		accountService.removePackForAccount(accountId, packId);
	}
}
