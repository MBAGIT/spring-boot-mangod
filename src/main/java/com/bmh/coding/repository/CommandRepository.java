/**
 * Copyright 2017  author Mohamed Babchia.
 * 
 */
package com.bmh.coding.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bmh.coding.model.Command;

/**
 * @author Mohamed
 *
 */
public interface CommandRepository extends MongoRepository<Command, String>, CommandRepositoryCustom {

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

	/**
	 *  To handle parameters in your query you simply define method parameters as already seen in the examples above. 
	 *  Besides that the infrastructure will recognize certain specific types like Pageable and Sort to apply pagination and sorting to your queries dynamically.
	 *  http://docs.spring.io/spring-data/data-mongo/docs/1.10.0.M1/reference/html/#repositories
	 * 
	 * @param reference
	 * @param pageable
	 * @return
	 */
	Slice<Command> findByReference(String reference, Pageable pageable);

	List<Command> findByMount(String lastname, Sort sort);

	/**
	 *  Limiting the result size of a query with Top and First
	 */
	/**
	 * @param creationDate
	 * @param pageable
	 * @return
	 */
	Slice<Command> findTop3BycreationDate(Date creationDate, Pageable pageable);

	//Supports native JSON query string
	@Query("{id:'?0'}")
	Command findCustomById(String id);

	@Query("{domain: { $regex: ?0 } })")
	List<Command> findCustomByRegExReference(String reference);

}
