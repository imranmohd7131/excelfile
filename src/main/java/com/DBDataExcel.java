package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dbconnect.DBConnect;

public class DBDataExcel {
	public static void main(String[] args) throws SQLException, IOException {
	
		String excelFilePath = "Student.xlsx";
		Connection conn=DBConnect.getConnect();
    	String sql="Select * from exceldata";
    	Statement st=conn.createStatement();
    	ResultSet rs=st.executeQuery(sql);
    	
    	XSSFWorkbook workbook=new XSSFWorkbook(); //create workbook in .xlsx format
		XSSFSheet sheet=workbook.createSheet("Invoices");  //create  sheet
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("RollNo");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Class");
		row.createCell(3).setCellValue("Address");
		int r=1;
		while(rs.next()){
			int rNo=rs.getInt("RollNo");
			String name=rs.getString("Name");
			int cls=rs.getInt("Class");
		    String add=rs.getString("Address");
		    
		    row=sheet.createRow(r++);
		    row.createCell(0).setCellValue(rNo);
		    row.createCell(1).setCellValue(name);
		    row.createCell(2).setCellValue(cls);
		    row.createCell(3).setCellValue(add);
		}
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        st.close();
		
		}
}