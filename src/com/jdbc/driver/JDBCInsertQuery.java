package com.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCInsertQuery {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pa;
		try {// insert into database

			Class.forName("com.mysql.cj.jdbc.Driver"); // driver loading
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students"
					,"root", "razendra"); // urltimezone,user,pass
			String query = "insert into capital"+" VALUES(20,'california',0,'sanfr')";
			pa = connection.prepareStatement(query);
//			pa.setInt(1, 340);
//			pa.setInt(2, 32);
//			pa.setString(3, "nyc");
			boolean result = pa.execute();
			// System.out.println(pa);
			if (!result)
				System.out.println("Success");
			else
				System.out.println("try again");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
