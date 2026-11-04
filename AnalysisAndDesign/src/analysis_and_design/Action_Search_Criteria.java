package analysis_and_design;

public class Action_Search_Criteria {
	private String actionType;
	private String dateRange; // Can be improved later to actual Date objects
	private String username;

	// Constructor
	public Action_Search_Criteria(String actionType, String dateRange, String username) {
		this.actionType = actionType;
		this.dateRange = dateRange;
		this.username = username;
	}

	// Default constructor
	public Action_Search_Criteria() {
	}

	// Getters and setters
	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// Validation methods
	public boolean isValidActionType(ActionTypeCatalogue actionTypeCatalogue) {
		return actionType != null && !actionType.isEmpty() && actionTypeCatalogue.isValidActionType(actionType);
	}

	public boolean isValidDateRange(DateRangeCatalogue dateRangeCatalogue) {
		return dateRange != null && !dateRange.isEmpty() && dateRangeCatalogue.validateDateRange(dateRange);
	}

	public boolean isValidUsername(UserCatalogue userCatalogue) {
		return userCatalogue != null && userCatalogue.isValidUsername(this.username);
	}

	// Convenience methods to check if criteria are set
	public boolean hasActionType() {
		return actionType != null && !actionType.isEmpty();
	}

	public boolean hasDateRange() {
		return dateRange != null && !dateRange.isEmpty();
	}

	public boolean hasUsername() {
		return username != null && !username.isEmpty();
	}

	// Check if criteria is ready for search (valid or empty)
	public boolean isReadyForSearch(ActionTypeCatalogue actionTypeCatalogue, DateRangeCatalogue dateRangeCatalogue,
			UserCatalogue userCatalogue) {
		boolean valid = true;

		if (hasActionType()) {
			valid = valid && isValidActionType(actionTypeCatalogue);
		}
		if (hasDateRange()) {
			valid = valid && isValidDateRange(dateRangeCatalogue);
		}
		if (hasUsername()) {
			valid = valid && isValidUsername(userCatalogue);
		}

		return valid;
	}

	@Override
	public String toString() {
		return "ActionSearchCriteria [actionType=" + actionType + ", dateRange=" + dateRange + ", username=" + username
				+ "]";
	}
}
