package com.czetsuyatech.persistence.repositories;

import com.czetsuyatech.persistence.entities.BookEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

  Optional<BookEntity> findByCode(String code);
}
