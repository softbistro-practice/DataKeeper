package com.softbistro.datakeeper.provider;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDbDataProvider implements IMongoDbDataProvider {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<List<Object>> getDataRows(String collectionName) {
		List<List<Object>> result = new ArrayList<>();
		if(this.mongoTemplate.collectionExists(collectionName)) {
			for(Document document : this.mongoTemplate.getCollection(collectionName).find()) {
				result.add(new ArrayList<>(document.values()));
			}
			return result;
		}
		
		return null;
	}

}
