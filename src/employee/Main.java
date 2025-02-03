package employee;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int id;
			JoineeImpl obj = new JoineeImpl();//creating object of joineeimpl class
			System.out.println("Welcome to Employee management application");
	        try (Scanner sc = new Scanner(System.in)) {
				do{
				    System.out.println("1. Add Employee details\n" +
				            "2. Show All Employee\n" +
				            "3. Show Employee based on id \n" +
				            "4. Update the employee\n" +
				            "5. Delete the employee\n");

				    System.out.println("Enter Choice: ");
				    int ch=sc.nextInt();
				    char c;
				    
				    switch (ch){
				        case 1:
				        	Joinee j = new Joinee();
				        	System.out.println("Enter 1 to enter details manually ");
							System.out.println("Enter 2 to add data file to the database");
							int a = sc.nextInt();
							switch(a) {
							case 1:
								do {
									System.out.println("Enter id: ");
					            	j.setId(sc.nextInt());
					            	System.out.println("Enter name ");
					            	j.setName(sc.next());
					            	System.out.println("Enter pan_no: ");
					            	j.setPan_no(sc.next());
					            	System.out.println("Enter aadhar_no: ");
					            	j.setAadhar_no(sc.nextLong());
					    			System.out.println("Enter address");
					    			j.setAddress(sc.next());
					    			System.out.println("Enter highest_education: ");
					    			j.setHighest_education(sc.next());
					    			System.out.println("Enter passing_year: ");
					    			j.setPassing_year(sc.nextInt());
					    			System.out.println("Enter skills: ");
					    			j.setSkills(sc.next());
					    			obj.createJoinee(j);//calling method of joineeimpl class
					    			System.out.println("Do you want to continue choose y/n?");
					    			c=sc.next().charAt(0);
					    			}while(c =='y');
								break;
							case 2:
//								//to add data through file
//								System.out.println("Enter the file path: ");
//								String filepath=sc.next();
//								String excelPath="output.xlsx";
////								convertFileToExcel(filePath,excelPath);
////								readExcelFile(excelPath,obj);
//								break;
							default:
								System.out.println("Invalid input");
								break;
							}
						case 2:
				        	obj.showAllJoinee();
				        	break;
				        case 3:
				        	System.out.println("Enter id to show the details");
				        	id=sc.nextInt();
				        	obj.showJoineeBasedOnID(id);
				        	break;
				        case 4:
				        	System.out.println("Enter id to update the details");
				        	id=sc.nextInt();
				        	System.out.println("Enter the new name");
				        	String name=sc.next();
				        	obj.updateJoinee(id,name);
				        	break;
				        case 5:
				        	System.out.println("Enter the id to delete");
				        	id=sc.nextInt();
				        	obj.deleteJoinee(id);
				        	break;
				        case 6:
				        	System.out.println("Thankyou for using my application!!");
				        	System.exit(0);
				        	break;
				        default:
				        	System.out.println("Please Enter valid choice!");
				        	break;
				        }
				    }while(true);
			}//try block ends
	        
	}//main method ends

}//class ends
