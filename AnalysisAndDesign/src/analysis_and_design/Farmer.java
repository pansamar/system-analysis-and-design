package analysis_and_design;

import java.util.ArrayList;

public class Farmer {
	private String name;
	private String contactInfo;
	private String date;
	public ArrayList<Order> aFarmers_catalog = new ArrayList<>();

	// Constructor
	public Farmer(String name, String contactInfo, String date) {
		this.name = name;
		this.contactInfo = contactInfo;
		this.date = date;
	}

	// Adds a simple purchase order to the farmer's catalog
	public void addOrder(String type, int quantity, double price) {
		// Create purchase order data
		Purchase_Order_data orderData = new Purchase_Order_data(type, quantity, this);

		// Add to global PurchaseOrderData catalog (optional, if you want global
		// tracking)
		PurchaseOrderData_catalog.addPurchase(orderData);

		// Create an ArrayList for this order
		ArrayList<Purchase_Order_data> orderDataList = new ArrayList<>();
		orderDataList.add(orderData);

		// Generate an order ID dynamically (based on catalog size + 1)
		int newOrderID = aFarmers_catalog.size() + 1;

		// Create purchase order with null Customer (purchase orders don't have
		// customers)
		Order purchaseOrder = new Order(newOrderID, orderDataList, null);

		// Add to farmer's personal catalog
		aFarmers_catalog.add(purchaseOrder);

		// Add to global purchase orders catalog if needed
		PurchaseOrders_catalog.addPurchaseOrder(purchaseOrder);

		System.out.println("Added purchase order for " + quantity + " units of " + type + " at price " + price
				+ " to farmer " + name);
	}

	// Prints farmer details and their order catalog
	public void printFarmer() {
		System.out.println("Name: " + name + ", Contact info: " + contactInfo + ", Date: " + date);
		Farmers_catalog.printCatalog();
	}

	// Getter for name (now functional)
	public String getName() {
		return name;
	}

	// Optional: other getters
	public String getContactInfo() {
		return contactInfo;
	}

	public String getDate() {
		return date;
	}
}
