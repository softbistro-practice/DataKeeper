package com.softbistro.datakeeper.provider;

import java.util.List;

public interface IDataProvider {

	/**
	 * Return all rows data from container
	 * @return List rows in String
	 */
	List<List<String>> getDataRows();
	
}
