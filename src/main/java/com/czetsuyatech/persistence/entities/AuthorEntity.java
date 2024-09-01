package com.czetsuyatech.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import lombok.Data;

@Entity
@Data
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

  @ManyToMany
  @JoinTable(
      name = "author_books",
      joinColumns = @JoinColumn(name = "author_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  Set<BookEntity> publishedBooks;
}
