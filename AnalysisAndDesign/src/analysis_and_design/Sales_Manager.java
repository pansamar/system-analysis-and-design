package analysis_and_design;

public class Sales_Manager extends Employee {
	private Customer_Credit_Check creditChecker;

	// Constructor calling Employee superclass
	public Sales_Manager(String employee_ID, String fullName, String role, Customer_Credit_Check creditChecker) {
		super(employee_ID, fullName, role);
		this.creditChecker = creditChecker;
	}

	// View available stock for a specific jam type
	public void viewStockByType(String fruitType) {
		boolean found = false;
		for (Fruit fruit : Fruits_catalog.getFruits()) {
			if (fruit.getType().equalsIgnoreCase(fruitType)) {
				System.out.println("📦 Stock for " + fruitType + ": " + fruit.getQuantity() + " units");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("❌ No stock available for fruit type: " + fruitType);
		}
	}

	// Send a customer order to accounting for credit check
	public void sendOrderToAccounting(Order order) {
		System.out.println("📨 Sending order ID " + order.getID() + " to Accounting Department for credit check...");

		Customer customer = order.getCustomer();
		boolean approved = creditChecker.performCheck(customer);

		if (approved) {
			System.out.println("✅ Credit approved for customer: " + customer);
			System.out.println("Proceeding with order ID: " + order.getID());
		} else {
			System.out.println("❌ Credit denied for customer: " + customer);
			System.out.println("Order ID " + order.getID() + " cannot be processed.");
		}
	}
}
