package com.czetsuya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czetsuya.model.Anime;
import com.czetsuya.service.AnimeService;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
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
