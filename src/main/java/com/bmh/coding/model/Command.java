/**
 * Copyright 2017  author Mohamed Babchia.
 * 
 */
package com.bmh.coding.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mohamed
 *
 */
@Document(collection = "Commandes")
public class Command {

	@Id
	public String id;

	@NotBlank
	@Size(max = 250)
	@Indexed(unique = true)
	public Integer commandeNumber;

	public String reference;

	public Date creationDate = new Date();

	public Boolean valid = false;
	
	public Double mount;

	/**
	 * 
	 */
	public Command() {
		super();
	}

	/**
	 * @param reference
	 * @param mount
	 */
	public Command(String reference, Double mount, Boolean valid,Integer commandeNumber) {

		this.reference = reference;
		this.mount = mount;
		this.valid = valid;
		this.commandeNumber=commandeNumber;
	}

	

	

}
