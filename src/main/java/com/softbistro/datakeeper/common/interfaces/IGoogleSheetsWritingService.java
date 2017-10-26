package com.softbistro.datakeeper.common.interfaces;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.softbistro.datakeeper.model.DataItem;

/**
 * 
 * @author Dmytro Kohut
 *
 */
public interface IGoogleSheetsWritingService {

	/**
	 * Insert data into Google Sheets.
	 * 
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 */
	boolean writeSheet(List<List<Object>> data, String filename) throws IOException, GeneralSecurityException;
}
