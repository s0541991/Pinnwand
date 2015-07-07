package database;

public class PinnwandThread {

	private int tId = -1;
	private String name;
	private String description;
	private String date; // timestamp
	private String deadline;
	private int userId; // date?

	public PinnwandThread(String name, String description, String date, String deadline) {
		this.name = (name == null ? "" : name);
		this.description = (description == null ? "" : description);
		this.date = (date == null ? "" : date);
		this.deadline = (deadline == null ? "" : deadline);
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

	@Override
	public String toString() {
		return "Thread(" + name + ", " + description + ", " + date + ", "
				+ deadline + ") ";
	}
}
