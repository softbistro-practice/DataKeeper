package com.softbistro.datakeeper.provider;

import java.util.List;

public interface IDataProvider {

	/**
	 * Return all rows data from container with specified collection name
	 * 
	 * @param collectionName Name of data collection
	 * @return List rows in String
	 */
	List<List<String>> getDataRows(String collectionName);
	
}
