package com.example.pinnwand;

import android.content.Context;
import android.content.SharedPreferences;


//klasse um user daten auf dem handy zu speichern
public class UserLocalStore {
	public static String SP_NAME = "userDetails";
	SharedPreferences userLocalDatabase;	//SharedPreference laesst uns user daten auf dem handy zu speichern	
	
	public UserLocalStore(Context context){
		userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
	}
	
	//speichert user daten mit einem user parameter
	public void storeUserData(User user){
		SharedPreferences.Editor spEditor = userLocalDatabase.edit();
		spEditor.putString("username", user.getUsername());
		spEditor.putString("password", user.getPassword());
		spEditor.putString("email", user.getEmail());
		spEditor.putString("firstName", user.getFirstName());
		spEditor.putString("lastName", user.getLastName());
		spEditor.putString("bDay", user.getBDay());
		spEditor.putString("country", user.getCountry());
		spEditor.commit();
	}
	
	
	public User getLoggedInUser(){
		String username = userLocalDatabase.getString("username", "");
		String password = userLocalDatabase.getString("pasword", "");
		String email = userLocalDatabase.getString("email", "");
		String firstName = userLocalDatabase.getString("firstName", "");
		String lastName = userLocalDatabase.getString("lastName", "");
		String bDay = userLocalDatabase.getString("bDay", "");
		String country = userLocalDatabase.getString("country", "");
		
		User storedUser = new User(username, password, email, firstName, lastName, bDay, country);
		
		return storedUser;
	}
	
	//setted  ob user logged in ist oder nicht
	public void setUserLoggedIn(boolean loggedIn){
		SharedPreferences.Editor spEditor = userLocalDatabase.edit();
		spEditor.putBoolean("loggedIn", loggedIn);
		spEditor.commit();
	}
	
	//boolean um zu sagen ob user logged in ist
	public boolean getUserLoggedIn(){
		if(userLocalDatabase.getBoolean("loggedIn", false)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void clearUserData(){

		SharedPreferences.Editor spEditor = userLocalDatabase.edit();
		spEditor.clear();
		spEditor.commit();
	}
	
}
