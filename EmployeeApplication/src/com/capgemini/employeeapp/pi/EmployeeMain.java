package com.capgemini.employeeapp.pi;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.employeeapp.bean.EmployeeBean;
import com.capgemini.employeeapp.exception.EmployeeException;
import com.capgemini.employeeapp.service.EmployeeServiceImpl;
import com.capgemini.employeeapp.service.IEmployeeService;

public class EmployeeMain {

	static Scanner sc = new Scanner(System.in);
	static IEmployeeService employeeService = null;
	static EmployeeServiceImpl employeeServiceImpl = null;
	static Logger logger = Logger.getRootLogger();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("resources//log4j.properties");
		EmployeeBean employeeBean = null;
		employeeService = new EmployeeServiceImpl();

		Integer employeeId = null;
		int option = 0;
		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("    CAPGEMINI EMPLOYEE TRUST ");
			System.out.println("_______________________________\n");

			System.out.println("1.Add Employee ");
			System.out.println("2.View Employee Details");
			System.out.println("3.Retrieve All Employee Details");
			System.out.println("4.Exit");
			System.out.println("________________________________");
			
			System.out.println("Select an option:");
			// accept option

			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					while (employeeBean == null) {
						employeeBean = populateEmployeeBean();
					}
					try {
						
						employeeId = employeeService
								.addEmployeeDetails(employeeBean);
						System.out
								.println("Employee details  has been successfully registered ");
						System.out.println("Employee  ID Is: " + employeeId);

					} catch (EmployeeException employeeException) {
						logger.error("exception occured", employeeException);
						System.out.println("ERROR : "
								+ employeeException.getMessage());
					} finally {
						employeeId = null;
						employeeService = null;
						employeeBean = null;
					}
					break;
				default:
					System.out.println("Enter a valid option[1-4]");
				}// end of switch
			}// end of try
			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}
		}// end of while
	}// end of main


	private static EmployeeBean populateEmployeeBean() {

		// Reading and setting the values for the donorBean

		EmployeeBean employeeBean = new EmployeeBean();
		System.out.println("\n Enter Details");

		System.out.println("Enter employee name: ");
		employeeBean.setEmployeeName(sc.next());

		employeeServiceImpl = new EmployeeServiceImpl();

		try {
			// Validate employee bean
			employeeServiceImpl.validateEmployee(employeeBean);
			return employeeBean;
		} catch (EmployeeException employeeException) {
			logger.error("exception occured", employeeException);
			System.err.println("Invalid data:");
			System.err.println(employeeException.getMessage()
					+ " \n Try again..");
			System.exit(0);

		}
		return null;

	}
}

