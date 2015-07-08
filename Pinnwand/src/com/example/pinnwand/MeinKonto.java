package com.example.pinnwand;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import database.User;
import database.UserDBHandler;

public class MeinKonto extends PinnwandActivity {
	private Button kontext_menu, change, reset;
	private EditText et_vorname, et_nachname, et_geburtsdatum, et_wohnort,
			et_email, et_username, et_password;
	private UserDBHandler userDB;
	private int currentUid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mein_konto);
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		change = (Button) findViewById(R.id.change);
		reset = (Button) findViewById(R.id.reset);
		et_vorname = (EditText) findViewById(R.id.vorname);
		et_nachname = (EditText) findViewById(R.id.nachname);
		et_geburtsdatum = (EditText) findViewById(R.id.geburtsdatum);
		et_wohnort = (EditText) findViewById(R.id.wohnort);
		et_email = (EditText) findViewById(R.id.email);
		et_username = (EditText) findViewById(R.id.username);
		et_password = (EditText) findViewById(R.id.password);

		registerForContextMenu(kontext_menu);

		// Set up database
		userDB = new UserDBHandler(getApplicationContext());
		
		// Get user ID
		PinnwandApplication appState = ((PinnwandApplication) getApplicationContext());
		currentUid = appState.getCurrentUid();
		Log.d("MeinKonto: currentUid", Integer.toString(currentUid));

		populateWithDefaultValues();

		change.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				User user = new User();
				user.setFirstName(et_vorname.getText().toString());
				user.setLastName(et_nachname.getText().toString());
				user.setbDay(et_geburtsdatum.getText().toString());
				user.setCountry(et_wohnort.getText().toString());
				user.setEmail(et_email.getText().toString());
				user.setUsername(et_username.getText().toString());
				user.setPassword(et_password.getText().toString());
				userDB.changeUser(currentUid, user);
			}
		});

		reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				populateWithDefaultValues();
			}
		});
	}

	private void populateWithDefaultValues() {
		User user = userDB.getUser(currentUid);
		et_vorname.setText(user.getFirstName());
		et_nachname.setText(user.getLastName());
		et_geburtsdatum.setText(user.getbDay());
		et_wohnort.setText(user.getCountry());
		et_email.setText(user.getEmail());
		et_username.setText(user.getUsername());
		et_password.setText(user.getPassword());
	}
}
