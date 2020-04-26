package com.czetsuya;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.czetsuya.repository.AuthorRepository;
import com.czetsuya.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Component
@Slf4j
public class RestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);

        bookRepository.deleteAll();

        authorRepository.deleteAll();

        log.debug("DB Reset");
    }
}
