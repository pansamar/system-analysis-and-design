package analysis_and_design;

public class Main {
	public static void main(String[] args) {

		// === 1. Δημιουργία Φρούτων ===
		Fruit jam1 = new Fruit("fraoula", 600);
		Fruit jam2 = new Fruit("kerasi", 420);
		Fruit jam3 = new Fruit("portokali", 480);
		Fruit jam4 = new Fruit("mantarini", 360);

		Fruits_catalog.addFruit(jam1);
		System.out.println("Object jam1 has been created.");
		Fruits_catalog.addFruit(jam2);
		System.out.println("Object jam2 has been created.");
		Fruits_catalog.addFruit(jam3);
		System.out.println("Object jam3 has been created.");
		Fruits_catalog.addFruit(jam4);
		System.out.println("Object jam4 has been created.");

		// === 2. Δημιουργία Πελατών ===
		Customer customer1 = new Customer("Patidou", "Olga", "046208830", "DOY B Peiraia", "OK");
		Customer customer2 = new Customer("Alexiou", "Nikolaos", "180226310", "DOY Ilioupolis", "OK");

		Customers_catalog.addCustomer(customer1);
		System.out.println("Object customer1 has been created.");
		Customers_catalog.addCustomer(customer2);
		System.out.println("Object customer2 has been created.");

		// === 3. Δημιουργία Παραγγελιών ===
		Order order1 = new Order(123456789, "fraoula", 50, "portokali", 14, customer1);
		Orders_catalog.addOrder(order1);
		System.out.println("Order 1 has been added successfully!");

		Order order2 = new Order(123456789, "mantarini", 120, "portokali", 45, customer1);
		Orders_catalog.addOrder(order2);
		System.out.println("Order 2 has been added successfully!");

		Order order3 = new Order(123456780, "kerasi", 80, "portokali", 35, "fraoula", 28, customer2);
		Orders_catalog.addOrder(order3);
		System.out.println("Order 3 has been added successfully!");

		Order order4 = new Order(123456780, "mantarini", 60, customer2);
		Orders_catalog.addOrder(order4);
		System.out.println("Order 4 has been added successfully!");

		// === 4. Διαγραφή παραγγελίας ===
		Orders_catalog.removeOrder(order2);
		System.out.println("Order 2 has been removed successfully!");

		// === 5. Εκτύπωση δεδομένων ===
		System.out.println("\n--- Customers ---");
		for (Customer customer : Customers_catalog.getCustomers()) {
			customer.printData();
		}

		System.out.println("\n--- Fruits ---");
		for (Fruit fruit : Fruits_catalog.getFruits()) {
			fruit.printData();
		}

		System.out.println("\n--- Orders ---");
		for (Order order : Orders_catalog.getOrders()) {
			order.printData();
		}

		// === 6. Δοκιμή Χρήστη και EmailService ===
		// Step 1: Create Account with no user yet, just a dummy password
		Account acc = new Account(null, "pass123");

		// Step 2: Create User, passing the Account
		User user = new User("U001", "Alice Papadopoulou", "alice123", "pass123", "alice@biojam.com", "6944123456",
				acc);

		// Step 3: Link Account back to the User
		acc.storeNewAccount(user);

		// Now your user and account are correctly linked
		boolean login = user.fillingInInputData("alice123", "pass123");
		System.out.println("Login attempt: " + (login ? "Success" : "Failure"));

		user.openLink("https://biojam.com/orders/ORD123");
		user.getAnEmailService().sendOrderRejectionNotification("https://biojam.com/orders/ORD124");
		user.getAnEmailService().newPasswordSuggestion();
	}
}