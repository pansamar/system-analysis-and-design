package analysis_and_design;

import java.util.ArrayList;

public class Fruits_catalog {
	private static ArrayList<Fruit> fruits = new ArrayList<>();

	public static void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}

	public static void removeFruit(Fruit fruit) {
		fruits.remove(fruit);
	}

	public static ArrayList<Fruit> getFruits() {
		return fruits;
	}

	public void Searching_catalog() {
		// Example placeholder implementation
		for (Fruit fruit : fruits) {
			System.out.println("Found fruit: " + fruit.getType());
		}
	}

	public String get_fruit_type() {
		if (!fruits.isEmpty()) {
			return fruits.get(0).getType();
		}
		return "No fruits available";
	}
}
