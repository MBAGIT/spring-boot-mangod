/**
 * 
 */
package com.bmh.coding;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bmh.coding.repository.CommandRepository;
import com.github.fakemongo.Fongo;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder;
import com.mongodb.Mongo;

/**
 * @author Mohamed
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
public class CommandRepositoryTests {

	
	@Autowired
	private ApplicationContext applicationContext;

	// create default spring mongo db 
	// with no-sqlunit
	@Rule
	public MongoDbRule mongoDbRule = MongoDbRuleBuilder.newMongoDbRule().defaultSpringMongoDb("demo-test");

	@Autowired
	private CommandRepository unit;

	/**
	 *  @UsingDataSet is used to seed database with defined data set. 
	 *  In brief data sets are files that contain all data to be inserted to configured database. 
	 *  In order to seed your database, use @UsingDataSet annotation, you can define it either on the test itself or on the class level.
	 *  If there is definition on both, test level annotation takes precedence. This annotation has two attributes locations and loadStrategy .
	 *
	 *	With locations attribute you can specify classpath datasets location. 
	 *  Second attribute provides strategies for inserting data. Implemented strategies are:
	 *
	 *	INSERT Insert defined datasets before executing any test method. 
	 *	DELETE_ALL Deletes all elements of database before executing any test method. 
	 *	CLEAN_INSERT This is the most used strategy. It deletes all elements of database and then insert defined datasets before executing any test method
	 *	
	 *	For more informations see :https://github.com/lordofthejars/nosql-unit#seeding_database
	 * @throws Exception
	 */
	@Test
	@UsingDataSet(locations = "commands.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void updateCommandwhenMountEqualsValue() throws Exception {

		assertEquals(1, unit.updateCommand(12d, false));

		unit.findAll().stream().forEach(System.out::println);

	}

	/**
	 * Configuration class for  your in memory database, You need to override spring bean, which stands for creating Mongo object.
	 * @author Mohamed
	 *
	 */
	@Configuration
	@EnableMongoRepositories
	@ComponentScan(basePackageClasses = { CommandRepository.class })
	static class CommandRepositoryConfiguration extends AbstractMongoConfiguration {

		@Override
		protected String getDatabaseName() {
			return "demo-test";
		}

		@Bean
		public Mongo mongo() {
			Fongo queued = new Fongo("Commandes");
			return queued.getMongo();
		}

	}

}
