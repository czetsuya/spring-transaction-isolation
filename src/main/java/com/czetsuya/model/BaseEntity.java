package com.czetsuya.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
