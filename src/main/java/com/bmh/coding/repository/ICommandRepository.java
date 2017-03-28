/**
 * Copyright 2017  author Mohamed Babchia.
 * 
 */
package com.bmh.coding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bmh.coding.model.Command;

/**
 * @author Mohamed
 *
 */
public interface ICommandRepository extends MongoRepository<Command, String> {

	/** 
	 * findById method
	 * @param id
	 * @return {@link Optional} {@link Command}
	 */
	Optional<Command> findById(String id);

	/** 
	 * findByCommandeNumber method
	 * @param id
	 * @return {@link Optional} {@link List} {@link Command}
	 */
	Optional<List<Command>> findByCommandeNumber(Integer commandenumber);

	/** 
	 * findByReference method
	 * @param id
	 * @return {@link Optional} {@link Command}
	 */
	Optional<Command> findByReference(String reference);

}
