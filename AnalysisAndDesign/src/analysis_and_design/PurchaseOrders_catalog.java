package analysis_and_design;

import java.util.ArrayList;

public class PurchaseOrders_catalog {
	private static final ArrayList<Order> purchaseOrders = new ArrayList<>();

	public static void addPurchaseOrder(Order order) {
		purchaseOrders.add(order);
	}

	public static ArrayList<Order> getPurchaseOrders() {
		return purchaseOrders;
	}
}
