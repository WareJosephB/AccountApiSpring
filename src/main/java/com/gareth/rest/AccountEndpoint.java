package com.gareth.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gareth.persistence.domain.Account;
import com.gareth.service.AccountService;

@RequestMapping("/accounts")
@RestController
public class AccountEndpoint {
	@Autowired
	private AccountService service;

	@GetMapping("/")
	public Iterable<Account> getAllAccounts() {
		return service.getAll();
	}

	@GetMapping("getAccount/{ID}")
	public Optional<Account> getAccount(@PathVariable Long ID) {
		return service.get(ID);
	}

	@DeleteMapping("/deleteAccount/{ID}")
	public void deleteAccount(@PathVariable Long ID) {
		service.delete(ID);
	}

	@PostMapping("/addAccount")
	public Account addAccount(@RequestBody Account account) {
		System.out.println(account);
		return service.add(account);
	}

}
