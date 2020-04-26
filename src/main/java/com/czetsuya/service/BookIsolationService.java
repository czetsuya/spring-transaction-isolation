package com.czetsuya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.czetsuya.data.Book;

@Service
public class BookIsolationService {

	@Autowired
	private BookService bookService;

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void readUnCommited() {

		System.out.println();
		System.out.println("readUnCommited " + TransactionAspectSupport.currentTransactionStatus());
		dirtyReads();
		nonRepeatableReads();
		phantomReads();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void readCommited() {

		System.out.println();
		System.out.println("readCommited " + TransactionAspectSupport.currentTransactionStatus());
		dirtyReads();
		nonRepeatableReads();
		phantomReads();
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void repeatableRead() {

		System.out.println();
		System.out.println("repeatableRead " + TransactionAspectSupport.currentTransactionStatus());
		dirtyReads();
		nonRepeatableReads();
		phantomReads();
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void isoSerializable() {

		System.out.println();
		System.out.println("isoSerializable " + TransactionAspectSupport.currentTransactionStatus());
		dirtyReads();
		nonRepeatableReads();
		phantomReads();
	}

	private void dirtyReads() {

		System.out.println("\r\ndirtyReads " + TransactionAspectSupport.currentTransactionStatus());
		Book book = new Book();
		book.setTitle("readUnCommited");
		bookService.create(book);

		System.out.println("dirtyReads " + bookService.findByIdInNewTx(book.getId()));
	}

	private void nonRepeatableReads() {

		System.out.println("\r\nnonRepeatableReads " + TransactionAspectSupport.currentTransactionStatus());
		Book book = new Book();
		book.setTitle("nonRepeatableReads");
		bookService.createInNewTx(book);

		System.out.println("nonRepeatableReads " + bookService.findByIdInNewTx(book.getId()));

		book.setTitle("nonRepeatableReads-Updated");

		System.out.println("nonRepeatableReads " + bookService.findByIdInNewTx(book.getId()));
	}

	private void phantomReads() {

		System.out.println("\r\nphantomReads " + TransactionAspectSupport.currentTransactionStatus());
		Book book = new Book();
		book.setTitle("phantomReads1");
		bookService.createInNewTx(book);

		System.out.println("phantomReads " + bookService.findAllInNewTx());

		book = new Book();
		book.setTitle("phantomReads2");
		bookService.createInNewTx(book);

		System.out.println("phantomReads " + bookService.findAllInNewTx());
	}
}
