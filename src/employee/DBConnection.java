package employee;

import java.sql.*;//gives java database connectivity api

public final class DBConnection {
	static Connection connection;
	
	private DBConnection() {

	}
	public static Connection createDBConnection() {// make it singleton class
		try {
			if ( connection == null) {
				
				String dbURL = "jdbc:mysql://localhost:3306/employeedb";
				String dbUname = "root";
				String dbPass = "Parkar@123";
				connection=DriverManager.getConnection(dbURL, dbUname, dbPass);
				System.out.println("Connected to the database!");
				}
		} catch (SQLException ex) {

			System.out.println("An error occurred while trying to connect!");
			System.out.println(ex.getMessage());

		}
		return connection;
	}
}
