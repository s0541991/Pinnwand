package com.example.pinnwand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MeineThreads extends Activity {
	
	Button kontext_menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meine_threads);
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		
		registerForContextMenu(kontext_menu);
	}	

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.context, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case R.id.suche:
				break;	
			case R.id.neu:
				break;
			case R.id.mein_konto:
					startActivity(new Intent(MeineThreads.this, MeinKonto.class));
				break;
			case R.id.meine_threads:
				break;
			case R.id.aktualisieren:
				break;
			case R.id.logout:
					startActivity(new Intent(MeineThreads.this, Login.class));
				break;
		}
		return super.onContextItemSelected(item);
	}
}