package com.example.pinnwand;

import android.os.Bundle;
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
