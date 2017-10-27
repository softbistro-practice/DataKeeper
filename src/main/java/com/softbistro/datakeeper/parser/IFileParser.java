package com.softbistro.datakeeper.parser;

import java.io.File;
import java.util.List;

import com.softbistro.datakeeper.model.DataItem;
import com.softbistro.datakeeper.model.FileContent;

/**
 * Basic interface for file parsers
 */
public interface IFileParser {

	public FileContent parse(File file);
	
}
