package employee;
import employee.DBConnection;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JoineeImpl implements JoineeInterf {

	public static final Logger LOGGER = Logger.getLogger(JoineeImpl.class.getName());// when is static initialized?
	private static final Connection CONNECTION = DBConnection.createDBConnection();
	

	@Override
	public void createJoinee(Joinee joinee) {

		String query = "insert into joinee values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement updateStatement = CONNECTION.prepareStatement(query);
			updateStatement.setInt(1, joinee.getId());
			updateStatement.setString(2, joinee.getName());
			updateStatement.setString(3, joinee.getPanNo());
			updateStatement.setLong(4, joinee.getAadharNo());
			updateStatement.setString(5, joinee.getAddress());
			updateStatement.setString(6, joinee.getHighestEducation());
			updateStatement.setInt(7, joinee.getPassingYear());
			updateStatement.setString(8, joinee.getSkills());
			int cnt = updateStatement.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee Inserted succsessfully !!");
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Error inserting joinee", ex);

		}
	}
	// Method to convert file to Excel

	public static void convertFileToExcel(String inputFilePath, String outputExcelFilePath) {
	   try {
      	   SingletonFileInputStream sfis = SingletonFileInputStream.getInstance(inputFilePath);
           SingletonWorkbook sWorkbook = SingletonWorkbook.getInstance(sfis.getFileInputStream());
           FileOutputStream fos = new FileOutputStream(outputExcelFilePath);
           XSSFWorkbook newWorkbook = new XSSFWorkbook();
	            Workbook workbook = sWorkbook.getWorkbook();
	            Sheet sheet = newWorkbook.createSheet("Sheet1");
	            Sheet inputSheet = workbook.getSheetAt(0);
	            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {
	                Row inputRow = inputSheet.getRow(i);
	                Row outputRow = sheet.createRow(i);
	                for (int j = 0; j < inputRow.getPhysicalNumberOfCells(); j++) {
	                    Cell inputCell = inputRow.getCell(j);
	                    Cell outputCell = outputRow.createCell(j);
	                    outputCell.setCellValue(inputCell.toString());
	                }
	            }
	            newWorkbook.write(fos);
	            System.out.println("File converted to Excel format.");
	        } catch (Exception ex) {
	            LOGGER.log(Level.SEVERE, "Error converting file to Excel", ex);
	        }
	
	    }
	// Method to read values from Excel file and add to database

	public static void readExcelFile(String excelFilePath, JoineeImpl obj) {
		FileInputStream file = null;
		Workbook workbook = null;
	    try  {
	    	 file = new FileInputStream(new File(excelFilePath));
	         workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheetAt(0);
	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) {
	                continue; // Skip header row
	            }
	            Joinee joinee = new Joinee();
	            joinee.setId((int) row.getCell(0).getNumericCellValue());
	            joinee.setName(row.getCell(1).getStringCellValue());
	            joinee.setPan_no(row.getCell(2).getStringCellValue());
	            joinee.setAadharNo((long) row.getCell(3).getNumericCellValue());
	            joinee.setAddress(row.getCell(4).getStringCellValue());
	            joinee.setHighestEducation(row.getCell(5).getStringCellValue());
	            joinee.setPassingYear((int) row.getCell(6).getNumericCellValue());
	            joinee.setSkills(row.getCell(7).getStringCellValue());
	            obj.createJoinee(joinee);
	        }
	        System.out.println("Excel data imported successfully!");
	    } catch (Exception ex) {
	        LOGGER.log(Level.SEVERE, "Error reading Excel file", ex);
	    }
	}

	@Override
	public void showAllJoinee() {
		String query = "select * from joinee";
		System.out.println("Joinee Details :");
		System.out
				.println("-------------------------------------------------------------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "Name", "Pan", "Aadhar", "Address", "Education",
				"PassYear", "Skills");
		System.out
				.println("-------------------------------------------------------------------------------------------");
		try {
			Statement queryStatement = CONNECTION.createStatement();
			ResultSet queryResult = queryStatement.executeQuery(query);
			while (queryResult.next()) {
				System.out.format("%d\t%s\t%s\t%d\t%s\t%s\t%d\t%s\n", queryResult.getInt(1), queryResult.getString(2),
						queryResult.getString(3), queryResult.getLong(4), queryResult.getString(5),
						queryResult.getString(6), queryResult.getInt(7), queryResult.getString(8));
				System.out.println(
						"------------------------------------------------------------------------------------");
			}
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Error retrieving joinee details", ex);

		}
	}

	@Override
	public void showJoineeBasedOnID(int id) {
		String query = "select * from joinee where id=" + id;
		try {
			Statement queryStatement = CONNECTION.createStatement();
			ResultSet queryResult = queryStatement.executeQuery(query);
			while (queryResult.next()) {
				System.out.format("%d\t%s\t%s\t%d\t%s\t%s\t%d\t%s\n", queryResult.getInt(1), queryResult.getString(2),
						queryResult.getString(3), queryResult.getLong(4), queryResult.getString(5),
						queryResult.getString(6), queryResult.getInt(7), queryResult.getString(8));
			}
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Error retrieving joinee based on ID", ex);

		}
	}

	@Override
	public void updateJoinee(Joinee joinee, int id, String name, String panNo, long aadharNo, String address,
			String highestEducation, int passingYear, String skills) {
		String query = "UPDATE joinee SET name=?, pan_no=?, aadhar_no=?, address=?, highest_education=?, passing_year=?, skills=? where id=?";
		try {
			PreparedStatement updateStatement = CONNECTION.prepareStatement(query);
			updateStatement.setString(1, name);
			updateStatement.setString(2, panNo);
			updateStatement.setLong(3, aadharNo);
			updateStatement.setString(4, address);
			updateStatement.setString(5, highestEducation);
			updateStatement.setInt(6, passingYear);
			updateStatement.setString(7, skills);
			updateStatement.setInt(8, id);

			if (updateStatement.executeUpdate() != 0)
				System.out.println("Employee Details updated successfully !!");

		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Error updating joinee details", ex);

		}
	}

	@Override
	public void deleteJoinee(int id) {
		String query = "delete from joinee where id=?";
		try {
			PreparedStatement queryStatement = CONNECTION.prepareStatement(query);
			queryStatement.setInt(1, id);
			int cnt = queryStatement.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee Deleted Successfully!!! " + id);

		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Error deleting joinee", ex);

		}
	}

}
