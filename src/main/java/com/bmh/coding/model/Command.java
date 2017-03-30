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
	private  String id;

	@NotBlank
	@Size(max = 250)
	@Indexed(unique = true)
	private Integer commandeNumber;

	private String reference;

	private Date creationDate = new Date();

	private Boolean valid = false;
	
	private Double mount;

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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the commandeNumber
	 */
	public Integer getCommandeNumber() {
		return commandeNumber;
	}

	/**
	 * @param commandeNumber the commandeNumber to set
	 */
	public void setCommandeNumber(Integer commandeNumber) {
		this.commandeNumber = commandeNumber;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the valid
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the mount
	 */
	public Double getMount() {
		return mount;
	}

	/**
	 * @param mount the mount to set
	 */
	public void setMount(Double mount) {
		this.mount = mount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Command [id=" + id + ", commandeNumber=" + commandeNumber + ", reference=" + reference
				+ ", creationDate=" + creationDate + ", valid=" + valid + ", mount=" + mount + "]";
	}

	

	

}
