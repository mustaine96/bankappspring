package com.capgemini.bankapp.repository.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
	
	private HashSet<BankAccount> bankAccounts;
	public void customInit() {
		System.out.println("Repo INIT");
	}
	
	public void customDestroy() {
		System.out.println("Repo Destroy");
	}

	public BankAccountRepositoryImpl() {
		super();
		bankAccounts = new HashSet<>();
		bankAccounts.add(new BankAccount(1234, "John Doe", "SAVING", 34000));
		bankAccounts.add(new BankAccount(2373, "Jane Doe", "SAVING", 56000));
		bankAccounts.add(new BankAccount(3990, "Alex Browning", "CURRENT", 89000));
	}

	@Override
	public double getBalance(long accountId) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId() == accountId)
				return bankAccount.getAccountBalance();
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId() == accountId) {
				bankAccount.setAccountBalance(newBalance);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankAccount findBankAccountById(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> finAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount upadteBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBankAccount(long account) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
