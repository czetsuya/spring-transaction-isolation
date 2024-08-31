package com.czetsuyatech.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuyatech.persistence.entities.Anime;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
 */
@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
