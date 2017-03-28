/**
 * Copyright 2017  author Mohamed Babchia.
 * 
 */
package com.bmh.coding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mohamed
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommandNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * 
	 * use of constructor to specify the message
	 * @param id
	 */
	public CommandNotFoundException(Long id) {
		super("could not find command '" + id + "'.");
	}

	
	
	/**
	 * 
	 * use of constructor to specify the message
	 * @param reference
	 */
	public CommandNotFoundException(String  reference) {
		super("could not find command '" + reference + "'.");
	}
}
