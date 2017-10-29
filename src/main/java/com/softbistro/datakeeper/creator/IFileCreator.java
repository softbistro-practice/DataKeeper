package com.softbistro.datakeeper.creator;

import java.util.List;

public interface IFileCreator {

	boolean writeTableDataRows(String tableName, List<List<Object>> dataRows, String fileName);
	
}
