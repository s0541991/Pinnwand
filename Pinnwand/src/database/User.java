package database;

public class User {

	private int uId = -1;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String bDay; // date?
	private String country;

	public User(String username, String password, String email, String firstName, String lastName, String bDay,
			String country) {
		this.username = (username == null ? "" : username);
		this.password = (password == null ? "" : password);
		this.email = (email == null ? "" : email);
		this.firstName = (firstName == null ? "" : firstName);
		this.lastName = (lastName == null ? "" : lastName);
		this.bDay = (bDay == null ? "" : bDay);
		this.country = (country == null ? "" : country);
	}

	public User(String username, String password) {
		this.username = (username == null ? "" : username);
		this.password = (password == null ? "" : password);
	}
	
	public User() {
		
	}

	public int getUId() {
		return uId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCountry() {
		return country;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getbDay() {
		return bDay;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User(" + username + ", " + email + ", " + firstName + ", " + lastName + ", " + bDay + ", " + country
				+ ") ";
	}
}
