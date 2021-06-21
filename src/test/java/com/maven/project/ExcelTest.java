package com.maven.project;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelTest {

	static Workbook workbook;
	static Sheet sheetAt;
	
	public static void main(String[] args) {
		ExcelUtil util = new ExcelUtil("./credintials.xlsx", "Sheet1");
		workbook = ExcelUtil.workbook;
		sheetAt = ExcelUtil.sheetAt;
		
		int rowCount = util.getRowCount();
		for (int i = 1; i < rowCount; i++) {			
			Row row = sheetAt.getRow(i);			
			int cellSize = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellSize; j++) {
				System.out.println(util.getCellData(i,j));
			}			
		}		
	}
}
