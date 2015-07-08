package com.example.pinnwand;

import android.app.Application;
import database.DBHandler;

public class PinnwandApplication extends Application {
	private int currentUid;
	private int currentTid;
	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	public int getCurrentUid() {
		return currentUid;
	}

	public void setCurrentUid(int currentUid) {
		this.currentUid = currentUid;
	}

	public int getCurrentTid() {
		return currentTid;
	}

	public void setCurrentTid(int currentTid) {
		this.currentTid = currentTid;
	}
}
