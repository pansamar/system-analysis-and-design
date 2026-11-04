package analysis_and_design;

public class Customer {
	private String lastName;
	private String firstName;
	private String afm; // ΑΦΜ
	private String doy;
	private String status;

	// Constructor to match Main.java
	public Customer(String lastName, String firstName, String afm, String doy, String status) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.afm = afm;
		this.doy = doy;
		this.status = status;
	}

	// Getters
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAfm() {
		return afm;
	}

	public String getDoy() {
		return doy;
	}

	public String getStatus() {
		return status;
	}

	public void printData() {
		System.out.println("Customer: " + firstName + " " + lastName);
		System.out.println("AFM: " + afm + ", DOY: " + doy + ", Status: " + status);
	}

	// Simulate screen navigation
	public void new_screen() {
		System.out.println("Navigating to the new screen for customer: " + firstName + " " + lastName);
	}

	// Simulate form input
	public void fill_customer_data() {
		System.out.println("Customer data filled:");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("AFM: " + afm);
		System.out.println("DOY: " + doy);
		System.out.println("Status: " + status);
	}

	// Simulate business flow continuation
	public void continue_68() {
		System.out.println("Customer " + firstName + " " + lastName + " continued to step 68.");
	}

	// For printing in Order
	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + afm + ")";
	}
}
