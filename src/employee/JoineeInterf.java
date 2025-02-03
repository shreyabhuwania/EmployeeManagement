package employee;

public interface JoineeInterf {

	//dont use static with any method because static methods cannot be abstract
	public void createJoinee(Joinee j);
	public void showAllJoinee();
	public void showJoineeBasedOnID(int id);
	public void updateJoinee(int id,String name);
	public void deleteJoinee(int id);
//	void convertFileToExcel(String inputFilePath, String outputExcelFilePath);
//    void readExcelFile(String excelFilePath, JoineeImpl obj);
	
}
