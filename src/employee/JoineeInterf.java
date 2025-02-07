package employee;

public interface JoineeInterf {

	// dont use static with any method because static methods cannot be abstract
	public void createJoinee(Joinee j);

	public void showAllJoinee();

	public void showJoineeBasedOnID(int id);

	public void updateJoinee(Joinee j, int id, String name, String panNo, long aadharNo, String address, String highestEducation, int passingYear, String skills);

	public void deleteJoinee(int id);
//	void convertFileToExcel(String inputFilePath, String outputExcelFilePath);
//  void readExcelFile(String excelFilePath, JoineeImpl obj);

}
