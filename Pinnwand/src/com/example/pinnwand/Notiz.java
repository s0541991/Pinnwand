package com.example.pinnwand;

public class Notiz {
	
		private int nId = -1;
		private String Comment;
		private String Timestamp;
		private int threadId;
		private int userId;
		
		public Notiz(String Comment, String Timestamp) {
			super();
			this.Comment = (Comment==null?"":Comment); 	// this.Comment = Comment;
			this.Timestamp = (Timestamp==null?"":Timestamp);	// this.Timestamp = Timestamp;
		}
		
		public int getNId() {
			return nId;
		}
		public String getComment() {
			return Comment;
		}
		public String getTimestamp() {
			return Timestamp;
		}	
		public int getThreadId() {
			return threadId;
		}
		public int getUserId() {
			return userId;
		}
		
	    @Override
	    public String toString() {

	      return "Notiz(" +Comment + ", " + Timestamp  + ") ";

	    }
}

