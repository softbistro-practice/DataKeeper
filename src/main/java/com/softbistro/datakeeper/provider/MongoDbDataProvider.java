package com.softbistro.datakeeper.provider;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDbDataProvider implements IDataProvider {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<List<String>> getDataRows() {
		List<List<String>> result = new ArrayList<>();
		for(String collectionName : this.mongoTemplate.getCollectionNames()) {
			for(Document document : this.mongoTemplate.getCollection(collectionName).find()) {
				result.add(this.toStringList(document));
			}
		}
		
		return result;
	}
	
	private List<String> toStringList(Document document) {
		List<String> result = new ArrayList<>();
		document.forEach((key, value) -> {
			result.add(value.toString());
		});
		return result;
	}
}
