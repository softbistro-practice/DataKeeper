package com.softbistro.datakeeper.model.xls;

import com.softbistro.datakeeper.model.DataItem;
import com.softbistro.datakeeper.model.DataType;

/**
 * 
 *Class that represent cell info from xls file
 */
public class XLSDataItem extends DataItem {
	
	private int rowNumber;
	private int collumnNumber;
	private int sheetNumber;
	
	
	
	public XLSDataItem() {
	}

	public XLSDataItem(Object value, DataType type, int rowNumber, int collumnNumber, int sheetNumber) {
		super(value, type);
		this.rowNumber = rowNumber;
		this.collumnNumber = collumnNumber;
		this.sheetNumber = sheetNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getCollumnNumber() {
		return collumnNumber;
	}

	public void setCollumnNumber(int collumnNumber) {
		this.collumnNumber = collumnNumber;
	}

	public int getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(int sheetNumber) {
		this.sheetNumber = sheetNumber;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("DataItem [ value = ")
				.append(this.getValue().toString())
				.append(", type = ")
				.append(this.getType())
				.append(", rowNumber = ")
				.append(this.rowNumber)
				.append(", collumnNumber = ")
				.append(this.collumnNumber)
				.append(", sheetNumber = ")
				.append(this.sheetNumber)
				.append("]")
				.toString();
	}
	
}
