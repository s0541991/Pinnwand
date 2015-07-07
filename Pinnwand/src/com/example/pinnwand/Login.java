package com.example.pinnwand;

import database.DBHandler;
import database.UserDBHandler;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends PinnwandActivity implements View.OnClickListener {

	private Button b_Login;
	private EditText et_Username, et_Password;
	private TextView text_SignUpLink, dbTest;
	private UserDBHandler userDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		et_Username = (EditText) findViewById(R.id.edit_UserName);
		et_Password = (EditText) findViewById(R.id.edit_Password);

		b_Login = (Button) findViewById(R.id.b_Login);
		b_Login.setOnClickListener(this);

		text_SignUpLink = (TextView) findViewById(R.id.text_SignUpLink);
		text_SignUpLink.setOnClickListener(this);

		dbTest = (TextView) findViewById(R.id.dbTest);

		Log.d("nhanh","works1");
		userDB = new UserDBHandler(this);
		Log.d("nhanh","works2");

		printDatabase();
	}

	@Override
	public void onClick(View v) {
		String username = et_Username.getText().toString();
		String password = et_Password.getText().toString();
		switch (v.getId()) {
		case R.id.b_Login: // fallst id vom onClick = b_login ist
			Log.d("clicked log in", Boolean.toString(userDB.verifizierung(username, password)));

			if (userDB.verifizierung(username, password) == true) {
				Log.d("nhanh", "logged in");
				Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

				startActivity(new Intent(Login.this, MeineThreads.class));
				finish();
			} else {
				Toast.makeText(Login.this, "Username or Password false", Toast.LENGTH_LONG).show();
				Log.d("nhanh", "wrong username or pw");
			}
			break;
		case R.id.text_SignUpLink: // afu sign up link geclick
			startActivity(new Intent(Login.this, Register.class));
			finish();
			break;
		}
	}

	public void printDatabase() {
		String dbString = userDB.databaseToString();
		dbTest.setText(dbString);
	}
}
