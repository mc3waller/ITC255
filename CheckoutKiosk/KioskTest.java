//*******************************************************************
// KioskTest.java
//
// Test code for the checkoutKiosk classes.
// 
// By: Malik Waller 
// Date: 6/17/2020
//*******************************************************************

package checkoutKiosk;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class KioskTest {

	@Test
	void test() {

		/* Return types of these methods were
		changed in their classes to enable testing */
		
		// Scanner import for user input
		Scanner console = new Scanner(System.in);

		// Instantiate test objects
		Person employee = new Employee("Slim", "Shady", "Checkout", "Bagboy");
		Person customer = new Customer("Ziggy", "Stardust");
		Product apple = new Product("Apple", "Produce", 0.75, 1.50, false);
		Transaction order = new Transaction();

		// EMPLOYEE TEST

		// Successfully change employee's first name
		assertEquals("Alexander", employee.setFirstName("Alexander"));
		// Successfully change employee's last name
		assertEquals("Nevermind", employee.setLastName("Nevermind"));
		// Successfully change change empoyee's position
		assertEquals("Cashier", ((Employee) employee).setPosition("Cashier"));

		// CUSTOMER TEST

		// Successfully change change customer's phone number
		assertEquals(1234567890, customer.setPhoneNumber(1234567890));

		// PRODUCT TEST

		// Successfully change apple's productName value (NOT its reference variable)
		assertEquals("Orange", apple.setProductName("Orange"));
		// Successfully return correct product type
		assertEquals("Produce", apple.getType());
		// Unsuccessfully change apple's weight
		assertNotEquals(1.00, apple.setWeight(0.75));
		// Unsuccessfully change apple's restriction
		assertNotEquals(true, apple.setRestriction(false));

		// TRANSACTION TEST

		// Check numberOfItems for a total of 0 contained objects
		assertEquals(0, order.getNumberOfItems());
		// Method to add 'apple' to itemsInBag with a quantity of 3
		order.addItem(console, apple);
		// Check numberOfItems for a total of 3 contained objects
		assertEquals(3, order.getNumberOfItems());
		// Successfully returns the current transaction total
		assertEquals(4.5, order.getTotalCost());

	}

}
