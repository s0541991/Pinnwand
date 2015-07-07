package com.example.pinnwand;

import android.app.Application;
import database.DBHandler;

public class PinnwandApplication extends Application {
	private int currentUid;
	
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
}
