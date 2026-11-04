package analysis_and_design;

import java.util.ArrayList;

public class PurchaseOrderData_catalog {
	private static final ArrayList<Purchase_Order_data> allPurchases = new ArrayList<>();

	public static void addPurchase(Purchase_Order_data orderData) {
		allPurchases.add(orderData);
	}

	public static ArrayList<Purchase_Order_data> getAllPurchases() {
		return allPurchases;
	}

	public static void printAllPurchases() {
		System.out.println("=== All Registered Purchase Orders ===");
		for (Purchase_Order_data data : allPurchases) {
			if (data.getTypeP() != null && data.getFarmer() != null) {
				System.out.println("- [Purchase] " + data.getTypeP() + ": " + data.getQuantityP() + " units from "
						+ data.getFarmer().getName());
			}
		}
	}
}
