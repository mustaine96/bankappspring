package com.capgemini.bankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapp.repository.BankAccountRepository;
import com.capgemini.bankapp.service.BankAccountService;
@Service
public class BankAccountServiceImpl implements BankAccountService {
	private BankAccountRepository bankAccountRepository;
	
@Autowired
public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
		super();
		this.bankAccountRepository = bankAccountRepository;
	}

//	public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
//		this.bankAccountRepository = bankAccountRepository;
//	}

	public BankAccountRepository getBankAccountRepository() {
	return bankAccountRepository;
}

public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
	this.bankAccountRepository = bankAccountRepository;
}

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException {
		double balance = bankAccountRepository.getBalance(accountId);
		if(balance != -1) {
			if(balance - amount >= 0) {
				bankAccountRepository.updateBalance(accountId, balance - amount);
				return bankAccountRepository.getBalance(accountId);
			}		
		}
		return balance;
	}

	@Override
	public double deposit(long accountId, double amount) throws LowBalanceException {
		double balance = bankAccountRepository.getBalance(accountId);
		if(balance != -1) {
			bankAccountRepository.updateBalance(accountId, balance + amount);
			return bankAccountRepository.getBalance(accountId);
		}else
			throw new LowBalanceException("You don't have sufficient fund.");
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		double balance = withdraw(fromAccount, amount);
		if(balance != -1)
			deposit(toAccount, amount);
		return true;
	}

	@Override
	public double deopsit(long accountId, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
