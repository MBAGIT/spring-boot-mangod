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

	// create demo-test spring mongo db for test
	// with no-sqlunit ( memory database)
	@Rule
	public MongoDbRule mongoDbRule = MongoDbRuleBuilder.newMongoDbRule().defaultSpringMongoDb("demo-test");

	@Autowired
	private CommandRepository unit;

	
	@Test
	@UsingDataSet(locations ="commands.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void TestCustomQueryUpdateCommandwhenMountEqualsValue() throws Exception {

		assertEquals(1, unit.updateCommand(12d, false));

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
