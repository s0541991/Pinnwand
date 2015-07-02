package com.example.pinnwand;


import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements View.OnClickListener{
	//globale variabeln vom Typ Button und EditText
	Button b_Login;
	EditText edit_Username, edit_Password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		edit_Username = (EditText) findViewById(R.id.edit_UserName);
		edit_Password = (EditText) findViewById(R.id.edit_Password);
		
		
		b_Login = (Button) findViewById(R.id.b_Login);
		b_Login.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.b_Login:		//fallst id vom onClick = b_login ist
				
				
				break;
		}
	}

}
