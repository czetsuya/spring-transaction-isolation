package com.czetsuyatech.services;

import com.czetsuyatech.persistence.entities.AuthorEntity;
import com.czetsuyatech.persistence.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private BookService bookService;

  public void create(AuthorEntity authorEntity) {
    authorRepository.save(authorEntity);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void createInAnotherTx(AuthorEntity authorEntity) {
    create(authorEntity);
  }

  @Transactional
  public String superLongTransaction() {
    log.debug("book: {}", bookService.findById(1L));
    return bookService.superLongTransaction4();
  }
}
