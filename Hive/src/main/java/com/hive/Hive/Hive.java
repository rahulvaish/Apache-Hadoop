package com.hive.Hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hive {

	//private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		// Register driver and create driver instance
		Class.forName(driverName);
		// get connection
		Connection con = DriverManager.getConnection(
				"jdbc:hive2://localhost:10000/default", "", "");
		Statement stmt = con.createStatement();		
		String sql = "select * from empdb.employee where age >'10'";
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
		}
		res.close();
		stmt.close();
		con.close();
	}
}
