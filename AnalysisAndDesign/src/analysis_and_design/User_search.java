package analysis_and_design;

import java.util.ArrayList;

public class User_search {

	// Store registered users
	private static ArrayList<User> registeredUsers = new ArrayList<>();

	// Add a user to the search pool
	public static void addUser(User user) {
		registeredUsers.add(user);
	}

	/**
	 * Search for a user matching username and password.
	 * 
	 * @param aUsername Object expected to be String username
	 * @param aPassword Object expected to be String password
	 * @return User if found and matched, else null
	 */
	public User info_search(Object aUsername, Object aPassword) {
		if (!(aUsername instanceof String) || !(aPassword instanceof String)) {
			System.out.println("Invalid input types for username or password.");
			return null;
		}

		String username = (String) aUsername;
		String password = (String) aPassword;

		for (User user : registeredUsers) {
			if (user.fillingInInputData(username, password)) {
				System.out.println("User found: " + user.getFullName());
				return user;
			}
		}

		System.out.println("No matching user found for username: " + username);
		return null;
	}

	/**
	 * Render info about all registered users (simulate UI)
	 */
	public void render() {
		System.out.println("=== Registered Users ===");
		for (User user : registeredUsers) {
			System.out.println("- " + user.getUsername() + " (" + user.getFullName() + ")");
		}
	}
}
