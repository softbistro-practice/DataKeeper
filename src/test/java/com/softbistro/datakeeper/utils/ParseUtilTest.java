package com.softbistro.datakeeper.utils;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.softbistro.datakeeper.model.DataType;

@SpringBootTest
public class ParseUtilTest {

	
	@Test
	public void givenStringValueNativeDataTypeIsDate() {
		String value = "12/12/2014";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertEquals(dataType, DataType.Date);
	}

	@Test
	public void givenStringValueNativeDataTypeIsString() {
		String value = "data";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertEquals(dataType, DataType.String);
	}

	@Test
	public void givenStringValueNativeDataTypeIsChar() {
		String value = "d";
		DataType dataType = ParseUtil.getNativeDataType("d");
		assertEquals(dataType, DataType.Character);
	}

	@Test
	public void givenStringValueNativeDataTypeIsDouble() {
		String value = "13.45654";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertEquals(dataType, DataType.Double);
	}
	
	@Test
	public void givenStringValueNativeDataTypeIsInteger() {
		String value = "14345";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertEquals(dataType, DataType.Integer);
	}

	@Test
	public void givenStringValueNativeDataTypeIsBoolean() {
		String value = "false";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertEquals(dataType, DataType.Boolean);
	}
	
	@Test
	public void givenStringValueNativeDataTypeIsNotDate() {
		String value = "197/1245/254014";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertNotEquals(dataType, DataType.Date);
	}

	@Test
	public void givenStringValueNativeDataTypeIsNotString() {
		String value = "1215458";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertNotEquals(dataType, DataType.String);
	}

	@Test
	public void givenStringValueNativeDataTypeIsNotChar() {
		String value = "3";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertNotEquals(dataType, DataType.Character);
	}

	@Test
	public void givenStringValueNativeDataTypeIsNotDouble() {
		String value = "13/45654";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertNotEquals(dataType, DataType.Double);
	}
	
	@Test
	public void givenStringValueNativeDataTypeIsNotInteger() {
		String value = "14345.1";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertNotEquals(dataType, DataType.Integer);
	}

	@Test
	public void givenStringValueNativeDataTypeIsNotBoolean() {
		String value = "not true";
		DataType dataType = ParseUtil.getNativeDataType(value);
		assertNotEquals(dataType, DataType.Boolean);
	}
	
	
}
