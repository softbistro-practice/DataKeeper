package com.softbistro.datakeeper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.softbistro.datakeeper.common.configuration.ConfigurationDb;

@SpringBootApplication
public class DataKeeperApplication implements CommandLineRunner{
	//@Value("${spring.data.mongodb.host}") String host;
	//@Value("${spring.data.mongodb.port}") Integer port;
	public static void main(String[] args) {
		SpringApplication.run(DataKeeperApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("");
		//ConfigurationDb cdb = new ConfigurationDb(host,port,"test");
		//cdb.mongoTemplate();
	}
}
