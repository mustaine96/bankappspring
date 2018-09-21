package com.capgemini.bankapp.service;

import com.capgemini.bankapp.service.impl.LowBalanceException;

public interface BankAccountService {
	
	public double getBalance(long accountId);
	public double withdraw(long accountId, double amount) throws LowBalanceException;
	public double deopsit(long accountId, double amount);
	public boolean fundTransfer(long fromAccount, long toAccount, double balance)throws LowBalanceException;;
	double deposit(long accountId, double amount) throws LowBalanceException;

}
