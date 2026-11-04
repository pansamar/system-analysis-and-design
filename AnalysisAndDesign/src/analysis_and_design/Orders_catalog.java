package analysis_and_design;

import java.util.ArrayList;

public class Orders_catalog {

	public static ArrayList<Order> allOrders = new ArrayList<>();

	public void get_data(ArrayList<Purchase_Order_data> anOrder) {
		System.out.println(allOrders);
	}

	public static void addOrder(Order anOrder) {
		allOrders.add(anOrder);
	}

	public void search_order(Order anOrder) {
		// Optional: Implement search by ID or other fields if needed
	}

	public static void removeOrder(Order anOrder) {
		allOrders.remove(anOrder);
	}

	// Change return type to ArrayList<Order> for easy iteration
	public static ArrayList<Order> getOrders() {
		return allOrders;
	}
}
