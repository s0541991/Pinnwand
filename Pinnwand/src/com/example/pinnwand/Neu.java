package com.example.pinnwand;

import database.ThreadDBHandler;
import database.PinnwandThread;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Neu extends Activity implements View.OnClickListener {
	EditText et_threadname, et_description;
	Button b_create;
	ThreadDBHandler newThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_neu);

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
		switch (v.getId()) {
		case R.id.b_create:
			// create new thread
			PinnwandThread pinnwandThread = new PinnwandThread(threadname, description, date, deadline);
			
			if(threadname.equals("")){
				Toast.makeText(getApplicationContext(), "threadname Vaccant", Toast.LENGTH_LONG).show();
			}
			else{
				newThread.addThread(pinnwandThread);
				Toast.makeText(getApplicationContext(), "thread created!", Toast.LENGTH_LONG).show();
				startActivity(new Intent(Neu.this, MeineThreads.class));
			}
			//date from this time will be passed to thread
			break;
		}
	}
}
