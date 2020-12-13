package com.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBCDriverSelect {
	public static void main(String[] args) {
		PreparedStatement pa;

		Connection connection = null;

		try {//get table from database
			Class.forName("com.mysql.cj.jdbc.Driver");  //loads driver
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students"
					, "root", "razendra");

			String query = "select * from capital";  //query to database
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

		
	}

}
