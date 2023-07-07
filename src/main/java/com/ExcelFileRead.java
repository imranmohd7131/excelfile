package com;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {

	public static void main(String[] args) throws SQLException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook("./data/Read.xlsx");
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		DataFormatter formatter=new DataFormatter(); 	
		int rows=sheet.getLastRowNum();
	
		for(int i=0;i<=rows;i++) {
		 for(int j=0;j<=3;j++) {
			Object value=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			System.out.print(value+"\n");
		}
	   }
	}
}