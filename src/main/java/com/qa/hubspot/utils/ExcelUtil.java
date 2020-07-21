package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	private static String TEST_DATA_SHEET_PATH = "./src/main/java/com/qa/hubspot/testdata/HubSpotTestData.xlsx";
	public static void getTestData(String sheetName) {
		
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			WorkbookFactory.create(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
