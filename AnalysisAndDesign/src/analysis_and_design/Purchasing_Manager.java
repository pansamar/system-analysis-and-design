package analysis_and_design;

import java.util.ArrayList;

public class Purchasing_Manager extends Employee {
	public EmailService anEmailService;

	public Customer_Credit_Check creditChecker;

	private Order latestOrder; // simulate the "new order" to display

	public Purchasing_Manager(String employee_ID, String fullName, String role, Customer_Credit_Check creditChecker,
			EmailService emailService) {
		super(employee_ID, fullName, role); // Pass to Employee superclass
		this.creditChecker = creditChecker;
		this.anEmailService = emailService;
	}

	// Simulate receiving a new order to inspect
	public void setNewOrder(Order order) {
		this.latestOrder = order;
	}

	public void click_new_details() {
		if (latestOrder == null) {
			System.out.println("No new order to display.");
			return;
		}

		Customer customer = latestOrder.getCustomer();
		System.out.println(
				"Checking credit score for customer: " + customer.getLastName() + " " + customer.getFirstName());

		boolean approved = creditChecker.performCheck(customer);

		System.out.println("=== Order Details ===");
		latestOrder.printData();

		if (approved) {
			System.out.println("✔ Order APPROVED based on credit score.");
			anEmailService.sendNewOrderNotification("https://biojam.com/orders/" + latestOrder.getID());
		} else {
			System.out.println("✖ Order REJECTED due to low credit score.");
			anEmailService.sendOrderRejectionNotification("https://biojam.com/orders/" + latestOrder.getID());
		}
	}

	public void open(String aOrder_link) {
		// Implementation or leave empty if unused
	}

	public void register_new_purchase_order(String fruitType, int quantity, Farmer farmer, double pricePerUnit) {
		int limit = OrderLimitsRegistry.getLimit(fruitType);

		if (quantity > limit) {
			System.out.println("❌ Cannot register order. Quantity " + quantity + " exceeds limit of " + limit + " for "
					+ fruitType + ".");
			return;
		}

		// Create purchase order data
		Purchase_Order_data orderData = new Purchase_Order_data(fruitType, quantity, farmer);
		PurchaseOrderData_catalog.addPurchase(orderData);

		// Create an ArrayList with the purchase data
		ArrayList<Purchase_Order_data> orderDataList = new ArrayList<>();
		orderDataList.add(orderData);

		// Generate an order ID dynamically
		int newOrderID = PurchaseOrders_catalog.getPurchaseOrders().size() + 1;

		// Create the purchase order (Customer is null because this is a purchase order)
		Order purchaseOrder = new Order(newOrderID, orderDataList, null);

		PurchaseOrders_catalog.addPurchaseOrder(purchaseOrder);

		System.out.println(
				"✅ Purchase order registered for " + quantity + " units of " + fruitType + " from " + farmer.getName());
	}
}
