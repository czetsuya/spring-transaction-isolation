package com.czetsuya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czetsuya.service.BookManagerService;

@RestController
@RequestMapping(path = "/bookManager")
public class BookManagerController {

	@Autowired
	private BookManagerService bookManagerService;

	@GetMapping(path = "/createAuthorAndBook")
	public void createAuthorAndBook() {
		bookManagerService.createAuthorAndBook();
	}

	@GetMapping(path = "/createAuthorAndBookWithRuntimeException")
	public void createAuthorAndBookWithRuntimeException() {
		bookManagerService.createAuthorAndBookWithRuntimeException();
	}

	@GetMapping(path = "/createAuthorInNewTxThrowRuntimeExceptionOnBook")
	public void createAuthorInNewTxThrowRuntimeExceptionOnBook() {
		bookManagerService.createAuthorInNewTxThrowRuntimeExceptionOnBook();
	}

	@GetMapping(path = "/createAuthorAndBookInNewTxThrowRuntimeException")
	public void createAuthorAndBookInNewTxThrowRuntimeException() {
		bookManagerService.createAuthorAndBookInNewTxThrowRuntimeException();
	}

	@GetMapping(path = "/insertAndFindInAnotherTransaction")
	public ResponseEntity insertAndFindInAnotherTransaction() {
		return new ResponseEntity(bookManagerService.insertAndFindInAnotherTransaction(), HttpStatus.OK);
	}

	@GetMapping(path = "/insertAndFindInDifferentTransaction")
	public ResponseEntity insertAndFindInDifferentTransaction() {
		return new ResponseEntity(bookManagerService.insertAndFindInDifferentTransaction(), HttpStatus.OK);
	}

	@GetMapping(path = "/superLongTransaction")
	public void superLongTransaction() {
		bookManagerService.superLongTransaction();
	}

	@GetMapping(path = "/superLongTransactionWithRequiredTx")
	public void superLongTransactionWithRequiredTx() {
		bookManagerService.superLongTransactionWithRequiredTx();
	}

	@GetMapping(path = "/superLongTransactionWithRequiredTxWithBlankRequired")
	public void superLongTransactionWithRequiredTxWithBlankRequired() {
		bookManagerService.superLongTransactionWithRequiredTxWithBlankRequired();
	}

	@GetMapping(path = "/superLongTransactionWithRequiresNewTx")
	public void superLongTransactionWithRequiresNewTx() {
		bookManagerService.superLongTransactionWithRequiresNewTx();
	}
}
