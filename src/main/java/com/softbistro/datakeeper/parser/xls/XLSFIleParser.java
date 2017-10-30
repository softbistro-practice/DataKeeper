package com.softbistro.datakeeper.parser.xls;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import com.softbistro.datakeeper.model.DataItem;
import com.softbistro.datakeeper.model.DataType;
import com.softbistro.datakeeper.model.FileContent;
import com.softbistro.datakeeper.model.xls.XLSDataItem;
import com.softbistro.datakeeper.model.xls.XLSFileContent;
import com.softbistro.datakeeper.parser.IFileParser;
import com.softbistro.datakeeper.utils.ParseUtil;

/**
 * 
 * This class developed for puling data from files with *.xls, *.xlsx extensions
 * and  parsing this data.
 * 
 */
public class XLSFIleParser implements IFileParser {

	/**
	 * @see IFileParser
	 */
	@Override
	public FileContent parse(File file) {
		XLSFileContent fileContent = null;
		try {
			fileContent = new XLSFileContent();
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			fileContent.setSheetNames(getAllSheetNames(workBook));
			fileContent.setDataItems(getFileContent(workBook));
		}catch (IOException | InvalidFormatException e) {

		}
		return fileContent;
	}

	private List<String> getAllSheetNames(XSSFWorkbook book) {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < book.getNumberOfSheets(); i++) {
			names.add(book.getSheetName(i));
		}
		return names;
	}

	private List<List<DataItem>> getFileContent(XSSFWorkbook book) {
		List<List<DataItem>> items = new ArrayList<>();
		for (int i = 0; i < book.getNumberOfSheets(); i++) {
			XSSFSheet currentSheet = book.getSheetAt(i);
			Iterator<Row> rows = currentSheet.iterator();
			while (rows.hasNext()) {
				Iterator<Cell> cells = rows.next().cellIterator();
				List<DataItem> rowItems = new ArrayList<>();
				while (cells.hasNext()) {
					Cell currentCell = cells.next();
					rowItems.add(getCellContent(currentCell, i));
				}
				items.add(rowItems);
			}
		}
		return items;
	}

	private DataItem getCellContent(Cell cell, int sheetNumber) {
		XLSDataItem item = new XLSDataItem();
		Double vall = null;
		String value;

		item.setCollumnNumber(cell.getColumnIndex());
		item.setRowNumber(cell.getRowIndex());
		item.setSheetNumber(sheetNumber);

		if (cell.getCellTypeEnum().equals(CellType.FORMULA)) {
			item.setValue("=" + cell.getCellFormula());
			item.setType(DataType.String);
			return item;
		}

		if (cell.getCellTypeEnum().equals(CellType.NUMERIC))
			vall = cell.getNumericCellValue();

		cell.setCellType(CellType.STRING);
		value = cell.getStringCellValue();
		item.setValue(value);
		item.setType(ParseUtil.getNativeDataType(value));

		cell.setCellType(CellType.NUMERIC);
		if (DateUtil.isCellDateFormatted(cell) && value.length() != 1 && vall != null) {
			cell.setCellValue(vall);
			LocalDate date = cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			item.setValue(date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear());
			item.setType(DataType.Date);
		}
		return item;
	}
}
