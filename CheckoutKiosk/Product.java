//*******************************************************************
// Product.java
//
// A Product class for creating product objects with generalized
// state and behavior code and a Scanner-based method for changing
// multiple details in one process.
// 
// By: Malik Waller 
// Date: 6/16/2020
//*******************************************************************

package checkoutKiosk;

import java.text.NumberFormat;
import java.util.Scanner;

public class Product {

	// Scanner import for editing object state details in one single method
	Scanner inputDetails = new Scanner(System.in);

	// State fields
	private int productID;
	private String productName;
	private String type;
	private double weight;
	protected double price;
	private boolean restriction;

	// Constructor
	public Product(String productName, String type, double weight, double price, boolean restriction) {
		this.productID = setProductID();
		this.productName = productName;
		this.type = type;
		this.weight = weight;
		this.price = price;
		this.restriction = restriction;
	}

	// State methods for populating object data

	// Setter method that auto-generates an ID for the product object
	private int setProductID() {
		return this.productID = (int) (Math.random() * ((9999 - 1000) + 1));
	}

	// Getter and setter for productName
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	// Getter and setter for type
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// Getter and setter for weight
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// Getter and setter for price
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Formats the OUTPUT of the price data
	public static String getPriceFormatted(double price) {
		String formattedPrice = NumberFormat.getCurrencyInstance().format(price);
		// Returns the result to setPrice() to pass its value to this.price
		return formattedPrice;
	}

	// Getter and setter methods for restriction
	public boolean getRestriction() {
		return restriction;
	}

	public void setRestriction(boolean restriction) {
		this.restriction = restriction;
	}

	// Method to edit multiple details of the product object at once
	public void editDetails(Scanner inputDetails) {

		System.out.println("Changing multiple details for " + productName + ": ");

		System.out.print("Enter product name: ");
		productName = inputDetails.next();

		System.out.print("Enter product type for " + productName + ": ");
		type = inputDetails.next();

		System.out.print("Enter weight for " + productName + ": ");
		weight = inputDetails.nextDouble();

		System.out.print("Enter price for " + productName + ": ");
		price = inputDetails.nextDouble();

		System.out.print("Enter restriction status for " + productName + "(true or false): ");
		restriction = inputDetails.nextBoolean();

		System.out.print("Changes have been applied!");
	}

	// Method to print the details of the product object
	public String toString() {
		return "ID: " + productID + "\nName: " + productName + "\nType: " + type + "\nWeight: " + weight + " lbs"
				+ "\nPrice: " + getPriceFormatted(price) + "\nRestricted: " + restriction;
	}

}
