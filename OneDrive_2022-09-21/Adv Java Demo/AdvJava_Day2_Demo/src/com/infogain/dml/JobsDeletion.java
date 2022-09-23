package com.infogain.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JobsDeletion {
	public static void main(String args[]) {
		try {
			String str = "Delete from jobs where job_id='AC'";
			/* Initialize and load the JDBC-ODBC Bridge driver */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Establish a connection with a data source */
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/xe", "system", "hr");
			/* Create a Statement object to process the SELECT statement */
			Statement stmt = con.createStatement();
			/* Execute the SELECT SQL statement */
			int record = stmt.executeUpdate(str);
			System.out.println(record + "Record deleted Successfully");
			con.close();
		}

		catch (Exception ex) {
			System.out.println("Error occurred");
			System.out.println("Error:" + ex);
		}

	}
}
