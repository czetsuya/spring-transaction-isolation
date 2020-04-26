package com.czetsuya.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
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
