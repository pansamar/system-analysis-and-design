package analysis_and_design;

import java.util.HashSet;
import java.util.Set;

public class ActionTypeCatalogue {
	private Set<String> validActionTypes;

	public ActionTypeCatalogue() {
		validActionTypes = new HashSet<>();
		// Initialize with some default valid action types
		validActionTypes.add("Order Created");
		validActionTypes.add("Order Approved");
		validActionTypes.add("Order Rejected");
		validActionTypes.add("User Login");
		validActionTypes.add("User Logout");
		validActionTypes.add("Purchase Order Created");
		validActionTypes.add("Limit Set");
		validActionTypes.add("Password Changed");
		// Add more as needed
	}

	/**
	 * Checks if the provided action type is valid. Comparison is case-insensitive.
	 */
	public boolean isValidActionType(String actionType) {
		if (actionType == null)
			return false;
		return validActionTypes.contains(actionType.trim().toLowerCase());
	}

	/**
	 * Add a new action type to the catalogue.
	 */
	public void addActionType(String actionType) {
		if (actionType != null) {
			validActionTypes.add(actionType.trim().toLowerCase());
		}
	}

	/**
	 * Remove an action type from the catalogue.
	 */
	public void removeActionType(String actionType) {
		if (actionType != null) {
			validActionTypes.remove(actionType.trim().toLowerCase());
		}
	}

	/**
	 * Get all valid action types
	 */
	public Set<String> getValidActionTypes() {
		return new HashSet<>(validActionTypes); // Return a copy for safety
	}
}
