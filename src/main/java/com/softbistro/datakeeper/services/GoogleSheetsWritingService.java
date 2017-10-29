package com.softbistro.datakeeper.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
		
		Sheets sheetsService = GoogleSheetsGlobal.getSheetsService();
		Sheets.Spreadsheets.Create request = sheetsService.spreadsheets().create(requestBody);
		
		Spreadsheet response = request.execute();		

		ValueRange body = new ValueRange().setValues(data);
		
		UpdateValuesResponse result = sheetsService
				.spreadsheets()
				.values()
				.update(response.getSpreadsheetId(), sheetName, body)
				.setValueInputOption("RAW")
				.execute();
		
		if(result == null || result.isEmpty())
			return false;
		
		return true;
	}

	
}
