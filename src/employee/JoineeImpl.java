package employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.PreparedStatement;

//implemented this class as a singleton to ensure only one instance exists
public class JoineeImpl implements JoineeInterf {

	public static final Logger logger = Logger.getLogger(JoineeImpl.class.getName());
	private final Connection con;

	// creating single instance of class dbconnection
	public JoineeImpl() {
		this.con = DBConnection.createDBConnection();
	}

	@Override
	public void createJoinee(Joinee j) {

		String query = "insert into joinee values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, j.getId());
			pstm.setString(2, j.getName());
			pstm.setString(3, j.getPan_no());
			pstm.setLong(4, j.getAadhar_no());
			pstm.setString(5, j.getAddress());
			pstm.setString(6, j.getHighest_education());
			pstm.setInt(7, j.getPassing_year());
			pstm.setString(8, j.getSkills());
			int cnt = pstm.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee Inserted succsessfully !!");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error inserting joinee", ex);
			// ex.printStackTrace();
		}
	}
	// Method to convert file to Excel
//	public static void convertFileToExcel(String inputFilePath, String outputExcelFilePath) {
	
	// Method to read values from Excel file and add to database
//	public static void readExcelFile(String excelFilePath, JoineeImpl obj) {
	@Override
	public void showAllJoinee() {
//		con = DBConnection.createDBConnection();
		String query = "select * from joinee";
		System.out.println("Joinee Details :");
		System.out
				.println("-------------------------------------------------------------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "Name", "Pan", "Aadhar", "Address", "Education",
				"PassYear", "Skills");
		System.out
				.println("-------------------------------------------------------------------------------------------");
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {// use alternative for while
				System.out.format("%d\t%s\t%s\t%d\t%s\t%s\t%d\t%s\n", result.getInt(1), result.getString(2),
						result.getString(3), result.getLong(4), result.getString(5), result.getString(6),
						result.getInt(7), result.getString(8));
				System.out.println(
						"------------------------------------------------------------------------------------");
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error retrieving joinee details", ex);
			// ex.printStackTrace();
		}
	}

	@Override
	public void showJoineeBasedOnID(int id) {
//		con = DBConnection.createDBConnection();
		String query = "select * from joinee where id=" + id;
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);// use alternative
			while (result.next()) {
				System.out.format("%d\t%s\t%s\t%d\t%s\t%s\t%d\t%s\n", result.getInt(1), result.getString(2),
						result.getString(3), result.getLong(4), result.getString(5), result.getString(6),
						result.getInt(7), result.getString(8));
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error retrieving joinee based on ID", ex);
			// ex.printStackTrace();
		}
	}

	@Override
	public void updateJoinee(int id, String name) {
//		con = DBConnection.createDBConnection();
		String query = "update joinee set name=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			int cnt = pstm.executeUpdate();// check if not using executeupdate
			if (cnt != 0)
				System.out.println("Employee Details updated successfully !!");

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error updating joinee details", ex);
			// ex.printStackTrace();
		}
	}

	@Override
	public void deleteJoinee(int id) {
//		con = DBConnection.createDBConnection();
		String query = "delete from joinee where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			int cnt = pstm.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee Deleted Successfully!!! " + id);

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error deleting joinee", ex);
			// ex.printStackTrace();
		}
	}

}
