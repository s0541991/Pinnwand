package com.example.pinnwand;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends PinnwandActivity implements View.OnClickListener{
	//globale variabeln vom Typ Button und EditText
	Button b_Login;
	EditText et_Username, et_Password;
	TextView text_SignUpLink;
	UserLocalStore userLocalStore;
	
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
		
		userLocalStore = new UserLocalStore(this);
		
	}
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	//fallst der userloggd in ist, dann true
	private boolean verifizierung(){
		return userLocalStore.getUserLoggedIn();
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String username = et_Username.getText().toString();
		String password = et_Password.getText().toString();
		switch(v.getId()){
			case R.id.b_Login:		//fallst id vom onClick = b_login ist

					User user = new User(username, password);
					userLocalStore.storeUserData(user);
					
					//if() set userloggedin data correct then set true, else false
					//need to check in the database if the username and password is correct
					userLocalStore.setUserLoggedIn(true);	//user ist logged in
					
					
					if(verifizierung()==true){
						startActivity(new Intent(Login.this, MeineThreads.class));
						finish();
					}
					else{
						
					}
				break;
			case R.id.text_SignUpLink:	//afu sign up link geclick 
					startActivity(new Intent(Login.this, Register.class));
				break;
		}
	}

}
