package com.softbistro.datakeeper.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

//@Configuration
@EnableMongoRepositories
public class ConfigurationDb extends AbstractMongoConfiguration{
	
	private String nameTable;
    private String host;
    private Integer port;
    private MongoClientURI url;
    
	// ---------------------------------------------------- mongodb config
	public ConfigurationDb(String host, Integer port,String nameTable) {
		this.host=host;
		this.port=port;
		this.nameTable = nameTable;
	}
	
    @Override
    protected String getDatabaseName() {
        return nameTable;
    }
    
    public String getUrl() {
    	return this.url.toString();
    }
    
    @Override
    @Bean
    public MongoClient mongoClient(){
    		url=new MongoClientURI("mongodb://"+this.host+":"+this.port+"/"+this.nameTable);
    		return new MongoClient(url);
    }
    
    // ---------------------------------------------------- MongoTemplate
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
