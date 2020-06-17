//*******************************************************************
// Transaction.java
//
// A class for creating Transaction instances with methods for
// managing details, payment, and an array list of Product objects.
// 
// By: Malik Waller 
// Date: 6/16/2020
//*******************************************************************

package checkoutKiosk;

import java.text.NumberFormat;
import java.util.*;

public class Transaction {

	// Scanner import for user input
	Scanner console = new Scanner(System.in);

	// Date object to return the date and time of creation
	Date currentDate = new Date();

	// An array that stores the purchased items
	ArrayList<Product> bag = new ArrayList<Product>();

	private int transactionID;
	private Date transactionDate;
	private int numberOfItems;
	private ArrayList<Product> itemsInBag;
	private double totalSavings;
	private double totalCost;
	private String transactionStatus;

	// Constructor
	public Transaction() {
		this.transactionID = setTransactionID();
		this.transactionDate = currentDate;
		this.numberOfItems = bag.size();
		this.itemsInBag = bag;
		this.transactionStatus = "In Progress";
	}

	// State methods for populating object data

	// Setter method that auto-generates an ID for the transaction instance
	public int setTransactionID() {
		return this.transactionID = (int) (Math.random() * ((999999999 - 100000000) + 1));
	}

	// Getter method for transactionDate
	public Date getTransactionDate() {
		return transactionDate;
	}

	// Getter method for numberOfItems
	public int getNumberOfItems() {
		return numberOfItems;
	}

	// Getter method for itemsInBag
	public ArrayList<Product> getItemsInBag() {
		return itemsInBag;
	}

	// Getter method for totalCost
	public double getTotalCost() {
		return totalCost;
	}

	// Formats the OUTPUT of the totalCost data
	public static String getPriceFormatted(double totalCost) {
		String formattedPrice = NumberFormat.getCurrencyInstance().format(totalCost);
		// Returns the result to setPrice() to pass its value to this.totalCost
		return formattedPrice;
	}

	// Getter method for transactionStatus
	public String getTransactionStatus() {
		return transactionStatus;
	}

	// Method for adding items to the transaction total and shopping bag
	public void addItem(Scanner console, Product newItem) {
		System.out.print("Enter the quantity to add: "); // Prompts for quantity input
		int addQuantity = console.nextInt(); // Stores the quantity of items in a variable

		for (int i = 1; i <= addQuantity; i++) { // For each individual item in the total quantity
			itemsInBag.add(newItem); // Add that item into the bag array
			numberOfItems++;
		}
		totalCost += newItem.getPrice() * addQuantity; // Add the price of that item to the total cost
		System.out.println("Added (" + addQuantity + ") " + newItem.getProductName());
	}

	// Method for removing items to the transaction total and shopping bag
	public void removeItem(Scanner console, Product oldItem) {
		System.out.print("Enter the quantity to remove: "); // Prompts for quantity input
		int removeQuantity = console.nextInt(); // Stores the quantity of items in a variable

		for (int i = 1; i <= removeQuantity; i++) { // For each individual item in the total quantity
			itemsInBag.remove(oldItem); // Remove that item from the bag array
			numberOfItems--;
		}
		totalCost -= oldItem.price * removeQuantity; // Remove the price of that item from the total cost
		System.out.println("Removed (" + removeQuantity + ") " + oldItem.getProductName());
	}

	// Method for processing payment
	public void payment(Scanner console) {
		this.transactionStatus = "Payment"; // Updates transactionStatus

		System.out.print("Apply rewards number (press 1, or 0 to skip)? "); // Prompts for user input
		int choice = console.nextInt(); // Stores the decision input in a variable

		if (choice == 1) { // If input == 1...
			applyRewards(console); // Call applyRewards() method before continuing
		} else if (choice == 0) { // Otherwise, if input == 0...
			return; // Skip, return, and continue
		}

		System.out.println(); // Extra console space

		System.out.println(this.toString()); // Print details of the transaction
		System.out.print("Total is: " + getPriceFormatted(totalCost) + "\nPay this amount? ");
		choice = console.nextInt(); // Store the decision input in a variable

		if (choice == 0) { // If input == 0...
			return; // Cancel and return to the transaction
		} else if (choice == 1) { // Otherwise, if input == 1...
			transactionStatus = "Complete"; // Update transaction status
			bag.clear(); // Clear contents of the bag array list
			numberOfItems = 0; // Reset the number of items
			totalCost = 0; // Reset the total cost

			System.out.println(); // Extra console space

			// Print confirmation message with savings details
			System.out.println("Payment approved" + "\nYou saved " + getPriceFormatted(totalSavings)
					+ "\nThank you for shopping with us!");
		}
	}

	// Method for applying the rewardsNumber discount -- called from payment()
	private void applyRewards(Scanner console) {
		double discount = (totalCost / 10); // Calculate and store the discount amount

		System.out.println(); // Extra console space

		System.out.print("Enter rewards number (0 to cancel): "); // Prompts for user input
		int rewardsInput = console.nextInt(); // Store the rewardsNumber or decision input in a variable

		if (rewardsInput == 0) { // If input == 0...
			return; // Skip, return, and continue
		} else { // Otherwise (currently, any other integer input will pass)...
			totalSavings = discount; // Change value of totalSavings to discount amount
			totalCost -= discount; // Deduct discount amount from totalCost
		}
		return; // Return to payment() method
	}

	// Method for canceling the transaction
	public void cancelTransaction(Scanner console) {
		System.out.print("Cancel transaction (0 to cancel)?"); // Prompts for user input
		int choice = console.nextInt(); // Stores the decision input in a variable

		if (choice == 1) { // If input == 1...
			transactionStatus = "Voided"; // Update transaction status
			bag.clear(); // Clear contents of the bag array list
			numberOfItems = 0; // Reset the number of items
			totalCost = 0; // Reset the total cost
			System.out.println(this.toString()); // Print details of the transaction
			System.out.println("Your transaction has been cancelled."); // Cancellation confirmation
		} else if (choice == 0) { // Otherwise, if input == 0...
			return; // Cancel and return to the transaction
		} else { // Otherwise...
			System.out.println("Invalid entry"); // Return error message

			cancelTransaction(console); // Restart the cancelTransaction() method
		}
		return; // Return to transaction
	}

	// Method to print the details of the transaction object
	public String toString() {
		return "Transaction Details\n===================" + "\nID: " + transactionID + "\nDate: " + transactionDate
				+ "\nTotal: " + getPriceFormatted(totalCost) + "\nStatus: " + transactionStatus + "\nNumber of Items: "
				+ numberOfItems + "\n\n" + itemsInBag + "\n===================";
	}

}
