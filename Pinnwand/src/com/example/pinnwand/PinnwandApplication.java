package com.example.pinnwand;

import android.app.Application;

public class PinnwandApplication extends Application {
	private int currentUid;
	private int currentClickedUid;
	private int currentTid;
	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	public int getCurrentUid() {
		return currentUid;
	}

	public int getCurrentClickedUid(){
		return currentClickedUid;
	}
	
	public void setCurrentUid(int currentUid) {
		this.currentUid = currentUid;
	}

	public void setCurrentClickedUid(int currentClickedUid){
		this.currentClickedUid = currentClickedUid;
	}
	
	public int getCurrentTid() {
		return currentTid;
	}

	public void setCurrentTid(int currentTid) {
		this.currentTid = currentTid;
	}
}
