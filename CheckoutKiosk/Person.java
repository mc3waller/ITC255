//*******************************************************************
// Person.java
//
// A superclass for the Customer and Employee subclasses with
// generalized state and behavior code and a Scanner-based method
// for changing multiple details in one process.
// 
// By: Malik Waller 
// Date: 6/16/2020
//*******************************************************************

package checkoutKiosk;

import java.util.*;

public class Person {

	// Scanner import for editing object state details in one single method
	Scanner console = new Scanner(System.in);

	// State fields
	protected int personID;
	protected String personType;
	protected String firstName;
	protected String lastName;
	protected int phoneNumber;
	protected String emailAddress;
	public int rewardsNumber;

	// Constructor; personType set to "Undefined" and an N/A emailAddress
	public Person(String firstName, String lastName) {

		this.personID = setPersonID();
		this.personType = "Undefined";
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = "N/A";
	}

	// State methods for populating object data

	// Setter method that auto-generates an ID for the person object
	private int setPersonID() {
		return this.personID = (int) (Math.random() * ((9999 - 1000) + 1));
	}

	// Getter and setter methods for personType
	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	// Getter and setter methods for firstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Getter and setter methods for lastName
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Getter and setter methods for phoneNumber
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Getter and setter methods for emailAddress
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	// Getter method for rewardsNumber
	public int getRewardsNumber() {
		return rewardsNumber;
	}

	// Setter method that auto-generates a rewardsNumber for the person object
	public int setRewardsNumber() {
		return this.rewardsNumber = (int) (Math.random() * ((999999999 - 100000000) + 1));
	}

	// Method to edit multiple details of the person object at once
	public void editDetails(Scanner console) {

		System.out.println("Changing multiple details for " + firstName + " " + lastName);

		System.out.print("Enter person's first name: ");
		this.firstName = console.next();

		System.out.print("Enter " + firstName + "'s last name: ");
		this.lastName = console.next();

		System.out.print("Enter " + firstName + "'s phone number: ");
		this.phoneNumber = console.nextInt();

		System.out.print("Enter " + firstName + "'s email address: ");
		this.emailAddress = console.next();

		System.out.print("Changes have been applied");
	}

	// Method to print the details of the person object
	public String toString() {
		return "ID: " + personID + "\nName: " + firstName + " " + lastName + "\nPhone: " + phoneNumber + "\nEmail: "
				+ emailAddress + "\nRewards Number: " + rewardsNumber;
	}

}