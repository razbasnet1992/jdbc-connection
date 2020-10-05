package com.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBCDriver {
	public static void main(String[] args) {
		PreparedStatement pa;

		Connection connection = null;

		try {//get table from database
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?"
					+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
					+ "serverTimezone=UTC", "root", "razendra");

			String query = "select * from capital";
			pa = connection.prepareStatement(query);
			System.out.println(pa);
			pa.execute();
			ResultSet rs = pa.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			// Iterate through the data in the result set and display it.

			while (rs.next()) {
				// Print one row
				for (int i = 1; i <= columnsNumber; i++) {

					System.out.print(rs.getString(i) + " "); // Print one element of a row

				}

				System.out.println();// Move to the next line to print the next row.

			}

		} catch (Exception e) {
			System.out.println(e);

		}

		try {//insert into database

			Class.forName("com.mysql.cj.jdbc.Driver"); //driver loading
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?"
					+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
					+ "serverTimezone=UTC", "root", "razendra"); //urltimezone,user,pass
			String query = "insert capital (size,idcapital,state) VALUES(?,?,?)";
			pa = connection.prepareStatement(query);
			pa.setString(1, "chicago");
			pa.setInt(2, 90);
			pa.setInt(3, 10);
			boolean result = pa.execute();
			// System.out.println(pa);
			if (result)
				System.out.println("Success");
			else
				System.out.println("try again");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
