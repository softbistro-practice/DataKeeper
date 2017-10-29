package com.softbistro.datakeeper.provider;

import java.util.List;

public interface IGoogleSheetsDataProvider {

	List<List<Object>> getSpreadsheetRecords(String spreadsheetId, String range);
	
}
