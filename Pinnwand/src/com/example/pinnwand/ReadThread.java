package com.example.pinnwand;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import database.CommentDBHandler;
import database.PinnwandComment;
import database.PinnwandThread;
import database.ThreadDBHandler;
import database.UserDBHandler;

public class ReadThread extends PinnwandActivity {
	private Button kontext_menu, b_postComment;
	private TextView tv_threadName, tv_threadDescription;
	private EditText et_addComment;
	private ListView lv_comments;
	private PinnwandThread currentThread;
	private ArrayAdapter<String> mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_thread);
		
		// Context menu
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		registerForContextMenu(kontext_menu);
		
		// Read thread from database
		PinnwandApplication appState = (PinnwandApplication) getApplicationContext();
		final int currentTid = appState.getCurrentTid();
		final int currentUserId = appState.getCurrentUid();
		ThreadDBHandler threadsDB = new ThreadDBHandler(getApplicationContext());
		currentThread = threadsDB.getThread(currentTid);
		
		// Set text
		tv_threadName = (TextView) findViewById(R.id.readThreadName);
		tv_threadDescription = (TextView) findViewById(R.id.readThreadDescription);
		tv_threadName.setText(currentThread.getName());
		tv_threadDescription.setText(currentThread.getDescription());
		
		// Populate ListView
		lv_comments = (ListView) findViewById(R.id.readThreadComments);
		ArrayList<String> commentStrings = new ArrayList<String>();
		ArrayList<PinnwandComment> comments = threadsDB.getComments(currentTid);
		UserDBHandler usersDB = new UserDBHandler(getApplicationContext());
		for (PinnwandComment comment : comments) {
			String username = usersDB.getUser(comment.getUserId()).getUsername();
			commentStrings.add(username + ": " + comment.getComment());
		}
		mAdapter = new ArrayAdapter<String>(this, R.layout.list_item, commentStrings);
		lv_comments.setAdapter(mAdapter);
		
		// Posting comment
		b_postComment = (Button) findViewById(R.id.postComment);
		b_postComment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Save comment to comments DB
				et_addComment = (EditText) findViewById(R.id.addComment);
				String newComment = et_addComment.getText().toString();
				CommentDBHandler commentsDB = new CommentDBHandler(getApplicationContext());
				commentsDB.addComment(new PinnwandComment(newComment, "", currentTid, currentUserId));
				
				// Clear field
				et_addComment.setText("");
				startActivity(new Intent(ReadThread.this, ReadThread.class));
				finish();
			}
		});
	}


}
