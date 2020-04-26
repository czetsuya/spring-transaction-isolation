package com.czetsuya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czetsuya.service.BookIsolationService;

@RestController
@RequestMapping("/bookIsolation")
public class BookIsolationController {

	@Autowired
	private BookIsolationService bookIsolationService;
	
	@GetMapping("/readUnCommited")
	public void readUnCommited() {
		bookIsolationService.readUnCommited();
	}

	@GetMapping("/readCommited")
	public void readCommited() {
		bookIsolationService.readCommited();
	}

	@GetMapping("/repeatableRead")
	public void repeatableRead() {
		bookIsolationService.repeatableRead();
	}

	@GetMapping("/isoSerializable")
	public void isoSerializable() {
		bookIsolationService.isoSerializable();
	}
}
