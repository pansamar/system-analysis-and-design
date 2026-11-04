package analysis_and_design;

import java.util.ArrayList;

public class Purchase_Order_data {
	private String type; // Product type (e.g., "Orange")
	private double quantity;

	private String typeForPurchase;
	private double quantityForPurchase;
	private Farmer aFarmer;

	// Constructor for regular orders (used by Customer)
	public Purchase_Order_data(String type, double quantity) {
		this.type = type;
		this.quantity = quantity;
	}

	// Constructor for purchase orders (used by employees like Purchasing Manager)
	public Purchase_Order_data(String typeForPurchase, double quantityForPurchase, Farmer aFarmer) {
		this.typeForPurchase = typeForPurchase;
		this.quantityForPurchase = quantityForPurchase;
		this.aFarmer = aFarmer;
	}

	// Getters for regular orders
	public String getOrderType() {
		return type;
	}

	public double getQuantity() {
		return quantity;
	}

	// Getters for purchase orders
	public String getTypeP() {
		return typeForPurchase;
	}

	public double getQuantityP() {
		return quantityForPurchase;
	}

	public Farmer getFarmer() {
		return aFarmer;
	}

	// Static utility method to print a list of order data
	public static void printDataList(ArrayList<Purchase_Order_data> orderList) {
		System.out.println("Order Contents:");
		for (Purchase_Order_data data : orderList) {
			if (data.type != null) {
				System.out.println("- " + data.type + ": " + data.quantity + " units");
			} else if (data.typeForPurchase != null && data.aFarmer != null) {
				System.out.println("- [Purchase] " + data.typeForPurchase + ": " + data.quantityForPurchase
						+ " units from " + data.aFarmer.getName());
			}
		}
	}

}
