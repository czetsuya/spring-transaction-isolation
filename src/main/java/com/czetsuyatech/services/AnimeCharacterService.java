package com.czetsuyatech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.czetsuyatech.persistence.entities.Anime;
import com.czetsuyatech.persistence.entities.AnimeCharacter;
import com.czetsuyatech.persistence.repositories.AnimeCharacterRepository;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
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
