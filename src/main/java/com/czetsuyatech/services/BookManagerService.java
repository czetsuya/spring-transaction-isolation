package com.czetsuyatech.services;

import com.czetsuyatech.persistence.entities.BookEntity;
import com.czetsuyatech.services.fixtures.BookFixture;
import java.time.Instant;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Slf4j
public class BookManagerService {

  @Autowired
  private BookService bookService;

  @Autowired
  private AuthorService authorService;

  @Transactional
  public Optional<BookEntity> createAndFindInSameTx() {

    log.debug("start createAndFindInSameTx");

    var input = BookFixture.createBook("HP", "Harry Potter", Instant.now());
    bookService.create(input);

    var output = Optional.ofNullable(bookService.findById(input.getId()));

    log.debug("end createAndFindInSameTx");

    return output;
  }

  public Optional<BookEntity> createAndFindInAnotherTx() {

    log.debug("start createAndFindInSameTx");

    var input = BookFixture.createBook("HP", "Harry Potter", Instant.now());
    bookService.createInTx(input);

    var output = Optional.ofNullable(bookService.findByIdInAnotherTx(input.getId()));

    log.debug("end createAndFindInSameTx");

    return output;
  }

  @Transactional
  public String superLongTransaction() {
    bookService.create(BookFixture.createDefaultBook());
    return authorService.superLongTransaction();
  }

  public String superLongTransaction2() {
    log.debug("book: {}", bookService.findById(1L));
    return TransactionAspectSupport.currentTransactionStatus().getTransactionName();
  }
}
