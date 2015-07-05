package com.example.pinnwand;

import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;

//klasse um Kontext menu ueberall zu implementieren
public class PinnwandActivity extends Activity{
	Button kontext_menu;
	

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
		switch(item.getItemId()){	//choose between the context menu activitys
			case R.id.suche:
				break;	
			case R.id.neu:
					startActivity(new Intent(PinnwandActivity.this, Neu.class));
				break;
			case R.id.mein_konto:
					startActivity(new Intent(PinnwandActivity.this, MeinKonto.class));
				break;
			case R.id.meine_threads:
					startActivity(new Intent(PinnwandActivity.this, MeineThreads.class));
				break;
			case R.id.aktualisieren:
				break;
			case R.id.logout:
					startActivity(new Intent(PinnwandActivity.this, Login.class));
				break;
		}
		return super.onContextItemSelected(item);
	}
}
