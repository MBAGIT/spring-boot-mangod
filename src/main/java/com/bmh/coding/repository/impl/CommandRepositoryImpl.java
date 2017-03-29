/**
 * 
 */
package com.bmh.coding.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.bmh.coding.model.Command;
import com.bmh.coding.repository.CommandRepositoryCustom;
import com.mongodb.WriteResult;

/**
 * 
 * Implementation of custom method 
 * @author Mohamed
 *
 */
public class CommandRepositoryImpl implements CommandRepositoryCustom {
	
	
	
	
	@Autowired
	MongoTemplate mongoTemplate ;
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.bmh.coding.repository.CommandRepositoryCustom#updateCommand(java.lang.Integer, java.lang.Boolean)
	 */
	public int updateCommand(Integer mount,Boolean valid){
		
		Query query = new Query(Criteria.where("mount").gte(mount)) ;
		Update update = new Update();
		update.set("valid", valid);
		
		WriteResult result = mongoTemplate.updateFirst(query, update, Command.class);
		
		if(result!=null)
            return result.getN();
        else
            return 0;
		
	}

}
