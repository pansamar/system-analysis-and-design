package analysis_and_design;

import java.util.ArrayList;

public class Farmers_catalog {
	// Static list to store all farmers globally
	private static ArrayList<Farmer> farmers = new ArrayList<>();

	// Add a farmer to the catalog
	public static void addFarmer(Farmer farmer) {
		farmers.add(farmer);
	}

	// Remove a farmer from the catalog
	public static void removeFarmer(Farmer farmer) {
		farmers.remove(farmer);
	}

	// Get all farmers
	public static ArrayList<Farmer> getFarmers() {
		return farmers;
	}

	// Print all farmers and their purchase orders
	public static void printCatalog() {
		System.out.println("=== Farmers Catalog ===");
		for (Farmer farmer : farmers) {
			System.out.println("Farmer: " + farmer.getName() + ", Contact: " + farmer.getContactInfo() + ", Date: "
					+ farmer.getDate());
			System.out.println("Purchase Orders:");
			if (farmer.aFarmers_catalog.isEmpty()) {
				System.out.println("  No purchase orders yet.");
			} else {
				for (Order order : farmer.aFarmers_catalog) {
					order.printData();
					System.out.println("---");
				}
			}
			System.out.println();
		}
	}

	// Optional: search functionality placeholder
	public void Searching_catalog(String farmerName) {
		for (Farmer farmer : farmers) {
			if (farmer.getName().equalsIgnoreCase(farmerName)) {
				System.out.println("Found farmer:");
				farmer.printFarmer();
				return;
			}
		}
		System.out.println("Farmer " + farmerName + " not found.");
	}

	// Get farmer info placeholder - could be used for more detailed info retrieval
	public void get_farmer_s_info(String farmerName) {
		Searching_catalog(farmerName);
	}
}
