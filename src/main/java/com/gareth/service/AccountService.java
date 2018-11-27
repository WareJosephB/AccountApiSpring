package com.gareth.service;

import java.util.Optional;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.repository.AccountRepository;

public interface AccountService {

	void setRepo(AccountRepository persist);

	Iterable<Account> getAll();

	Account add(Account account);

	void delete(Long id);

	Optional<Account> get(Long id);

}