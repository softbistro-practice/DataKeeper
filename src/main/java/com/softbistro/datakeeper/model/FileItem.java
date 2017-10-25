package com.softbistro.datakeeper.model;

import java.util.List;

/**
 * Represent a single file
 */
public class FileItem {

	private String name;
	
	private String extension;
	
	private List<List<DataItem>> dataItems;

	public FileItem() {
		
	}
	
	public FileItem(String name, String extension, List<List<DataItem>> dataItems) {
		this.name = name;
		this.extension = extension;
		this.dataItems = dataItems;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public List<List<DataItem>> getDataItems() {
		return dataItems;
	}

	public void setDataItems(List<List<DataItem>> dataItems) {
		this.dataItems = dataItems;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("FileItem [name=")
				.append(this.name)
				.append(", extension=")
				.append(this.extension)
				.append(", dataItems=")
				.append(this.dataItems)
				.append("]")
				.toString();
	}
}
