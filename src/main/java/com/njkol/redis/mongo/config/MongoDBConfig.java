package com.njkol.redis.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import com.mongodb.MongoClientOptions.Builder;

/**
 * Configuration for MongoDB Template
 * 
 * @author Nilanjan Sarkar
 *
 */
@Configuration
public class MongoDBConfig {

	@Value("${mongouri}")
	private String mongoServerURI;
	@Value("${dbName}")
	private String dbName;
	
	@Bean
	public Mongo mongo() throws Exception {
		Builder options = MongoClientOptions.builder().writeConcern(WriteConcern.ACKNOWLEDGED);
		MongoClientURI uri = new MongoClientURI(mongoServerURI, options);
		return new MongoClient(uri);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), dbName);
	}
}