package com.his.DBUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static Connection conn =null;
	public static Connection getConnection () throws SQLException
	{
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/his","root","root");
		return conn;		
	}
}
