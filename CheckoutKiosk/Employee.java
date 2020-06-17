//*******************************************************************
// Employee.java
//
// An Employee class that extends the Person superclass with an
// overwritten editDetails() method.
// 
// By: Malik Waller 
// Date: 6/16/2020
//*******************************************************************

package checkoutKiosk;

import java.util.Scanner;

public class Employee extends Person {

	// Class-specific State fields
	private String department;
	private String position;

	// Constructor; becomes "Employee" personType
	public Employee(String firstName, String lastName, String department, String position) {
		super(firstName, lastName);
		this.personType = "Employee";
		this.department = department;
		this.position = position;
	}

	// State methods for populating object data

	// Getter and setter methods for department
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// Getter and setter methods for position
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	// Method to edit multiple details of the person object at once
	public void editDetails(Scanner inputDetails) {

		System.out.println("Changing multiple details for employee " + firstName + " " + lastName);

		System.out.print("Enter employee's first name: ");
		this.firstName = inputDetails.next();

		System.out.print("Enter " + firstName + "'s last name: ");
		this.lastName = inputDetails.next();

		System.out.print("Enter " + firstName + "'s phone number: ");
		this.phoneNumber = inputDetails.nextInt();

		System.out.print("Enter " + firstName + "'s email address: ");
		this.emailAddress = inputDetails.next();

		System.out.print("Enter " + firstName + "'s department: ");
		this.department = inputDetails.next();

		System.out.print("Enter " + firstName + "'s position: ");
		this.position = inputDetails.next();

		System.out.print("Changes have been applied!");
	}

	// Method to print the details of the person object
	public String toString() {
		return "ID: " + personID + "\nType: " + personType + "\nName: " + firstName + " " + lastName + "\nPhone: "
				+ phoneNumber + "\nEmail: " + emailAddress + "\nDepartment: " + department + "\nPosition: " + position
				+ "\nRewards Number: " + rewardsNumber;
	}

}
