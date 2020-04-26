package com.czetsuya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czetsuya.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/insertAndFindWithoutTransaction")
	public ResponseEntity insertAndFindWithoutTransaction() {
		return new ResponseEntity(bookService.insertAndFindWithoutTransaction(), HttpStatus.OK);
	}

	@GetMapping("/insertAndFindWithTransaction")
	public ResponseEntity insertAndFindWithTransaction() {
		return new ResponseEntity(bookService.insertAndFindWithTransaction(), HttpStatus.OK);
	}
}
