package com.czetsuya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czetsuya.model.Anime;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
