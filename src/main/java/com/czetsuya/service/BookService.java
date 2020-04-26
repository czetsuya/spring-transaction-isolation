package com.czetsuya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.czetsuya.data.Book;
import com.czetsuya.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookManagerService bookManagerService;

	@Autowired
	private BookIsolationService bookIsoService;

	public void create(Book book) {
		bookRepository.save(book);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createInNewTx(Book book) {
		System.out.println(TransactionAspectSupport.currentTransactionStatus());
		create(book);
	}

	public Book findById(Long id) {
		System.out.println("findById " + TransactionAspectSupport.currentTransactionStatus());
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		}

		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
	public Book findByIdInNewTx(Long id) {
		return findById(id);
	}

	public List<Book> findAll() {
		System.out.println("findAll " + TransactionAspectSupport.currentTransactionStatus());
		return bookRepository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Book> findAllInNewTx() {
		return findAll();
	}

	public Book insertAndFindWithoutTransaction() {

		Book book = new Book();
		book.setTitle("insertAndFindWithoutTransaction");
		create(book);

		return bookRepository.findById(book.getId()).get();
	}

	@Transactional
	public Book insertAndFindWithTransaction() {

		Book book = new Book();
		book.setTitle("insertAndFindWithTransaction");
		create(book);

		return bookRepository.findById(book.getId()).get();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Book findInNewTransaction(Long id) {
		return bookRepository.findById(id).get();
	}

	public void superLongTransaction4() {
		System.out.println("book " + TransactionAspectSupport.currentTransactionStatus());
		bookManagerService.superLongTransaction2();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void superLongTransactionWithRequiredTx() {
		System.out.println("book " + TransactionAspectSupport.currentTransactionStatus());
		bookManagerService.superLongTransactionWithRequiredTx2();
	}

	public void superLongTransactionWithRequiredTxWithBlankRequired() {
		System.out.println("book " + TransactionAspectSupport.currentTransactionStatus());
		bookManagerService.superLongTransactionWithRequiredTxWithBlankRequired2();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void superLongTransactionWithRequiresNewTx() {
		System.out.println("book " + TransactionAspectSupport.currentTransactionStatus());
		bookManagerService.superLongTransactionWithRequiresNewTx2();
	}

}
