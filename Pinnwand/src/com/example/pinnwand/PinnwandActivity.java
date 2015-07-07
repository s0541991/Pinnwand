package com.example.pinnwand;

import database.UserDBHandler;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;

//klasse um Kontext menu ueberall zu implementieren
public class PinnwandActivity extends FragmentActivity {
	Button kontext_menu;

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.context, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) { // choose between the context menu activitys
		case R.id.suche:
			startActivity(new Intent(PinnwandActivity.this, Suche.class));
			break;
		case R.id.neu:
			startActivity(new Intent(PinnwandActivity.this, Neu.class));
			break;
		case R.id.mein_konto:
			startActivity(new Intent(PinnwandActivity.this, MeinKonto.class));
			finish();
			break;
		case R.id.meine_threads:
			startActivity(new Intent(PinnwandActivity.this, MeineThreads.class));
			break;
		case R.id.aktualisieren:
			startActivity(new Intent(PinnwandActivity.this, PinnwandActivity.class));
			break;
		case R.id.logout:
			startActivity(new Intent(PinnwandActivity.this, Login.class));
			PinnwandApplication appState = ((PinnwandApplication) getApplicationContext());
			appState.setCurrentUid(-1);
			finish();
			break;
		}
		return super.onContextItemSelected(item);
	}
}
