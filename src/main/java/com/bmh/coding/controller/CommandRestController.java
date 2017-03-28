/**
 * Copyright 2017  author Mohamed Babchia.
 * 
 */
package com.bmh.coding.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bmh.coding.exception.CommandNotFoundException;
import com.bmh.coding.model.Command;
import com.bmh.coding.repository.ICommandRepository;

/**
 * @author Mohamed
 *
 */
@RestController
@RequestMapping("/commadService")
public class CommandRestController {

	private final ICommandRepository commandRepository;

	/**
	 * Constructor with attributes
	 * @param commandeRepository
	 */
	@Autowired
	public CommandRestController(ICommandRepository commandRepository) {

		this.commandRepository = commandRepository;
	}

	/**
	 * 
	 * Method to add command
	 * @param input  commande Json 
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/addCommand", method = RequestMethod.POST)
	public ResponseEntity<?> addCommande(@RequestBody Command input) {
//		try {
			Command saveCommande = this.commandRepository.save(new Command(input.reference, input.mount, input.valid, input.commandeNumber));
			// construct location to send the new entity
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(saveCommande).toUri();

			return ResponseEntity.created(location).build();
//		} catch (Exception e) {
//			return ResponseEntity.noContent().build();
//		}

	}

	/**
	 * Method to return command information
	 * @param id
	 * @return {@link Command}
	 */
	@RequestMapping(value = "/command/{id}", method = RequestMethod.GET)
	public Command getCommande(@PathVariable String id) {

		return this.commandRepository.findById(id).orElseThrow(() -> new CommandNotFoundException(id));

	}
	
	
	/**
	 * Method to return command information
	 * @param reference
	 * @return {@link Command}
	 */
	@RequestMapping(value = "/command/reference/{reference}", method = RequestMethod.GET)
	public Command getCommandeByreference(@PathVariable String reference) {

		return this.commandRepository.findByReference(reference).orElseThrow(() -> new CommandNotFoundException(reference));

	}

}
