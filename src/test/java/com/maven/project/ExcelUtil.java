package com.maven.project;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static Workbook workbook;
	static Sheet sheetAt;
	
	public ExcelUtil(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheetAt = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getRowCount() {
		int rows = sheetAt.getPhysicalNumberOfRows();
		return rows;
	}
	
	public static Object getCellData(int row, int col) {		
		DataFormatter dataFormater = new DataFormatter();
		Cell cell = sheetAt.getRow(row).getCell(col);
		Object value = dataFormater.formatCellValue(cell);
		return value;
	}
}
