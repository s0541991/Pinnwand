package com.example.pinnwand;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class ReadThread extends PinnwandActivity {

	Button kontext_menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_thread);
		
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		
		registerForContextMenu(kontext_menu);

	}


}
