package database;

import android.database.Cursor;

public class PinnwandComment {
	private int nId = -1;
	private String comment;
	private String timestamp;
	private int threadId;
	private int userId;
	
	public PinnwandComment(String comment, String timestamp, int threadId, int userId) {
		this.comment = (comment == null ? "" : comment);
		this.timestamp = (timestamp == null ? "" : timestamp);
		this.threadId = threadId;
		this.userId = userId;
	}

	public PinnwandComment() {
		// TODO Auto-generated constructor stub
	}

	public int getNId() {
		return nId;
	}

	public String getComment() {
		return comment;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public int getThreadId() {
		return threadId;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "(" + comment + ")";

	}
	
	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
