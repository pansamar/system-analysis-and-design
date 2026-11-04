package analysis_and_design;

import java.util.HashMap;
import java.util.Map;

public class Stock_catalog {

	// Map fruit type -> quantity of jam in stock (units)
	private static Map<String, Double> jamStock = new HashMap<>();

	// Initialize stock with fruits in Fruits_catalog (optional)
	public static void initializeStockFromFruits() {
		for (Fruit fruit : Fruits_catalog.getFruits()) {
			jamStock.put(fruit.getType().toLowerCase(), fruit.getQuantity());
		}
	}

	// Search stock for a specific jam type (fruit)
	public static double searchStock(String fruitType) {
		return jamStock.getOrDefault(fruitType.toLowerCase(), 0.0);
	}

	// Update stock: increase or decrease jam quantity by amount (can be negative)
	public static void updateStock(String fruitType, double amount) {
		String key = fruitType.toLowerCase();
		double currentQty = jamStock.getOrDefault(key, 0.0);
		double newQty = currentQty + amount;

		if (newQty < 0) {
			System.out.println("Cannot reduce stock below zero for " + fruitType);
			return;
		}

		jamStock.put(key, newQty);
		System.out.println("Stock updated: " + fruitType + " now has " + newQty + " units.");
	}

	// Print full stock catalog
	public static void printStock() {
		System.out.println("=== Current Jam Stock ===");
		for (Map.Entry<String, Double> entry : jamStock.entrySet()) {
			System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " units");
		}
	}
}
