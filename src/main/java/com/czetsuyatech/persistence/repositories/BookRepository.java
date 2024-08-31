package com.czetsuyatech.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuyatech.data.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
