package analysis_and_design;

public class User {
	private String userID;
	private String fullName;
	private String username;
	private String password;
	private String email;
	private String contactNumber;

	private Account anAccount;
	private EmailService anEmailService;

	// Constructor
	public User(String userID, String fullName, String username, String password, String email, String contactNumber,
			Account anAccount) {
		this.userID = userID;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.anAccount = anAccount;
		this.anEmailService = new EmailService(this); // Inject User into EmailService
	}

	// Getters and Setters
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Account getAnAccount() {
		return anAccount;
	}

	public void setAnAccount(Account anAccount) {
		this.anAccount = anAccount;
	}

	public EmailService getAnEmailService() {
		return anEmailService;
	}

	public void setAnEmailService(EmailService anEmailService) {
		this.anEmailService = anEmailService;
	}

	// Simulate login check
	public boolean fillingInInputData(String inputUsername, String inputPassword) {
		return this.username.equals(inputUsername) && this.password.equals(inputPassword);
	}

	// Use the EmailService to simulate opening a link via notification
	public void openLink(String link) {
		if (anEmailService != null) {
			anEmailService.sendNewOrderNotification(link);
		} else {
			System.out.println("Email service is not set for user.");
		}
	}
}
