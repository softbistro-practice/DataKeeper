package com.softbistro.datakeeper.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.SheetProperties;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.softbistro.datakeeper.common.configuration.GoogleSheetsGlobal;
import com.softbistro.datakeeper.common.interfaces.IGoogleSheetsWritingService;


/**
 * This class responsible for writing data into Google Sheets.
 * 
 * @author Dmytro Kohut
 *
 */
@Service
public class GoogleSheetsWritingService implements IGoogleSheetsWritingService {
	
	private static String APPLICATION_NAME;
	
	@Value("${googlesheets.application.name}")
	public void setApplicationName(String applicationName) {
		APPLICATION_NAME = applicationName;
	}
	
	private static String sheetName = "Sheet 1";

	
	/**
	 * @see com.softbistro.datakeeper.common.interfaces.IGoogleSheetsWritingService#writeSheet(List, String)
	 */
	@Override
	public boolean writeSheet(List<List<Object>> data, String filename) throws IOException, GeneralSecurityException {
		
		List<Sheet> listOfSheets = new ArrayList<>();
		listOfSheets.add(new Sheet()
					.setProperties(new SheetProperties()
					.setTitle(sheetName)));
		
		Spreadsheet requestBody = new Spreadsheet()
					.setProperties(new SpreadsheetProperties()
					.setTitle(filename))
					.setSheets(listOfSheets);
		
		Sheets sheetService = createSheetsService();
		Sheets.Spreadsheets.Create request = sheetService.spreadsheets().create(requestBody);
		
		Spreadsheet returnedSpreadsheet = request.execute();
		
//		String spreadsheetUrl = returnedSpreadsheet.getSpreadsheetUrl();
		
		ValueRange values = new ValueRange().setValues(data);
		
		UpdateValuesResponse valuesResponse = sheetService
					.spreadsheets()
					.values()
					.update(returnedSpreadsheet.getSpreadsheetId(), sheetName, values)
					.setValueInputOption("RAW")
					.execute();
		
		if(valuesResponse == null || valuesResponse.isEmpty())
			return false;
			
		return true;
	}
	
	
	private static Sheets createSheetsService() throws IOException, GeneralSecurityException {		
		Credential credential = GoogleSheetsGlobal.authorize();
		
		return new Sheets.Builder(GoogleSheetsGlobal.getHttpTransport(), GoogleSheetsGlobal.getJsonFactory(), credential)
				.setApplicationName(APPLICATION_NAME)
				.build();
	}

}
