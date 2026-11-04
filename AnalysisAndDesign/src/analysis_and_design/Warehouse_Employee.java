package analysis_and_design;

public class Warehouse_Employee extends Employee {
	public EmailService anEmailService;

	private Order currentOrder;

	public Warehouse_Employee(String employee_ID, String fullName, String role, EmailService emailService) {
		super(employee_ID, fullName, role);
		this.anEmailService = emailService;
	}

	public void open(String aOrderLink) {
		System.out.println("Warehouse employee is reviewing the order at: " + aOrderLink);
	}

	// Show order details and perform credit check
	public void click_new_details(Order order) {
		System.out.println("\n--- Checking new order details ---");
		order.printData();

		Customer customer = order.getCustomer();
		Customer_Credit_Check creditCheck = new Customer_Credit_Check();

		boolean isApproved = creditCheck.performCheck(customer);
		if (isApproved) {
			System.out.println("Customer is approved ✅. Proceed with the order.");
		} else {
			System.out.println("Customer is NOT approved ❌. Manual review required.");
			if (anEmailService != null) {
				anEmailService.sendOrderRejectionNotification("https://biojam.com/orders/" + order.getID());
			}
		}

		this.currentOrder = order; // Save for later steps
	}

	public void register_delivery_of_order() {
		if (currentOrder != null) {
			System.out.println("📦 Delivery registered for Order ID: " + currentOrder.getID());
		} else {
			System.out.println("⚠️ No active order to register delivery for.");
		}
	}

	public void send(Object aOrder) {
		if (aOrder instanceof Order) {
			Order order = (Order) aOrder;
			System.out.println("✅ Delivery of order ID " + order.getID() + " has been registered.");
		} else {
			System.out.println("Invalid object sent. Expected an Order.");
		}
	}

	public void finalize() {
		if (currentOrder != null) {
			System.out.println("✅ Finalized delivery of Order ID: " + currentOrder.getID());
			this.currentOrder = null; // Clear reference
		} else {
			System.out.println("⚠️ No order to finalize.");
		}
	}
}
