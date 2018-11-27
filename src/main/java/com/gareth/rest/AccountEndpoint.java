package com.gareth.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gareth.persistence.domain.Account;
import com.gareth.service.AccountService;

@RequestMapping("/accounts")
@RestController
public class AccountEndpoint {
	@Autowired
	private AccountService service;

//	@GetMapping("/")
//	public Iterable<Account> getAllAccounts() {
//		return service.getAll();
//	}

	@GetMapping("getAccount/{ID}")
	public Optional<Account> getAccount(@PathVariable Long Id) {
		return service.get(Id);

	}

	@DeleteMapping("/deleteAccount/{ID}")
	public void deleteAccount(@PathVariable Long Id) {
		service.delete(Id);

	}

	@PostMapping("/addAccount")
	public Account addAccount(Account account) {
		return service.add(account);
	}

}
