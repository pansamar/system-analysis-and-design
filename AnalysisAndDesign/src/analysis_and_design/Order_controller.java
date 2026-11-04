package analysis_and_design;

import java.util.Arrays;
import java.util.List;

public class Order_controller {

	// This would represent current stock stored for each fruit type
	// For demo, let's keep it simple as a fixed map or method (could be expanded)
	// Alternatively, integrate with your Fruits_catalog for real inventory
	// management

	// Valid fruit types in your system
	private final List<String> validFruits = Arrays.asList("fraoula", "portokali", "kerasi", "mantarini");

	// Simulated inventory (could be replaced by actual inventory tracking)
	private final double storedQuantity = 1000; // example stored quantity for any fruit

	/**
	 * Checks if the fruit type is valid in your catalog.
	 * 
	 * @param fruitType
	 * @return true if exists, false otherwise
	 */
	public boolean isFruitValid(String fruitType) {
		return validFruits.contains(fruitType.toLowerCase());
	}

	/**
	 * Checks order validity: existence and quantity.
	 * 
	 * @param anOrder The Order object to check Prints messages if something is
	 *                invalid
	 */
	public void checkForExistenceAndQuantity(Order anOrder) {
		// Assuming Order stores fruit types and quantities internally.
		// We'll simulate checking all fruits in the order.

		// For demo, I assume your Order class has a method getOrderedFruits()
		// returning a List<Order_data> or similar structure
		List<Purchase_Order_data> orderItems = anOrder.getOrderDataList();

		boolean allFruitsValid = true;
		boolean sufficientQuantity = true;

		for (Purchase_Order_data item : orderItems) {
			String fruitType = item.getOrderType().toLowerCase();
			double qty = item.getQuantity();

			if (!isFruitValid(fruitType)) {
				System.out.println("Try again, the fruit '" + fruitType + "' doesn't exist.");
				allFruitsValid = false;
			}

			if (qty > storedQuantity) { // Ideally this compares to the actual fruit's stored quantity
				System.out.println("Can't make the order for fruit '" + fruitType + "'. Quantity exceeds stock.");
				sufficientQuantity = false;
			}
		}

		if (allFruitsValid && sufficientQuantity) {
			System.out.println("Order is valid.");
		} else {
			System.out.println("Order has issues, please review.");
		}
	}
}
