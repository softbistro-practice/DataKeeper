package com.softbistro.datakeeper.model;

import java.util.List;
/**
 * 
 *Class that represent content of the file
 */
public class FileContent {
	

	private List<List<DataItem>> dataItems;


	public FileContent() {
	}

	public FileContent(List<List<DataItem>> dataItems) {
		this.dataItems = dataItems;
	}

	public List<List<DataItem>> getDataItems() {
		return dataItems;
	}

	public void setDataItems(List<List<DataItem>> dataItems) {
		this.dataItems = dataItems;

	}

	@Override
	public String toString() {
		return new StringBuilder("FileContent [dataItems=")
				.append( dataItems.toString())
				.append("]")
				.toString();
	}

}
