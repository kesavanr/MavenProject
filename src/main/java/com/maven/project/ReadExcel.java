package com.maven.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath=System.getProperty("user.dir") + "\\credintials.xlsx";
		System.out.println(filePath);
		File file = new File(filePath);
		FileInputStream fileInStr = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInStr);
		Sheet sheetAt = workbook.getSheetAt(0);
		int rowsSize = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsSize; i++) {
			Row row = sheetAt.getRow(i);
			int cellSize = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellSize; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if(cellType.equals(cellType.STRING)) {
					String value = cell.getStringCellValue();
					System.out.println(value);
				}
				else if(cellType.equals(cellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					long value = (long) numericCellValue;
					String valueOf = String.valueOf(value);
					System.out.println(valueOf);
				}
			}
		}
	/*	Row row1 = workbook.getSheetAt(0).createRow(rowsSize);
		row1.createCell(0).setCellValue("User4");
		row1.createCell(1).setCellValue("asasasa");
		
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();*/
	}

}
