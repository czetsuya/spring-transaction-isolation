package com.czetsuyatech;

import com.czetsuyatech.persistence.repositories.AuthorRepository;
import com.czetsuyatech.persistence.repositories.BookRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
 */
@Component
@Slf4j
public class RestInterceptor implements HandlerInterceptor {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    bookRepository.deleteAll();

    authorRepository.deleteAll();

    log.debug("DB Reset");
  }
}
