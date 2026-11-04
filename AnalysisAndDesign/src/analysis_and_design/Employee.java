package analysis_and_design;

public class Employee {
	private String employee_ID;
	private String fullName;
	private String role;

	// Constructor
	public Employee(String employee_ID, String fullName, String role) {
		this.employee_ID = employee_ID;
		this.fullName = fullName;
		this.role = role;
	}

	// Getters and setters
	public String getEmployeeID() {
		return employee_ID;
	}

	public void setEmployeeID(String employee_ID) {
		this.employee_ID = employee_ID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// Utility method
	public void printInfo() {
		System.out.println("Employee ID: " + employee_ID);
		System.out.println("Name: " + fullName);
		System.out.println("Role: " + role);
	}
}
