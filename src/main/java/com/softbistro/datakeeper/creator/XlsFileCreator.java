package com.softbistro.datakeeper.creator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.activation.UnsupportedDataTypeException;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class XlsFileCreator implements IFileCreator {

	private static final Logger logger = Logger.getLogger(XlsFileCreator.class);
	
	@Override
	public boolean writeTableDataRows(String tableName, List<List<Object>> dataRows, String filePath) {
		
		try {
			XSSFWorkbook workbook = workbookInit(filePath);
			XSSFSheet sheet = workbook.createSheet(tableName);
			
			writeRows(dataRows, sheet);
			
			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
			
			return true;
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private XSSFWorkbook workbookInit(String filePath) 
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		XSSFWorkbook workbook;
		
		if (new File(filePath).isFile()) {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
		} else {
			workbook = new XSSFWorkbook();
		}
		
		return workbook;
	}

	private void writeRows(List<List<Object>> dataRows, XSSFSheet sheet) 
			throws UnsupportedDataTypeException {
		
		int rowCounter = 0;
		
		for (List<Object> dataRow : dataRows) {
			
			Row row = sheet.createRow(rowCounter++);
			int columnCounter = 0;
			
			for (Object field : dataRow) {
				
				Cell cell = row.createCell(columnCounter++);
				
				if (field instanceof String) {
					cell.setCellValue(field.toString());
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				} else if (field instanceof Boolean) {
					cell.setCellValue((Boolean) field);
				} else if (field instanceof Date) {
					cell.setCellValue((Date) field);
				} else {
					throw new UnsupportedDataTypeException();
				}
			}	
		}
	}
	
}
