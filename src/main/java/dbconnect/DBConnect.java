package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static Connection conn=null;
	public static Connection getConnect() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/excel","root","mkpmohan");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
