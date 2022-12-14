package com.scrollabledemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class UpdatableResultSet {
	public static void main(String args[]) {
	try {
// Initialize and load the JDBC-ODBC bridge driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish a connection with a database
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/xe", "system", "hr");
			// Create a Statement object
			Statement stmt = con.createStatement();
			
// Create an Updateable resultset
stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
			
			// Execute the SELECT statement to retrieve author information
			ResultSet rs = stmt
					.executeQuery("SELECT job_id, job_title FROM jobs WHERE job_id='Ac' ");

			rs.next();
			// Update data
			rs.updateString("job_title", "devloper");
			rs.updateRow();
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1
					.executeQuery("SELECT job_id, job_title FROM jobs WHERE job_id='Ac'");
			rs1.next();
			System.out.println(rs1.getString(1) + ", " + rs1.getString(2));
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
