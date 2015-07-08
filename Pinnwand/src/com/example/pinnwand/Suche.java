package com.example.pinnwand;

import database.ThreadDBHandler;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Suche extends PinnwandActivity implements View.OnClickListener{
	
	Button b_suche, kontext_menu;
	EditText et_suche;
	ThreadDBHandler threadDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suche);
		
		et_suche = (EditText) findViewById(R.id.et_suche);
		threadDB = new ThreadDBHandler(getApplicationContext());
		
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		registerForContextMenu(kontext_menu);
		
		b_suche = (Button) findViewById(R.id.b_suche);
		b_suche.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v){
		String suche = et_suche.getText().toString();
		switch(v.getId()){
			case R.id.b_suche:
					PinnwandApplication appState = ((PinnwandApplication) this.getApplicationContext());
					appState.setCurrentTid(threadDB.threadSuche(suche));	//gefundende ID einfuegen
					startActivity(new Intent( this, ReadThread.class));
				break;
		}
	}
}
