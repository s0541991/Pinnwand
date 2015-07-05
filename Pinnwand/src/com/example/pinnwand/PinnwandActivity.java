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
	UserLocalStore userLocalStore;

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.context, menu);
		userLocalStore = new UserLocalStore(this);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){	//choose between the context menu activitys
			case R.id.suche:
					startActivity(new Intent(PinnwandActivity.this, Suche.class));
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
					startActivity(new Intent(PinnwandActivity.this, PinnwandActivity.class));
				break;
			case R.id.logout:
					userLocalStore.clearUserData();			//loescht userdaten der logged in ist
					userLocalStore.setUserLoggedIn(false);	//setzt log in status auf falsch (logged out)
					startActivity(new Intent(PinnwandActivity.this, Login.class));
				break;
		}
		return super.onContextItemSelected(item);
	}
}
