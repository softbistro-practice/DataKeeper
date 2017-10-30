package com.softbistro.datakeeper.creator;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface IFileCreator {

	ByteArrayOutputStream writeTableDataRows(String tableName, List<List<Object>> dataRows, String fileName);
	
}
