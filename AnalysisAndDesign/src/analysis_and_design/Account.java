package analysis_and_design;

public class Account {
	private String password;
	private User aUser;

	// Constructor linking this account to a user
	public Account(User user, String initialPassword) {
		this.aUser = user;
		this.password = initialPassword;
	}

	// Store a new password (update the password)
	public void storeNewPassword(String newPassword) {
		if (newPassword == null || newPassword.isEmpty()) {
			System.out.println("Password cannot be empty.");
			return;
		}
		this.password = newPassword;
		System.out.println("Password updated successfully for user: " + aUser.getUsername());
	}

	// Replace the linked user account (if needed)
	public void storeNewAccount(User newUser) {
		if (newUser == null) {
			System.out.println("New account cannot be null.");
			return;
		}
		this.aUser = newUser;
		System.out.println("Account linked to new user: " + newUser.getUsername());
	}

	// Getter for password (optional, consider security)
	public String getPassword() {
		return password;
	}

	// Getter for user
	public User getUser() {
		return aUser;
	}
}
