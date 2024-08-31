package com.czetsuyatech.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czetsuyatech.persistence.entities.Anime;
import com.czetsuyatech.services.AnimeService;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
 */
@RestController
@RequestMapping(path = "/animes")
public class AnimeController {

	@Autowired
	private AnimeService animeService;

	@PostMapping
	public void create(@RequestBody Anime e) {
		animeService.create(e);
	}
}
