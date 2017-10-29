package com.softbistro.datakeeper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.softbistro.datakeeper.common.interfaces.IGoogleSheetsWritingService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GoogleSheetsWritingServiceTest {
	
	private static final Logger logger = Logger.getLogger(GoogleSheetsWritingServiceTest.class);

	@Autowired
	private IGoogleSheetsWritingService googleSheetsWritingService;
		

	@Test
	public void writeSheetTest() {
		
		List<List<Object>> listWithoutData = new ArrayList<>();
		List<List<Object>> listFullData = new ArrayList<>();	
		List<List<Object>> listWithGaps = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			List<Object> tempList = new ArrayList<>();
			
			tempList.add(i+1);
			tempList.add("Test Username " + i);
			tempList.add("Test Password " + i);
			tempList.add("Test Name " + i);
			tempList.add(LocalDateTime.now().toString());
			
			listFullData.add(tempList);
			listWithGaps.add(tempList);
		}
		
		listWithGaps.add(new ArrayList<>());
		listWithGaps.add(new ArrayList<>());
		
		for(int i=0; i<5; i++) {
			List<Object> tempList = new ArrayList<>();
			
			if(i == 0) {
				tempList.add(0);
				tempList.add("Test Username " + i);
				tempList.add("Test Password " + i);
				tempList.add("Test Name " + i);
				tempList.add(null);
				
			} else if(i == 3) {
				tempList.add(i+1);
				tempList.add("");
				tempList.add("");
				tempList.add("");
				tempList.add(LocalDateTime.now().toString());
			} else {
				tempList.add(i+1);
				tempList.add("Test Username " + i);
				tempList.add("Test Password " + i);
				tempList.add("Test Name " + i);
				tempList.add(LocalDateTime.now().toString());
			}
			
			listWithGaps.add(tempList);
		}
		
		try {
			assertThat(googleSheetsWritingService.writeSheet(listWithoutData, "Spreadsheet Without Data"))
				.as("Test whether list withou data will be writed into Google Sheets spreadsheet")
				.isTrue();
			
			assertThat(googleSheetsWritingService.writeSheet(listFullData, "Spreadsheet With Data"))
				.as("Test whether list full with data will be writed into Google Sheets spreadsheet")
				.isTrue();
			
			assertThat(googleSheetsWritingService.writeSheet(listWithGaps, "Spreadsheet With Gaps In Data"))
				.as("Test whether list with data and gaps in data will be writed into Google Sheets spreadsheet")
				.isTrue();
			
		} catch (IOException | GeneralSecurityException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}

	}
	
}
