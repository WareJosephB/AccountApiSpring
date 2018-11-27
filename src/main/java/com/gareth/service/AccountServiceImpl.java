package com.gareth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public void setRepo(AccountRepository persist) {
		this.accountRepo = persist;
	}

	@Override
	public Iterable<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account add(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public void delete(Long id) {
		accountRepo.deleteById(id);
	}

	@Override
	public Optional<Account> get(Long id) {
		return accountRepo.findById(id);
	}

}