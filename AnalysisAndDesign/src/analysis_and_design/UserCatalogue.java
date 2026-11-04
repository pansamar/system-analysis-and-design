package analysis_and_design;

import java.util.ArrayList;
import java.util.List;

public class UserCatalogue {
	private List<User> users;

	public UserCatalogue() {
		this.users = new ArrayList<>();
	}

	public void addUser(User user) {
		if (user != null) {
			users.add(user);
		}
	}

	public void removeUser(User user) {
		users.remove(user);
	}

	public List<User> getAllUsers() {
		return new ArrayList<>(users); // defensive copy
	}

	/**
	 * Check if a username exists in the catalogue. Case-sensitive, modify if you
	 * want case-insensitive.
	 */
	public boolean isValidUsername(String username) {
		if (username == null)
			return false;
		for (User user : users) {
			if (username.equals(user.getUsername())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get user by username, or null if not found.
	 */
	public User getUserByUsername(String username) {
		if (username == null)
			return null;
		for (User user : users) {
			if (username.equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}
}
