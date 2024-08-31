package com.czetsuyatech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.czetsuyatech.data.Book;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookIsolationService {

    @Autowired
    private BookService bookService;

    private volatile Long bookId;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void readUnCommited() {

        log.debug("");
        log.debug("readUnCommited " + TransactionAspectSupport.currentTransactionStatus());
        dirtyReads();
        nonRepeatableReads();
        phantomReads();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void readCommited() {

        log.debug("");
        log.debug("readCommited ");
        dirtyReads();
//        nonRepeatableReads();
//        phantomReads();
    }

    public void repeatableRead() {

        log.debug("");
        log.debug("repeatableRead " + TransactionAspectSupport.currentTransactionStatus());
        dirtyReads();
        nonRepeatableReads();
        phantomReads();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void isoSerializable() {

        log.debug("");
        log.debug("isoSerializable " + TransactionAspectSupport.currentTransactionStatus());
        dirtyReads();
        nonRepeatableReads();
        phantomReads();
    }

    @SneakyThrows
    private void dirtyReads() {

        log.debug("\r\ndirtyReads ");

        new Thread(() -> {
            Book book = new Book();
            book.setTitle("dirtyReads");
            bookService.create(book);
            bookId = book.getId();
        }).start();

        Thread.sleep(2000);

        new Thread(() -> log.debug("dirtyReads " + bookService.findByIdInNewTx(bookId))).start();
    }

    private void nonRepeatableReads() {

        log.debug("\r\nnonRepeatableReads " + TransactionAspectSupport.currentTransactionStatus());
        Book book = new Book();
        book.setTitle("nonRepeatableReads");
        bookService.createInNewTx(book);

        log.debug("nonRepeatableReads " + bookService.findByIdInNewTx(book.getId()));

        book.setTitle("nonRepeatableReads-Updated");

        log.debug("nonRepeatableReads " + bookService.findByIdInNewTx(book.getId()));
    }

    private void phantomReads() {

        log.debug("\r\nphantomReads " + TransactionAspectSupport.currentTransactionStatus());
        Book book = new Book();
        book.setTitle("phantomReads1");
        bookService.createInNewTx(book);

        log.debug("phantomReads " + bookService.findAllInNewTx());

        book = new Book();
        book.setTitle("phantomReads2");
        bookService.createInNewTx(book);

        log.debug("phantomReads " + bookService.findAllInNewTx());
    }
}
