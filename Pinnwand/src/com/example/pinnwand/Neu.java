package com.example.pinnwand;

import database.ThreadDBHandler;
import database.PinnwandThread;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Neu extends PinnwandActivity implements View.OnClickListener {
	EditText et_threadname, et_description;
	Button b_create, kontext_menu;
	ThreadDBHandler newThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_neu);

		// Context menu
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		registerForContextMenu(kontext_menu);
		
		et_threadname = (EditText) findViewById(R.id.et_threadname);
		et_description = (EditText) findViewById(R.id.et_description);

		b_create = (Button) findViewById(R.id.b_create);
		b_create.setOnClickListener(this);
		
		newThread = new ThreadDBHandler(getApplicationContext());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String threadname = et_threadname.getText().toString();
		String description = et_description.getText().toString();
		String date = "";
		String deadline = "";	//date + 3 months
		
		PinnwandApplication appState = (PinnwandApplication) getApplicationContext();
		final int currentUserId = appState.getCurrentUid();
		switch (v.getId()) {
		case R.id.b_create:
			// create new thread

		PinnwandThread pinnwandThread = new PinnwandThread(threadname, description, date, deadline, currentUserId);
		
		if(threadname.equals("")){
			Toast.makeText(getApplicationContext(), "Thread name vacant", Toast.LENGTH_LONG).show();
		}
		else{

				newThread.addThread(pinnwandThread);

				Toast.makeText(getApplicationContext(), "Thread created!", Toast.LENGTH_LONG).show();

				startActivity(new Intent(Neu.this, MeineThreads.class));
				finish();
			}
			//date from this time will be passed to thread
			break;
		}
	}
}
