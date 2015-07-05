package com.example.pinnwand;

public class Thread {

	private int tId = -1;
	private String Name;
	private String Description;
	private String Date;
	private String Deadline;
	private int userId; // date?
	
	public Thread(String Name, String Description, String Date, String Deadline) {
		super();
		this.Name = (Name==null?"":Name); 						// this.Name = Name;
		this.Description = (Description==null?"":Description);	// this.Description = Description;
		this.Date = (Date==null?"":Date);						// this.Date = Date;
		this.Deadline = (Deadline==null?"":Deadline);			// this.Deadline = Deadline;
	}
	
	public int getTId() {
		return tId;
	}
	public String getName() {
		return Name;
	}
	public String getDescription() {
		return Description;
	}	
	public String getDate() {
		return Date;
	}
	public String getDeadline() {
		return Deadline;
	}
	public int getUserId() {
		return userId;
	}
	
    @Override
    public String toString() {

      return "Thread(" +Name + ", " + Description + ", " + Date + ", " + Deadline + ") ";

    }

}
