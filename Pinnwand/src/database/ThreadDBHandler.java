package database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ThreadDBHandler {
	public static final String TAG = "ThreadDBHandler";
	private SQLiteDatabase db;
	private DBHandler dbHandler;
	// thread table columns
	static final String TABLE_NAMET = "Thread";
	static final String COL_TID = "tId";
	private static final String COL_THREADNAME = "threadName";
	private static final String COL_DESCRIPTION = "description";
	private static final String COL_DATE = "date";
	private static final String COL_DEADLINE = "deadline";
	protected static final String CREATE_THREAD_TABLE = "CREATE TABLE "
			+ TABLE_NAMET + "(" + COL_TID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_THREADNAME
			+ " TEXT NOT NULL, " + COL_DESCRIPTION + " TEXT, " + COL_DATE
			+ " TEXT, " + COL_DEADLINE + " TEXT, " + UserDBHandler.COL_UID
			+ " INTEGER NOT NULL, " + "FOREIGN KEY(" + UserDBHandler.COL_UID
			+ ") REFERENCES" + UserDBHandler.TABLE_NAMEU + "("
			+ UserDBHandler.COL_UID + ") ON DELETE CASCADE";

	// "FOREIGN KEY(COL_UID) REFERENCES TABLE_NAMEN(COL_UID) ON DELETE CASCADE"+
	// ")";

	public ThreadDBHandler(Context context) {
		dbHandler = new DBHandler(context);
		try {
			open();
		} catch (SQLException e) {
			Log.e(TAG, "SQLException on openning database " + e.getMessage());
			e.printStackTrace();
		}

		Log.d("nhanh", "ThreadDB constr 2");
	}

	public void open() throws SQLException {
		db = dbHandler.getWritableDatabase();
	}

	public void close() {
		dbHandler.close();
	}

	// ===============TABLE_NAMET Functions==================
	public void addThread(PinnwandThread thread) {
		ContentValues values = new ContentValues();
		values.put(COL_THREADNAME, thread.getName());
		values.put(COL_DESCRIPTION, thread.getDescription());
		values.put(COL_DATE, thread.getDate());
		values.put(COL_DEADLINE, thread.getDeadline());
		values.put(UserDBHandler.COL_UID, thread.getUserId());

		db.insert(TABLE_NAMET, null, values);
		db.close();
	}
	
	public ArrayList<PinnwandComment> getComments(int threadId) {
		// TODO Need some MySQL
		return null;
	}

	public ArrayList<PinnwandThread> getAllThreads() {
		ArrayList<PinnwandThread> threadList = new ArrayList<PinnwandThread>();
		SQLiteDatabase db = dbHandler.getWritableDatabase();
		String query = "SELECT * FROM " + TABLE_NAMET + ";";

		// Cursor points to a location in your results
		Cursor c = db.rawQuery(query, null);
		// Move to the first row in your results
		c.moveToFirst();
		while (!c.isAfterLast()) {
			if (c.getString(c.getColumnIndex(COL_THREADNAME)) != null) {
				threadList.add(toThread(c));
			}
			c.moveToNext();
		}
		c.close();
		db.close();
		return threadList;
	}
	
	private PinnwandThread toThread(Cursor c) {
		PinnwandThread t = new PinnwandThread();
		t.setDate(c.getString(c.getColumnIndex(COL_DATE)));
		t.setDeadline(c.getString(c.getColumnIndex(COL_DEADLINE)));
		t.setDescription(c.getString(c.getColumnIndex(COL_DESCRIPTION)));
		t.setName(c.getString(c.getColumnIndex(COL_THREADNAME)));
		t.settId(c.getInt(c.getColumnIndex(COL_TID)));
		return t;
	}
}
