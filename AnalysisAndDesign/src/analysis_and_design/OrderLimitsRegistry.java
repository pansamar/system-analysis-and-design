package analysis_and_design;

import java.util.HashMap;
import java.util.Map;

// this is handled explicity by the Owner of the BioJam.
public class OrderLimitsRegistry {
	private static final Map<String, Integer> fruitLimits = new HashMap<>();

	public static void setLimit(String fruitType, int maxQuantity) {
		fruitLimits.put(fruitType.toLowerCase(), maxQuantity);
	}

	public static int getLimit(String fruitType) {
		return fruitLimits.getOrDefault(fruitType.toLowerCase(), Integer.MAX_VALUE); // If not set, no limit
	}
}
