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
	public List<List<String>> getDataRows(String collectionName) {
		List<List<String>> result = new ArrayList<>();
		if(this.mongoTemplate.collectionExists(collectionName)) {
			for(Document document : this.mongoTemplate.getCollection(collectionName).find()) {
				result.add(this.toStringList(document));
			}
			return result;
		}
		
		return null;
	}
	
	private List<String> toStringList(Document document) {
		List<String> result = new ArrayList<>();
		document.forEach((key, value) -> {
			result.add(value.toString());
		});
		return result;
	}
}
