package com.czetsuya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.czetsuya.model.Anime;
import com.czetsuya.model.AnimeCharacter;
import com.czetsuya.repository.AnimeCharacterRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Service
public class AnimeCharacterService {

	@Autowired
	private AnimeCharacterRepository animeCharacterRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addCharacterToAnime(Anime e) {
		
		AnimeCharacter ac = new AnimeCharacter("Kira", "Yamato", e);
		animeCharacterRepository.save(ac);
	}
}
