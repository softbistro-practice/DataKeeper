package com.softbistro.datakeeper.parser;

import java.io.File;
import java.util.List;

import com.softbistro.datakeeper.model.DataItem;
import com.softbistro.datakeeper.model.FileContent;

/**
 * Basic interface for file parsers
 */
public interface IFileParser {
	
	/**
	 *  Pulling data from file and parsing it
	 *  @param input file
	 * 	@return {@link FileContent} object that holds file content
	 */
	public FileContent parse(File file);
	
}
