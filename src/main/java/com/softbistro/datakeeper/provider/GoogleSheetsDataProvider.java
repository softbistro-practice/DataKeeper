package com.softbistro.datakeeper.provider;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.softbistro.datakeeper.creator.XlsFileCreator;
import com.softbistro.datakeeper.temp.GoogleSheetsGlobal;

@Service
public class GoogleSheetsDataProvider implements IGoogleSheetsDataProvider {

	private static final Logger logger = Logger.getLogger(XlsFileCreator.class);
	
	@Override
	public List<List<Object>> getSpreadsheetRecords(String spreadsheetId, String range) {
		
		try {
			Sheets service = GoogleSheetsGlobal.getSheetsService(); // TO DO
			
			ValueRange response = service.spreadsheets()
					.values()
					.get(spreadsheetId, range)
					.execute();
			
			List<List<Object>> spreadsheetRecords = response.getValues();
			
			if (spreadsheetRecords != null && spreadsheetRecords.size() != 0) {
				return spreadsheetRecords;
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		
		return null;
	}
}
