package com.example.pinnwand;

import database.User;
import database.UserDBHandler;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Mitglied extends PinnwandActivity {
	Button kontext_menu;
	TextView tv_firstname, tv_lastname, tv_email, tv_bday, tv_country, tv_username;
	private UserDBHandler userDB;
	private int currentClickedUid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mitglied);

		kontext_menu = (Button) findViewById(R.id.kontext_menu);

		tv_firstname = (TextView) findViewById(R.id.firstname);
		tv_lastname = (TextView) findViewById(R.id.lastname);
		tv_email = (TextView) findViewById(R.id.email);
		tv_bday = (TextView) findViewById(R.id.bDay);
		tv_country = (TextView) findViewById(R.id.country);
		tv_username = (TextView) findViewById(R.id.username);
		registerForContextMenu(kontext_menu);
		
		userDB = new UserDBHandler(getApplicationContext());
		
		PinnwandApplication appState = ((PinnwandApplication) getApplicationContext());
		currentClickedUid = appState.getCurrentClickedUid();
		Log.d("nhanh clickedUid","" + currentClickedUid);
		
		populateWithDefaultValues();
		
	}
	
	private void populateWithDefaultValues() {
		User user = userDB.getUser(currentClickedUid);
		tv_firstname.setText(user.getFirstName());
		tv_lastname.setText(user.getLastName());
		tv_bday.setText(user.getbDay());
		tv_country.setText(user.getCountry());
		tv_email.setText(user.getEmail());
		tv_username.setText(user.getUsername());
	}
	
}
