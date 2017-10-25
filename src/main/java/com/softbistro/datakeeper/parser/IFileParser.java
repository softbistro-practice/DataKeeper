package com.softbistro.datakeeper.parser;

import java.io.File;
import java.util.List;

import com.softbistro.datakeeper.model.DataItem;

/**
 * Basic interface for file parsers
 */
public interface IFileParser {

	public List<List <DataItem>> parse(File file);
	
}
