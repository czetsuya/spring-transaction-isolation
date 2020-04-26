package com.czetsuya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.czetsuya.data.Author;
import com.czetsuya.data.Book;
import com.czetsuya.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookManagerService {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookRepository bookRepository;

	public void createAuthorAndBook() {

		Author author = new Author();
		author.setFirstName("createAuthorAndBook");
		author.setLastName("createAuthorAndBook");
		authorService.create(author);

		Book book = new Book();
		book.setTitle("createAuthorAndBook");
		bookService.create(book);
	}

	@Transactional
	public void createAuthorAndBookWithRuntimeException() {

		Author author = new Author();
		author.setFirstName("createAuthorAndBookWithRuntimeException");
		author.setLastName("createAuthorAndBookWithRuntimeException");
		authorService.create(author);

		Book book = new Book();
		book.setTitle("createAuthorAndBookWithRuntimeException");
		bookService.create(book);

		throw new RuntimeException();
	}

	@Transactional
	public void createAuthorInNewTxThrowRuntimeExceptionOnBook() {

		Author author = new Author();
		author.setFirstName("createAuthorInNewTxThrowRuntimeExceptionOnBook");
		author.setLastName("createAuthorInNewTxThrowRuntimeExceptionOnBook");
		authorService.createInNewTx(author);

		Book book = new Book();
		book.setTitle("createAuthorInNewTxThrowRuntimeExceptionOnBook");
		bookService.create(book);

		throw new RuntimeException();
	}

	@Transactional
	public void createAuthorAndBookInNewTxThrowRuntimeException() {

		Author author = new Author();
		author.setFirstName("createAuthorInNewTxThrowRuntimeExceptionOnBook");
		author.setLastName("createAuthorInNewTxThrowRuntimeExceptionOnBook");
		authorService.createInNewTx(author);

		Book book = new Book();
		book.setTitle("createAuthorInNewTxThrowRuntimeExceptionOnBook");
		bookService.createInNewTx(book);

		throw new RuntimeException();
	}

	public Book insertAndFindInAnotherTransaction() {

		Book book = new Book();
		book.setTitle("insertAndFindInAnotherTransaction");
		bookService.createInNewTx(book);

		return bookRepository.findById(book.getId()).get();
	}

	public Book insertAndFindInDifferentTransaction() {

		Book book = new Book();
		book.setTitle("insertAndFindInDifferentTransaction");
		bookService.createInNewTx(book);

		return bookService.findInNewTransaction(book.getId());
	}

	@Transactional
	public void superLongTransaction() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
		authorService.superLongTransaction();
	}

	public void superLongTransaction2() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
	}

	@Transactional
	public void superLongTransactionWithRequiredTx() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
		authorService.superLongTransactionWithRequiredTx();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void superLongTransactionWithRequiredTx2() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
	}

	@Transactional
	public void superLongTransactionWithRequiredTxWithBlankRequired() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
		authorService.superLongTransactionWithRequiredTxWithBlankRequired();
	}

	@Transactional
	public void superLongTransactionWithRequiredTxWithBlankRequired2() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
	}

	@Transactional
	public void superLongTransactionWithRequiresNewTx() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
		authorService.superLongTransactionWithRequiresNewTx();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void superLongTransactionWithRequiresNewTx2() {
		log.debug("bm " + TransactionAspectSupport.currentTransactionStatus());
	}
}
