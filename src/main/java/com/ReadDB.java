package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconnect.DBConnect;

public class ReadDB {
	    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	    Connection conn=DBConnect.getConnect();
    	String sql="Select * from exceldata";
    	Statement st=conn.createStatement();
    	ResultSet rs=st.executeQuery(sql); 	
    	while(rs.next()) {
    		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
    	}
    }
}
