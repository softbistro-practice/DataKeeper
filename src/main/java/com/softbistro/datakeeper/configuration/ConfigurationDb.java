package com.softbistro.datakeeper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class ConfigurationDb extends AbstractMongoConfiguration{
	private String nameTable;
    
	// ---------------------------------------------------- mongodb config
	public ConfigurationDb(String nameTable) {
		this.nameTable = nameTable;
	}
	
    @Override
    protected String getDatabaseName() {
        return nameTable;
    }
    
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }
    
    // ---------------------------------------------------- MongoTemplate
    
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
