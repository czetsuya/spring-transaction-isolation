package com.czetsuya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class AnimeCharacter extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "anime_id")
	private Anime anime;

	public AnimeCharacter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
