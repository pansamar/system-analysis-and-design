package analysis_and_design;

import java.util.ArrayList;

public class Customers_catalog {

	private static ArrayList<Customer> allCustomers = new ArrayList<>();

	// Add a customer to the catalog
	public static void addCustomer(Customer customer) {
		allCustomers.add(customer);
	}

	// Remove a customer from the catalog
	public static void removeCustomer(Customer customer) {
		allCustomers.remove(customer);
	}

	// Return all customers for iteration
	public static ArrayList<Customer> getCustomers() {
		return allCustomers;
	}

	// Optional: Search customer by AFM (tax id) or name
	public static Customer findCustomerByAfm(String afm) {
		for (Customer c : allCustomers) {
			if (c.getAfm().equals(afm)) {
				return c;
			}
		}
		return null; // not found
	}
}
