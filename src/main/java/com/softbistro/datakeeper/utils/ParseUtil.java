package com.softbistro.datakeeper.utils;

import com.softbistro.datakeeper.model.DataType;
import java.util.regex.Pattern;

/**
 * A class that contains useful routines common for parsing
 */
public class ParseUtil {

	private static final String BOOLEAN_PATTERN = "true|false";
	private static final String CHARACTER_PATTERN = "[a-zA-Z]{1}$";
	private static final String INTEGER_PATTERN = "^-?\\d{1,10}$";
	private static final String DOUBLE_PATTERN = "(?:\\+|\\-)?\\d+\\.\\d+";		
	private static final String DATE_PATTERN = "^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$";
	

	public static DataType getNativeDataType(String value) {
		
		if (Pattern.compile(BOOLEAN_PATTERN).matcher(value).matches())
			return DataType.Boolean;
		
		if (Pattern.compile(CHARACTER_PATTERN).matcher(value).matches())
			return DataType.Character;
		
		if (Pattern.compile(INTEGER_PATTERN).matcher(value).matches())
			return DataType.Integer;
		
		if (Pattern.compile(DOUBLE_PATTERN).matcher(value).matches())
			return DataType.Double;
		
		if (Pattern.compile(DATE_PATTERN).matcher(value).matches())
			return DataType.Date;
		
		return DataType.String;
	}
	
}
