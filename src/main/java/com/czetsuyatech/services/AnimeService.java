package com.czetsuyatech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.czetsuyatech.persistence.entities.Anime;
import com.czetsuyatech.persistence.repositories.AnimeRepository;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
 */
@Service
public class AnimeService {

	@Autowired
	private AnimeRepository animeRepository;

	@Autowired
	private AnimeCharacterService animeCharacterService;

	@Transactional
	public Long create(Anime e) {
		
		animeRepository.save(e);
		animeCharacterService.addCharacterToAnime(e);

		return e.getId();
	}
}
