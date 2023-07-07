package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dbconnect.DBConnect;

public class ExcelFileInsertDB {
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	public ExcelFileInsertDB(String excelpath,String sheetName) {
		try {
			 workbook = new XSSFWorkbook(excelpath);
			 sheet=workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public  void getCallData() throws SQLException {
			
			int rows=sheet.getLastRowNum();
			for(int i=1;i<=rows;i++) {
				XSSFRow row=sheet.getRow(i);
				double rNo=row.getCell(0).getNumericCellValue();
				String name=row.getCell(1).getStringCellValue();
				double cls=row.getCell(2).getNumericCellValue();
				String add=row.getCell(3).getStringCellValue();
				String sql="insert into exceldata values('"+rNo+"','"+name+"','"+cls+"','"+add+"')";
				Connection conn=DBConnect.getConnect();
				Statement stmt=conn.createStatement();
				int r=stmt.executeUpdate(sql);
				System.out.println(r+"affected");
			}
	}
	
	public  void getRowCount() {
	
		System.out.println("No. of Rows :"+sheet.getPhysicalNumberOfRows());
	}

}
