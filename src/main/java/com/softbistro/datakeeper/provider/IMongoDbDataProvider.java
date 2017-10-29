package com.softbistro.datakeeper.provider;

import java.util.List;

public interface IMongoDbDataProvider {

	/**
	 * Return all rows data from container with specified collection name
	 * 
	 * @param collectionName Name of data collection
	 * @return List rows
	 */
	List<List<Object>> getDataRows(String collectionName);
	
}
