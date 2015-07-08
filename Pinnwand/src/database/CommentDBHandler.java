package database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CommentDBHandler {

	public static final String TAG = "UserDBHandler";
	// database fields
	private SQLiteDatabase db;
	private DBHandler dbHandler;

	protected static final String TABLE_NAMEC = "Comment";
	private static final String COL_NID = "nId";
	private static final String COL_COMMENT = "comment";
	private static final String COL_TIMESTAMP = "timestamp";
	protected static final String CREATE_COMMENT_TABLE = "CREATE TABLE "
			+ TABLE_NAMEC
			+ "(" 
			+ COL_NID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COL_COMMENT
			+ " TEXT NOT NULL, " 
			+ COL_TIMESTAMP 
			+ " TEXT, "
			+ ThreadDBHandler.COL_TID 
			+ " INTEGER NOT NULL, "
			+ UserDBHandler.COL_UID 
			+ " INTEGER NOT NULL, " 
			+ "FOREIGN KEY("
			+ UserDBHandler.COL_UID 
			+ ") REFERENCES " 
			+ UserDBHandler.TABLE_NAMEU 
			+ "("
			+ UserDBHandler.COL_UID 
			+ " ) ON DELETE CASCADE, " 
			+ "FOREIGN KEY("
			+ ThreadDBHandler.COL_TID 
			+ ") REFERENCES " 
			+ ThreadDBHandler.TABLE_NAMET 
			+ "("
			+ ThreadDBHandler.COL_TID 
			+ ") ON DELETE CASCADE)";


		protected static final String RETURN_COMMENTS = "SELECT " + TABLE_NAMEC
		+ "." + COL_COMMENT + "," + TABLE_NAMEC + "." + COL_TIMESTAMP + ","
		+ ThreadDBHandler.TABLE_NAMET + "."
		+ ThreadDBHandler.COL_THREADNAME + "FROM " + TABLE_NAMEC + ","
		+ ThreadDBHandler.TABLE_NAMET + "where " + TABLE_NAMEC + "."
		+ ThreadDBHandler.COL_TID + "=" + ThreadDBHandler.TABLE_NAMET + "."
		+ ThreadDBHandler.COL_TID + ";";

	public CommentDBHandler(Context context) {
		dbHandler = new DBHandler(context);
		// open the database
		try {
			open();
		} catch (SQLException e) {
			Log.e(TAG, "SQLException on openning database " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void open() throws SQLException {
		db = dbHandler.getWritableDatabase();
	}

	public void close() {
		dbHandler.close();
	}

}
