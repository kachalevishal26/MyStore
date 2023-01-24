package com.test.testutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.test.base.TestBase;

public class TestUtils extends TestBase {
	public static long EXPLICIT_WAIT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static Workbook book;
	public static Sheet sheet;

	public static String EXCEL_DATA_SHEET = "C:\\Users\\Asus\\eclipse-workspace\\MyStore\\src\\main\\java\\com\\test\\testutil\\MyStore.xlsx";

	public static Object[][] getData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(EXCEL_DATA_SHEET);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
}
