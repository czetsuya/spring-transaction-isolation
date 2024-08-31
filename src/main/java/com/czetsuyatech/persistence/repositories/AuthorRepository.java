package com.czetsuyatech.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuyatech.data.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
