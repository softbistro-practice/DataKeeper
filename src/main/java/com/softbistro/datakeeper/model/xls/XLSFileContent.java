package com.softbistro.datakeeper.model.xls;

import java.util.List;

import com.softbistro.datakeeper.model.DataItem;
import com.softbistro.datakeeper.model.FileContent;

/**
 * 
 *Class that represent content of file with xls extension
 */
public class XLSFileContent extends FileContent {
	
	private List<String> sheetNames;

	public XLSFileContent() {
		
	}
	
	public XLSFileContent(List<String> sheetNames, List<List<DataItem>> dateItems) {
		super(dateItems);
		this.sheetNames = sheetNames;
	}

	public List<String> getSheetNames() {
		return sheetNames;
	}

	public void setSheetNames(List<String> sheetNames) {
		this.sheetNames = sheetNames;
	}

	@Override
	public String toString() {
		return new StringBuilder("XLSFileContent [")
				.append("dateItems=")
				.append(this.getDataItems().toString())
				.append("sheetNames=")
				.append(this.sheetNames.toString())
				.append("]")
				.toString();
	}

}
