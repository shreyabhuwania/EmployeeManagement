package employee;

import java.sql.*;//gives java database connectivity api
public class DBConnection {
	static Connection conn;
//	public static void main(String[] args) {
//        // Test database connection
//        DBConnection.createDBConnection();
//    }
	public static Connection createDBConnection() {
		
			//get connection
			String dbURL = "jdbc:mysql://localhost:3306/employeedb";
			String dbUname = "root";
			String dbPass = "Parkar@123";
			
//			String query="select * from employee";
			try {
				
				//load mysql type 4 Driver
//				Class.forName("com.mysql.jdbc.Driver");
				
				//establish connection
				conn = DriverManager.getConnection(dbURL,dbUname,dbPass);
				
				//create a statement
	//			Statement st = conn.createStatement();
				
	//			ResultSet rs= st.executeQuery(query);
				
	//			while(rs.next()) {
	//				
	//				
	//			}
				if(conn !=null){
					System.out.println("Connected to the database!");
				}
			}
			catch(SQLException ex){
				
				System.out.println("An error occurred while trying to connect!");
				System.out.println(ex.getMessage());
				
			}
			return conn;
		}
	}
