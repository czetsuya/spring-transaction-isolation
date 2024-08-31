package com.czetsuyatech.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi | czetsuyatech@gmail.com
 */
@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Anime extends BaseEntity {

	private String title;

	@OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AnimeCharacter> animeCharacters;

	public Anime(String title) {
		this.title = title;
	}

	public List<AnimeCharacter> getAnimeCharactersNullSafe() {
		
		if (animeCharacters == null) {
			animeCharacters = new ArrayList<>();
		}

		return animeCharacters;
	}
}
