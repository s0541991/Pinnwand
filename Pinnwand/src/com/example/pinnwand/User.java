package com.example.pinnwand;

public class User {

	private int uId = -1;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String bDay; // date?
	private String country;
	
	public User(String username, String password,String email, String firstName, String lastName, String bDay, String country ) {
		super();
		this.username = (username==null?"":username); 	// this.username = username;
		this.password = (password==null?"":password);	// this.password = password;
		this.email = (email==null?"":email);			// this.eMail = eMail;
		this.firstName = (firstName==null?"":firstName);// this.firstName = firstName;
		this.lastName = (lastName==null?"":lastName);	// this.lastName = lastName;
		this.bDay = (bDay==null?"":bDay);				// this.bDay = bDay;
		this.country = (country==null?"":country);		// this.country = country;
	}
	
	//konstruktor fuer log in
	public User(String username, String password){
		super();
		this.username = (username==null?"":username); 	// this.username = username;
		this.password = (password==null?"":password);	// this.password = password;
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
	public String getBDay() {
		return bDay;
	}
	public String getCountry() {
		return country;
	}
	
    @Override
    public String toString() {

      return "User(" +username + ", " + email + ", " + firstName + ", " + lastName + ", " + bDay + ", " + country + ") ";

    }

}
