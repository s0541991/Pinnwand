package database;

import java.io.Serializable;

public class PinnwandThread implements Serializable {
	
	private static final long serialVersionUID = 3845508773567681979L;
	private int tId = -1;
	private String name;
	private String description;
	private String date; // timestamp
	private String deadline;
	private int userId; // date?

	public PinnwandThread(String name, String description, String date, String deadline, int userId) {
		this.name = (name == null ? "" : name);
		this.description = (description == null ? "" : description);
		this.date = (date == null ? "" : date);
		this.deadline = (deadline == null ? "" : deadline);
		this.userId = userId;
	}
	
	public PinnwandThread() {
		
	}

	public int getTId() {
		return tId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getDeadline() {
		return deadline;
	}

	public int getUserId() {
		return userId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String toString() {
		return "{name: " + name + ", description: " + description + ", date: " + date + ", deadline: " + deadline + ", tId = " + tId + ", userId: " + userId + "}"; 
	}
}
