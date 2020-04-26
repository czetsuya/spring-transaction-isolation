package com.czetsuya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuya.model.AnimeCharacter;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Repository
public interface AnimeCharacterRepository extends JpaRepository<AnimeCharacter, Long> {

}
