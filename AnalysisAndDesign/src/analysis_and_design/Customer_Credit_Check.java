package analysis_and_design;

public class Customer_Credit_Check {
	private int creditScore;
	public EmailService aService;

	// Simulated logic: approve if score ≥ 600
	public boolean performCheck(Customer aCustomer) {
		// For demo, simulate creditScore using length of ID (or you can add a field)
		this.creditScore = aCustomer.getAfm().length() > 8 ? 650 : 500;
		return creditScore >= 600;
	}

	public void call() {
		System.out.println("Performing credit check...");
	}
}
