package com.example.pinnwand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;

public class Mitglied extends PinnwandActivity {

	Button kontext_menu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mitglied);
		
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		
		registerForContextMenu(kontext_menu);
	}
}
