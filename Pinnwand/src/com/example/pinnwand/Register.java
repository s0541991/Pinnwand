package com.example.pinnwand;

import android.os.Bundle;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Register extends PinnwandActivity implements View.OnClickListener{

	Button b_SignUp;
	EditText edit_firstName, edit_lastName, edit_bDay, edit_country;
	EditText edit_Email, edit_Username, edit_Password;
	TextView text_Return;
	SQLiteDatabase db;
	userDBHandler registerUser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		edit_firstName = (EditText) findViewById(R.id.edit_firstName);
		edit_lastName = (EditText) findViewById(R.id.edit_lastName);
		edit_bDay = (EditText) findViewById(R.id.edit_bDay);
		edit_country = (EditText) findViewById(R.id.edit_country);
		edit_Email = (EditText) findViewById(R.id.edit_Email);
		edit_Username = (EditText) findViewById(R.id.edit_Username);
		edit_Password = (EditText) findViewById(R.id.edit_Password);
		
		b_SignUp = (Button) findViewById(R.id.b_SignUp);
		b_SignUp.setOnClickListener(this);
		
		text_Return = (TextView) findViewById(R.id.text_Return);
		text_Return.setOnClickListener(this);
		
		registerUser = new userDBHandler(this, null, null, 1);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.b_SignUp:
					String firstName 		= edit_firstName.getText().toString();
					String lastName 	= edit_lastName.getText().toString();
					String bDay = edit_bDay.getText().toString();
					String country 		= edit_country.getText().toString();
					String email		= edit_Email.getText().toString();
					String username 	= edit_Username.getText().toString();
					String password 	= edit_Password.getText().toString();
					
					//constructor mit den eingabe variabeln
					User newUser = new User(username, password, email, firstName, lastName, bDay, country); 	
					registerUser.addUser(newUser);
					startActivity(new Intent(Register.this, Login.class));
				break;
			case R.id.text_Return:
					startActivity(new Intent(Register.this, Login.class));
				break;
		}
	}

}
