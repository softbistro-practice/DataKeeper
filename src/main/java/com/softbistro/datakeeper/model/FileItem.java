package com.softbistro.datakeeper.model;

import java.util.List;

/**
+ * Represents a file with it's general info and content
+ */
public class FileItem {

	private String name;
	
	private String extension;
	
	private FileContent content;

	public FileItem() {
		
	}
	
	public FileItem(String name, String extension, FileContent content) {
		this.name = name;
		this.extension = extension;
		this.content = content;
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


	public FileContent getContent() {
		return content;
	}

	public void setContent(FileContent content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("FileItem [name=")
				.append(this.name)
				.append(", extension=")
				.append(this.extension)
				.append(", dataItems=")
				.append(this.content.toString())
				.append("]")
				.toString();
	}
}
