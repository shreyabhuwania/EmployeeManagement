package employee;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int id;
		String name, panNo, highestEducation, address, skills;
		Long aadharNo;
		int passingYear;
		
		JoineeImpl crudOperations = new JoineeImpl();
		System.out.println("Welcome to Employee management application");
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("1. Add Employee details\n" + "2. Show All Employee\n"
						+ "3. Show Employee based on id \n" + "4. Update the employee\n" + "5. Delete the employee\n");

				System.out.println("Enter Choice: ");
				int operationChoice = scanner.nextInt();
				char choice;
				Joinee joineeInfo = new Joinee();

				switch (operationChoice) {
				case 1:

					System.out.println("Enter 1 to enter details manually ");
					System.out.println("Enter 2 to add data file to the database");
					int a = scanner.nextInt();
					switch (a) {
					case 1:
						do {
							System.out.println("Enter id: ");
							joineeInfo.setId(scanner.nextInt());
							System.out.println("Enter name ");
							joineeInfo.setName(scanner.next());
							System.out.println("Enter pan_no: ");
							joineeInfo.setPanNo(scanner.next());
							System.out.println("Enter aadhar_no: ");
							joineeInfo.setAadharNo(scanner.nextLong());
							System.out.println("Enter address");
							joineeInfo.setAddress(scanner.next());
							System.out.println("Enter highest_education: ");
							joineeInfo.setHighestEducation(scanner.next());
							System.out.println("Enter passing_year: ");
							joineeInfo.setPassingYear(scanner.nextInt());
							System.out.println("Enter skills: ");
							joineeInfo.setSkills(scanner.next());
							crudOperations.createJoinee(joineeInfo);
							System.out.println("Do you want to continue choose y/n?");
							choice = scanner.next().charAt(0);
						} while (choice == 'y');
						break;
					case 2:
//								//to add data through file
//								System.out.println("Enter the file path: ");
//								String filepath=sc.next();
//								String excelPath="output.xlsx";
//							    convertFileToExcel(filePath,excelPath);
//							    readExcelFile(excelPath,obj);
						break;
					default:
						System.out.println("Invalid input");
						break;
					}
				case 2:
					crudOperations.showAllJoinee();
					break;
				case 3:
					System.out.println("Enter id to show the details");
					id = scanner.nextInt();
					crudOperations.showJoineeBasedOnID(id);
					break;
				case 4:
					System.out.println("Enter id to update the details");
					id = scanner.nextInt();
					joineeInfo.setId(id);
					System.out.println("Enter name ");
					name = scanner.next();
					joineeInfo.setName(name);
					System.out.println("Enter pan_no: ");
					panNo = scanner.next();
					joineeInfo.setPanNo(panNo);
					System.out.println("Enter aadhar_no: ");
					aadharNo = scanner.nextLong();
					joineeInfo.setAadharNo(aadharNo);
					System.out.println("Enter address");
					address = scanner.next();
					joineeInfo.setAddress(address);
					System.out.println("Enter highest_education: ");
					highestEducation = scanner.next();
					joineeInfo.setHighestEducation(highestEducation);
					System.out.println("Enter passing_year: ");
					passingYear = scanner.nextInt();
					joineeInfo.setPassingYear(passingYear);
					System.out.println("Enter skills: ");
					skills = scanner.next();
					joineeInfo.setSkills(skills);
					crudOperations.updateJoinee(joineeInfo, id, name, panNo, aadharNo, address, highestEducation,
							passingYear, skills);
					break;
				case 5:
					System.out.println("Enter the id to delete");
					id = scanner.nextInt();
					crudOperations.deleteJoinee(id);
					break;
				case 6:
					System.out.println("Thankyou for using my application!!");
					System.exit(0);
					break;
				default:
					System.out.println("Please Enter valid choice!");
					break;
				}
			} while (true);
		} // try block ends

	}// main method ends

}// class ends
