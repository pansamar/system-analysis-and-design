package analysis_and_design;

import java.util.ArrayList;

public class CatalogSearchController {

	// Since your catalogs have mostly static collections, no need to instantiate
	// them here
	// We'll call their static methods directly in search

	public CatalogSearchController() {
		// No instance fields needed if catalogs are static
	}

	// Search Fruits by type (case insensitive)
	public Fruit searchFruitByType(String type) {
		ArrayList<Fruit> fruits = Fruits_catalog.getFruits();
		for (Fruit fruit : fruits) {
			if (fruit.getType().equalsIgnoreCase(type)) {
				return fruit;
			}
		}
		System.out.println("Fruit not found: " + type);
		return null;
	}

	// Search Farmer by name (assuming Farmers_catalog similar to Fruits_catalog)
	public Farmer searchFarmerByName(String name) {
		ArrayList<Farmer> farmers = Farmers_catalog.getFarmers(); // you need a static getter in Farmers_catalog
		for (Farmer farmer : farmers) {
			if (farmer.getName().equalsIgnoreCase(name)) {
				return farmer;
			}
		}
		System.out.println("Farmer not found: " + name);
		return null;
	}

	// Search Customer by lastName or firstName (assuming Customer_catalog exists)
	public Customer searchCustomerByName(String name) {
		ArrayList<Customer> customers = Customers_catalog.getCustomers(); // you need this class & method
		for (Customer customer : customers) {
			if (customer.getFirstName().equalsIgnoreCase(name) || customer.getLastName().equalsIgnoreCase(name)) {
				return customer;
			}
		}
		System.out.println("Customer not found: " + name);
		return null;
	}
}
