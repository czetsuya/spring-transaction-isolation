package com.czetsuyatech.services;

import com.czetsuyatech.persistence.entities.BookEntity;
import com.czetsuyatech.persistence.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookManagerService bookManagerService;

  @Autowired
  private BookService self;

  public void create(BookEntity bookEntity) {
    log.debug("create");
    bookRepository.save(bookEntity);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void createInTx(BookEntity bookEntity) {
    create(bookEntity);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void createInAnotherTx(BookEntity bookEntity) {
    create(bookEntity);
  }

  public BookEntity findById(Long id) {

    log.debug("findById");
    Optional<BookEntity> book = bookRepository.findById(id);
    if (book.isPresent()) {
      return book.get();
    }

    return null;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public BookEntity findByIdInTx(Long id) {
    return findById(id);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public BookEntity findByIdInAnotherTx(Long id) {
    return findById(id);
  }

  public List<BookEntity> findAll() {
    return bookRepository.findAll();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public List<BookEntity> findAllInAnotherTx() {
    return findAll();
  }

  public String superLongTransaction4() {
    log.debug("book: {}", self.findById(1L));
    return bookManagerService.superLongTransaction2();
  }
}
