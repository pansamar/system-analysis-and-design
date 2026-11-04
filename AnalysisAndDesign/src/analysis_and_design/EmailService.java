package analysis_and_design;

public class EmailService {
	private String lastOrderNotification;
	private String lastOrderLink;

	public Customer_Credit_Check customerCredit;
	public Warehouse_Employee aWarehouse_Employee;
	public Purchasing_Manager aPurchasing_Manager;
	public User aUser;

	public EmailService(User user) {
		this.aUser = user;
	}

	public void sendNewOrderNotification(String orderLink) {
		this.lastOrderLink = orderLink;
		this.lastOrderNotification = "New Order Notification: Please review the following order: " + orderLink;

		if (aUser != null) {
			System.out.println("Sending to " + aUser.getEmail() + ": " + lastOrderNotification);
		} else {
			System.out.println("No user is assigned to this email service.");
		}
	}

	public void sendOrderRejectionNotification(String orderLink) {
		this.lastOrderLink = orderLink;
		String rejectionMessage = "Order Rejected: The order at " + orderLink + " has been rejected.";

		if (aUser != null) {
			System.out.println("Sending to " + aUser.getEmail() + ": " + rejectionMessage);
		} else {
			System.out.println("No user is assigned to this email service.");
		}
	}

	public void newPasswordSuggestion() {
		String newPassword = "Biojam" + (int) (Math.random() * 10000); // Basic password generation
		if (aUser != null) {
			aUser.setPassword(newPassword);
			System.out.println("Sending to " + aUser.getEmail() + ": Your new password is: " + newPassword);
		} else {
			System.out.println("No user found for sending new password suggestion.");
		}
	}

	// Optional getters
	public String getLastOrderLink() {
		return lastOrderLink;
	}

	public String getLastOrderNotification() {
		return lastOrderNotification;
	}
}
