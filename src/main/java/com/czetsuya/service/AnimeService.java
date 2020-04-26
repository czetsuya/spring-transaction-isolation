package com.czetsuya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.czetsuya.model.Anime;
import com.czetsuya.repository.AnimeRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
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
