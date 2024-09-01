package com.czetsuyatech.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuyatech.persistence.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
