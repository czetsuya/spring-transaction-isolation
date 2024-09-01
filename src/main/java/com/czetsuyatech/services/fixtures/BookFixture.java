package com.czetsuyatech.services.fixtures;

import com.czetsuyatech.persistence.entities.BookEntity;
import java.time.Instant;

public class BookFixture {

  public static BookEntity createDefaultBook() {

    return createBook("HP", "Harry Potter", Instant.now());
  }

  public static BookEntity createBook(String code, String title, Instant publicationDate) {
    return BookEntity.builder()
        .code(code)
        .title(title)
        .publicationDate(publicationDate)
        .build();
  }
}
