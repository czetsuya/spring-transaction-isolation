package com.czetsuya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czetsuya.service.AuthorService;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping(path = "/throwExceptionWithTransaction")
	public void throwExceptionWithTransaction() throws Exception {
		authorService.throwExceptionWithTransaction();
	}
	
	@GetMapping(path = "/throwExceptionWithTransactionWithRollbackOn")
	public void throwExceptionWithTransactionWithRollbackOn() throws Exception {
		authorService.throwExceptionWithTransactionWithRollbackOn();
	}

	@GetMapping(path = "/throwRuntimeWithTransaction")
	public void throwRuntime() {
		authorService.throwRuntimeWithTransaction();
	}

	@GetMapping(path = "/throwExceptionWithoutTransaction")
	public void throwExceptionWithoutTransaction() throws Exception {
		authorService.throwExceptionWithoutTransaction();
	}

	@GetMapping(path = "/throwRuntimeWithoutTransaction")
	public void throwRuntimeWithoutTransaction() {
		authorService.throwRuntimeWithoutTransaction();
	}
}
