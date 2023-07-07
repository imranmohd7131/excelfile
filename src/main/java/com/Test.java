package com;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {
		String excelpath="./data/Read.xlsx";
		String sheetName="Sheet1";
		ExcelFileInsertDB obj=new ExcelFileInsertDB(excelpath,sheetName);
		obj.getCallData();
		obj.getRowCount();
	}
}
