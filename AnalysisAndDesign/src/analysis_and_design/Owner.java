package analysis_and_design;

public class Owner extends User {
	private String registration;
	public Activity_Log has_access;
	public ActionTypeCatalogue anActionTypeCatalogue;
	public DateRangeCatalogue aDateRangeCatalogue;

	// Constructor matching the User constructor + owner-specific fields
	public Owner(String userID, String fullName, String username, String password, String email, String contactNumber,
			Account anAccount, String registration, Activity_Log has_access, ActionTypeCatalogue anActionTypeCatalogue,
			DateRangeCatalogue aDateRangeCatalogue) {
		super(userID, fullName, username, password, email, contactNumber, anAccount);
		this.registration = registration;
		this.has_access = has_access;
		this.anActionTypeCatalogue = anActionTypeCatalogue;
		this.aDateRangeCatalogue = aDateRangeCatalogue;
	}

	// Getters and setters for registration
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	// Example method: lets owner select an action for supervision
	public void selectActionSupervision(String actionType) {
		System.out.println(getFullName() + " selected action supervision for: " + actionType);
		// You could link this to anActionTypeCatalogue or other logic
	}

	// Submit an action search criteria (simulate some searching or filtering)
	public void submit(String actionSearchCriteria) {
		System.out.println(getFullName() + " submitted search criteria: " + actionSearchCriteria);
		// Logic to search or process criteria in your catalogues could go here
	}

	// Enter selected action types and date range (simulate filtering)
	public void enter(String actionTypes, String dateRange) {
		System.out.println(getFullName() + " entered Action Types: " + actionTypes + " and Date Range: " + dateRange);
		// You can connect this to your ActionTypeCatalogue and DateRangeCatalogue logic
	}

	// Select option method, could be for UI selection or internal logic
	public void select(Object option) {
		System.out.println(getFullName() + " selected option: " + option);
		// Implement logic for processing the selected option
	}

	// Set limits (e.g. min/max for fruit orders)
	public void setLimits(int minimum, int maximum, String fruitType) {
		System.out.println(getFullName() + " set limits for " + fruitType + ": Min=" + minimum + ", Max=" + maximum);
		OrderLimitsRegistry.setLimit(fruitType, maximum);
		if (has_access != null) {
			has_access.addLog("Limit Set",
					getFullName() + " set limits for " + fruitType + ": Min=" + minimum + ", Max=" + maximum);
		}
	}

	// You could store or enforce these limits somewhere in your business logic
}
