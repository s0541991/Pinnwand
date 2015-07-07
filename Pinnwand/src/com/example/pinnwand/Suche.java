package com.example.pinnwand;

import database.ThreadDBHandler;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Suche extends Activity implements View.OnClickListener{

	Button b_suche;
	EditText et_suche;
	ThreadDBHandler threadDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suche);
		
		et_suche = (EditText) findViewById(R.id.et_suche);
		threadDB = new ThreadDBHandler(getApplicationContext());
		
		b_suche = (Button) findViewById(R.id.b_suche);
		b_suche.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v){
		String suche = et_suche.getText().toString();
		switch(v.getId()){
			case R.id.b_suche:
					
				break;
		}
	}
}
