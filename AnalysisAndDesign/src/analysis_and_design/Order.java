package analysis_and_design;

import java.util.ArrayList;
import java.util.List;

// Αυτή η κλάση αναφέρεται σε παραγγελίες πωλήσεων μαρμελάδων της Biojam σε χονδέμπορους (Customers)
public class Order {
	private int ID;
	private ArrayList<Purchase_Order_data> orders = new ArrayList<>();
	private Customer cus;

	// Constructor for order with a list of order data
	public Order(int ID, ArrayList<Purchase_Order_data> orders, Customer cus) {
		this.ID = ID;
		this.orders = orders;
		this.cus = cus;
	}

	// Constructor for order with two product types
	public Order(int ID, String type1, int quantity1, String type2, int quantity2, Customer cus) {
		this.ID = ID;
		this.orders = new ArrayList<>();
		this.orders.add(new Purchase_Order_data(type1, quantity1));
		this.orders.add(new Purchase_Order_data(type2, quantity2));
		this.cus = cus;
	}

	// Constructor for order with three product types
	public Order(int ID, String type1, int quantity1, String type2, int quantity2, String type3, int quantity3,
			Customer cus) {
		this.ID = ID;
		this.orders = new ArrayList<>();
		this.orders.add(new Purchase_Order_data(type1, quantity1));
		this.orders.add(new Purchase_Order_data(type2, quantity2));
		this.orders.add(new Purchase_Order_data(type3, quantity3));
		this.cus = cus;
	}

	// Constructor for single product order
	public Order(int ID, String type, int quantity, Customer cus) {
		this.ID = ID;
		this.orders = new ArrayList<>();
		this.orders.add(new Purchase_Order_data(type, quantity));
		this.cus = cus;
	}

	// Print order data
	public void printData() {
		System.out.println("Order ID: " + ID);
		System.out.println("Customer: " + cus);
		Purchase_Order_data.printDataList(orders);
	}

	public List<Purchase_Order_data> getOrderDataList() {
		return this.orders; // assuming your private ArrayList<Order_data> orders
	}

	public Customer getCustomer() {
		return cus;
	}

	public int getID() {
		return ID;
	}
}
