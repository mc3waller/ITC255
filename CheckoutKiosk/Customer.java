//*******************************************************************
// Customer.java
//
// A Customer class that extends the Person superclass with an
// overwritten editDetails() method.
// 
// By: Malik Waller 
// Date: 6/16/2020
//*******************************************************************

package checkoutKiosk;

import java.util.Scanner;

public class Customer extends Person {

	// Constructor; becomes "Customer" personType
	public Customer(String firstName, String lastName) {
		super(firstName, lastName);
		this.personType = "Customer";
	}

	// Method to edit multiple details of the customer object at once
	public void editDetails(Scanner console) {

		System.out.println("Changing multiple details for customer " + firstName + " " + lastName);

		System.out.print("Enter customer's first name: ");
		this.firstName = console.next();

		System.out.print("Enter " + firstName + "'s last name: ");
		this.lastName = console.next();

		System.out.print("Enter " + firstName + "'s phone number: ");
		this.phoneNumber = console.nextInt();

		System.out.print("Enter " + firstName + "'s email address: ");
		this.emailAddress = console.next();

		System.out.print("Changes have been applied!");
	}

	// Method to print the details of the customer object
	public String toString() {
		return "ID: " + personID + "\nType: " + personType + "\nName: " + firstName + " " + lastName + "\nPhone: "
				+ phoneNumber + "\nEmail: " + emailAddress + "\nRewards Number: " + rewardsNumber;
	}

}
