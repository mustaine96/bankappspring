package com.capgemini.bankapp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.LowBalanceException;

@Controller
public class BankAccountController {
	
	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}

	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}

	private BankAccountService bankAccountService;
	
	
	
	
	
//	public void setBankAccountService(BankAccountService bankAccountService) {
//		this.bankAccountService=bankAccountService;
//	}
	

	public double getBalance(long accountId) {
		return bankAccountService.getBalance(accountId);
	}
	
	public double withdraw(long accountId, double amount)throws LowBalanceException{
		return bankAccountService.withdraw(accountId, amount);
	}
	public double deposit(long accountId, double amount) throws LowBalanceException {
		return bankAccountService.deposit(accountId, amount);
	}
	//@Autowired
	public BankAccountController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amount)throws LowBalanceException{
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount);
	}
	@PostConstruct
		public void customInit() {
		System.out.println("AccountController init method initialised");
	}
	@PreDestroy
	public void customDestroy() {
		System.out.println("AccountController destroy method initialised");
	}

}
