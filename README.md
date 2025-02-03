# Employee Management System

## Introduction
The Employee Management System is a Java-based application that provides functionalities to manage employee details. This system uses a MySQL database named `employeedb` and connects to the database using JDBC.

## Database Schema

### Table: Joinee
```sql
CREATE TABLE Joinee (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeName VARCHAR(255),
    PAN_No VARCHAR(255) UNIQUE,
    AADHAR_Card_No VARCHAR(12) UNIQUE,
    Highest_Education VARCHAR(50),
    Year_of_Passing INT,
    Permanent_Address VARCHAR(255),
    Expertise_or_Skills VARCHAR(255)
);
```

## Technologies Used
- **Java:** The core programming language used to develop the application.
- **JDBC:** Java Database Connectivity API for connecting to the MySQL database.
- **MySQL:** The relational database management system used to store employee data.
- **Apache POI:** Library for reading and writing Excel files (if applicable).

## Functionalities
The Employee Management System provides the following functionalities:

1. **Add Employee Details:**
    Manually enter employee details or import from a file.
   
2. **Show All Employees:**
    Display all employee details stored in the database.

3. **Show Employee Based on ID:**
    Retrieve and display details of a specific employee by their Employee ID.

4. **Update Employee Details:**
    Update the name and other details of an employee based on their Employee ID.

5. **Delete Employee:**
    Remove an employee's details from the database based on their Employee ID.

## Getting Started

### Prerequisites
- **Java Development Kit (JDK):** Ensure JDK is installed on your system.
- **MySQL Server:** Ensure MySQL server is installed and running.
- **JDBC Driver:** Download and add the MySQL JDBC driver to your project classpath.
- **Apache POI:** Include Apache POI library for Excel file operations.

### Setup
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/shreyabhuwania/EmployeeManagement.git
   cd EmployeeManagement
   ```

2. **Create Database:**
   - Log in to MySQL and create the database:
     ```sql
     CREATE DATABASE employeedb;
     ```
   - Use the database:
     ```sql
     USE employeedb;
     ```
   - Create the `Joinee` table:
     ```sql
     CREATE TABLE Joinee (
         EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
         EmployeeName VARCHAR(255),
         PAN_No VARCHAR(255) UNIQUE,
         AADHAR_Card_No VARCHAR(12) UNIQUE,
         Highest_Education VARCHAR(50),
         Year_of_Passing INT,
         Permanent_Address VARCHAR(255),
         Expertise_or_Skills VARCHAR(255)
     );
     ```

3. **Configure Database Connection:**
   - Update the JDBC connection settings in your Java code with the appropriate database URL, username, and password.
   ```java
   String jdbcUrl = "jdbc:mysql://localhost:3306/employeedb";
   String jdbcUsername = "yourUsername";
   String jdbcPassword = "yourPassword";
   ```

### Running the Application
- Compile and run the `Main` class to start the Employee Management System.
- Follow the on-screen menu to perform various operations like adding (manually or through file), updating, viewing, and deleting employee details.


---

Feel free to customize this README file according to your project specifics. If you need any further assistance or modifications, let me know! 😊

