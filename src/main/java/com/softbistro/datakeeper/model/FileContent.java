package com.softbistro.datakeeper.model;

import java.util.List;
/**
 * 
 *Class that represent content of the file
 */
public class FileContent {
	
	private List<List<DataItem>> dateItems;

	public FileContent() {
	}

	public FileContent(List<List<DataItem>> dateItems) {
		this.dateItems = dateItems;
	}

	public List<List<DataItem>> getDateItems() {
		return dateItems;
	}

	public void setDateItems(List<List<DataItem>> dateItems) {
		this.dateItems = dateItems;
	}

	@Override
	public String toString() {
		return new StringBuilder("FileContent [dateItems=")
				.append( dateItems.toString())
				.append("]")
				.toString();
	}
	
	
	
}
