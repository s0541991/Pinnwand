package com.example.pinnwand;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Register extends PinnwandActivity implements View.OnClickListener{

	Button b_SignUp;
	EditText edit_Vorname, edit_Nachname, edit_Geburtsdatum, edit_Wohnort;
	EditText edit_Email, edit_Username, edit_Password;
	TextView text_Return;
	SQLiteDatabase db;
	userDBHandler registerUser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		edit_Vorname = (EditText) findViewById(R.id.edit_Vorname);
		edit_Nachname = (EditText) findViewById(R.id.edit_Nachname);
		edit_Geburtsdatum = (EditText) findViewById(R.id.edit_Geburtsdatum);
		edit_Wohnort = (EditText) findViewById(R.id.edit_Wohnort);
		edit_Email = (EditText) findViewById(R.id.edit_Email);
		edit_Username = (EditText) findViewById(R.id.edit_Username);
		edit_Password = (EditText) findViewById(R.id.edit_Password);
		
		b_SignUp = (Button) findViewById(R.id.b_SignUp);
		b_SignUp.setOnClickListener(this);
		
		text_Return = (TextView) findViewById(R.id.text_Return);
		text_Return.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.b_SignUp:
					String vorname 		= edit_Vorname.getText().toString();
					String nachname 	= edit_Nachname.getText().toString();
					String geburtsdatum = edit_Geburtsdatum.getText().toString();
					String wohnort 		= edit_Wohnort.getText().toString();
					String email		= edit_Email.getText().toString();
					String username 	= edit_Username.getText().toString();
					String password 	= edit_Password.getText().toString();
					
					//constructor mit den eingabe variabeln
					User newUser = new User(username, password, email, vorname, nachname, geburtsdatum, wohnort); 	
					registerUser.addUser(newUser);
				break;
			case R.id.text_Return:
					startActivity(new Intent(Register.this, Login.class));
				break;
		}
	}

}
