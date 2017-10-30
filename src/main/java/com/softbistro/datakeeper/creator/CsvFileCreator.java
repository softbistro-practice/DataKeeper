package com.softbistro.datakeeper.creator;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.log4j.Logger;

public class CsvFileCreator implements IFileCreator {
	
	private static final Logger logger = Logger.getLogger(CsvFileCreator.class);

	@Override
	public ByteArrayOutputStream writeTableDataRows(String tableName, List<List<Object>> dataRows, String fileName) {
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try(Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));) {
			CSVPrinter csvPrinter = new CSVPrinter(out, CSVFormat.DEFAULT);
			csvPrinter.printComment(tableName);
			for(List<Object> row : dataRows) {
				csvPrinter.printRecord(row);
			}
			csvPrinter.flush();
			csvPrinter.close();
			return outputStream;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
