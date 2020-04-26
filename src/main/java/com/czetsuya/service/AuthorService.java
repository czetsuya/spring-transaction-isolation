package com.czetsuya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.czetsuya.data.Author;
import com.czetsuya.repository.AuthorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookService bookService;

	@Transactional
	public void throwExceptionWithTransaction() throws Exception {

		Author author = new Author();
		author.setFirstName("Exception with Transaction");
		author.setLastName("Exception with Transaction");
		authorRepository.save(author);

		throw new Exception("Exception with Transaction");
	}

	@Transactional(rollbackFor = { Exception.class })
	public void throwExceptionWithTransactionWithRollbackOn() throws Exception {

		Author author = new Author();
		author.setFirstName("Exception with Transaction with Rollback On");
		author.setLastName("Exception with Transaction with Rollback On");
		authorRepository.save(author);

		throw new Exception("Exception with Transaction with RollbackOn");
	}

	@Transactional
	public void throwRuntimeWithTransaction() {

		Author author = new Author();
		author.setFirstName("Runtime with Transaction");
		author.setLastName("Runtime with Transaction");
		authorRepository.save(author);

		throw new RuntimeException("Runtime with Transaction");
	}

	public void throwExceptionWithoutTransaction() throws Exception {

		Author author = new Author();
		author.setFirstName("Exception without Transaction");
		author.setLastName("Exception without Transaction");
		authorRepository.save(author);

		throw new Exception("Exception without Transaction");
	}

	public void throwRuntimeWithoutTransaction() {

		Author author = new Author();
		author.setFirstName("Runtime without Transaction");
		author.setLastName("Runtime without Transaction");
		authorRepository.save(author);

		throw new RuntimeException("Runtime without Transaction");
	}

	public void create(Author author) {
		authorRepository.save(author);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createInNewTx(Author author) {
		log.debug("" + TransactionAspectSupport.currentTransactionStatus());
		create(author);
	}

	public void superLongTransaction() {
		log.debug("author " + TransactionAspectSupport.currentTransactionStatus());
		bookService.superLongTransaction4();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void superLongTransactionWithRequiredTx() {
		log.debug("author " + TransactionAspectSupport.currentTransactionStatus());
		bookService.superLongTransactionWithRequiredTx();
	}

	@Transactional
	public void superLongTransactionWithRequiredTxWithBlankRequired() {
		log.debug("author " + TransactionAspectSupport.currentTransactionStatus());
		bookService.superLongTransactionWithRequiredTxWithBlankRequired();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void superLongTransactionWithRequiresNewTx() {
		log.debug("author " + TransactionAspectSupport.currentTransactionStatus());
		bookService.superLongTransactionWithRequiresNewTx();
	}
}
