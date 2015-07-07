package com.example.pinnwand;

import java.util.ArrayList;

import database.DBHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MeineThreads extends PinnwandActivity {
	TextView thread; 
	Button kontext_menu;
	DBHandler allThreads;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meine_threads);
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		
		registerForContextMenu(kontext_menu);

		thread = (TextView) findViewById(R.id.thread);
		Log.d("nhanh","entered MeineThreads");
		allThreads = new DBHandler(MeineThreads.this); 

		Log.d("nhanh", "ThreadDBHandler constructor successful");
		printThreads();
	}
	
	public void printThreads(){
		Log.d("nhanh","there is no table");
		ArrayList<String> threadList = allThreads.printThreadnamesToArrayList();
		Log.d("nhanh","there is a table");
		String currentThread = threadList.get(2);
		thread.setText(currentThread);
	}
}
