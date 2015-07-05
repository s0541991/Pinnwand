package com.example.pinnwand;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Neu extends Activity implements View.OnClickListener{

	EditText et_threadname, et_beschreibung;
	Button b_create;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_neu);
		
		et_threadname = (EditText) findViewById(R.id.et_threadname);
		et_beschreibung = (EditText) findViewById(R.id.et_beschreibung);
		
		b_create = (Button) findViewById(R.id.b_create);
		b_create.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.b_create:
				//create new thread
			break;
		}
	}


}
