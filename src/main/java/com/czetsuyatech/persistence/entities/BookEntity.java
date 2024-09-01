package com.czetsuyatech.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity extends BaseEntity {

  private String code;
  private String title;
  private Instant publicationDate;

  @ManyToMany(mappedBy = "publishedBooks")
  Set<AuthorEntity> authors;
}
