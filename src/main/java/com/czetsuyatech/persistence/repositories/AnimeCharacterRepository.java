package com.czetsuyatech.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuyatech.persistence.entities.AnimeCharacter;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
 */
@Repository
public interface AnimeCharacterRepository extends JpaRepository<AnimeCharacter, Long> {

}
