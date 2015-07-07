package database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {
	private static DBHandler sInstance;

	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "user.db";

	// usertable columns
	private static final String TABLE_NAMEU = "User";
	private static final String COL_UID = "_uId";
	private static final String COL_USERNAME = "username";
	private static final String COL_PASSWORD = "password";
	private static final String COL_FIRSTNAME = "firstName";
	private static final String COL_LASTNAME = "lastName";
	private static final String COL_EMAIL = "email";
	private static final String COL_COUNTRY = "country";
	private static final String COL_BDAY = "bDay";
	private int currentUid;

	// thread table columns
	private static final String TABLE_NAMET = "Thread";
	private static final String COL_TID = "tId";
	private static final String COL_THREADNAME = "threadName";
	private static final String COL_DESCRIPTION = "description";
	private static final String COL_DATE = "date";
	private static final String COL_DEADLINE = "deadline";

	// comment table columns
	private static final String TABLE_NAMEC = "Comment";
	private static final String COL_NID = "nId";
	public static final String COL_COMMENT = "comment";
	public static final String COL_TIMESTAMP = "timestamp";

	// queries for the tables
	private static final String CREATE_USER_TABLE = "CREATE TABLE "
			+ TABLE_NAMEU + "(" + COL_UID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USERNAME + " TEXT, "
			+ COL_PASSWORD + " TEXT, " + COL_FIRSTNAME + " TEXT, "
			+ COL_LASTNAME + " TEXT, " + COL_EMAIL + " TEXT, " + COL_COUNTRY
			+ " TEXT, " + COL_BDAY + " TEXT " + ")";
	private static final String CREATE_THREAD_TABLE = "CREATE TABLE "
			+ TABLE_NAMET + "(" + COL_TID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_THREADNAME
			+ " TEXT NOT NULL, " + COL_DESCRIPTION + " TEXT, " + COL_DATE
			+ " TEXT, " + COL_DEADLINE + " TEXT, " + COL_UID
			+ " INTEGER NOT NULL) "; // "FOREIGN KEY(COL_UID) REFERENCES TABLE_NAMEN(COL_UID) ON DELETE CASCADE"+
										// ")";
	private static final String CREATE_COMMENT_TABLE = "CREATE TABLE "
			+ TABLE_NAMEC + "(" + COL_NID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_COMMENT
			+ " TEXT NOT NULL, " + COL_TIMESTAMP + " TEXT, " + COL_TID
			+ " INTEGER NOT NULL, " + COL_UID + " INTEGER NOT NULL)";

	// +
	// " FOREIGN KEY(COL_UID) REFERENCES TABLE_NAMEN(COL_UID) ON DELETE CASCADE "
	// +
	// " FOREIGN KEY(COL_TID) REFERENCES TABLE_NAMET(COL_TID) ON DELETE CASCADE "
	// + ")";

	public static synchronized DBHandler getInstance(Context context) {

		// Use the application context, which will ensure that you
		// don't accidentally leak an Activity's context.
		// See this article for more information: http://bit.ly/6LRzfx
		if (sInstance == null) {
			sInstance = new DBHandler(context.getApplicationContext());
		}
		return sInstance;
	}

	/**
	 * Constructor should be private to prevent direct instantiation. make call
	 * to static method "getInstance()" instead.
	 */
	public DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d("nhanh", "constructor");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// @formatter:off
		// @formatter:on
		Log.d("create", CREATE_USER_TABLE);
		Log.d("create", CREATE_THREAD_TABLE);
		db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_THREAD_TABLE);
		db.execSQL(CREATE_COMMENT_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("nhanh", "onUpgrade");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEU);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMET);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEC);
		onCreate(db);
	}

	// ================TABLE_NAMEU Functions================
	// neuen User in die tabelle
	public void addUser(User user) {
		Log.d("nhanh", "addUser");
		SQLiteDatabase db = getWritableDatabase();
		db.insert(TABLE_NAMEU, null, user.toContentValues());
		db.close();
	}

	// delete a user

	// change a user
	public void changeUser(int uid, User user) {
		Log.d("nhanh", "changeUser");
		SQLiteDatabase db = getWritableDatabase();
		db.update(TABLE_NAMEU, user.toContentValues(), COL_UID + " = " + uid,
				null);
	}

	public User getUser(int uid) {
		SQLiteDatabase db = getReadableDatabase();
		String[] columns = { COL_USERNAME, COL_PASSWORD, COL_FIRSTNAME,
				COL_LASTNAME, COL_EMAIL, COL_COUNTRY, COL_BDAY };
		Cursor cursor = db.query(TABLE_NAMEU, columns, COL_UID + " = " + uid,
				null, null, null, null);
		cursor.moveToFirst();
		ArrayList<String> values = new ArrayList<String>();
		Log.d("nhanh: uid = ", Integer.toString(uid));
		Log.d("nhanh", Integer.toString(cursor.getCount()));
		for (String column : columns) {
			values.add(cursor.getString(cursor.getColumnIndex(column)));
		}

		User user = new User();
		user.setUsername(values.get(0));
		user.setPassword(values.get(1));
		user.setFirstName(values.get(2));
		user.setLastName(values.get(3));
		user.setEmail(values.get(4));
		user.setCountry(values.get(5));
		user.setbDay(values.get(6));

		return user;
	}

	public boolean verifizierung(String username, String password) {
		SQLiteDatabase db = getReadableDatabase();
		// @formatter:off
		String query = "SELECT * FROM " + TABLE_NAMEU + " WHERE "
				+ COL_USERNAME + "=" + "'" + username + "'" + " AND "
				+ COL_PASSWORD + "=" + "'" + password + "'";
		// @formatter:on
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		if ((cursor != null) && (cursor.getCount() > 0)) {
			Log.d("nhanh", Integer.toString(cursor.getCount()));
			Log.d("nhanh", Integer.toString(cursor.getColumnCount()));
			Log.d("nhanh",
					cursor.getString(cursor.getColumnIndex(COL_USERNAME)));
			currentUid = cursor.getInt(cursor.getColumnIndex(COL_UID));
			return true;
		} else {
			return false;
		}
	}

	public int getCurrentUid() {
		return currentUid;
	}

	// print the database
	public String databaseToString() {
		String dbString = "";
		SQLiteDatabase db = getWritableDatabase();
		String query = "SELECT * FROM " + TABLE_NAMEU + " WHERE 1";
		Log.d("nhanh", query);

		// Cursor points to a location in your results
		Cursor c = db.rawQuery(query, null);
		// Move to the first row in your results
		c.moveToFirst();

		// Position after the last row means the end of the results
		while (!c.isAfterLast()) {
			if (c.getString(c.getColumnIndex(COL_USERNAME)) != null) {
				dbString += c.getString(c.getColumnIndex(COL_USERNAME)) + " "
						+ c.getString(c.getColumnIndex(COL_PASSWORD)) + " "
						+ c.getInt(c.getColumnIndex(COL_UID));
				dbString += "\n";
			}
			c.moveToNext();
		}
		c.close();
		db.close();
		return dbString;
	}

	// ===============TABLE_NAMET Functions==================
	public void addThread(PinnwandThread thread) {
		ContentValues values = new ContentValues();
		values.put(COL_THREADNAME, thread.getName());
		values.put(COL_DESCRIPTION, thread.getDescription());
		values.put(COL_DATE, thread.getDate());
		values.put(COL_DEADLINE, thread.getDeadline());
		values.put(COL_UID, thread.getUserId());

		SQLiteDatabase db = getWritableDatabase();
		db.insert(TABLE_NAMET, null, values);
		db.close();
	}

	public ArrayList<String> printThreadnamesToArrayList() {
		ArrayList<String> threadList = new ArrayList<String>();
		SQLiteDatabase db = getWritableDatabase();
		String query = "SELECT * FROM " + TABLE_NAMET + " WHERE 1";

		// Cursor points to a location in your results
		Cursor c = db.rawQuery(query, null);
		// Move to the first row in your results
		c.moveToFirst();
		while (!c.isAfterLast()) {
			if (c.getString(c.getColumnIndex(COL_THREADNAME)) != null) {
				threadList.add(c.getString(c.getColumnIndex(COL_THREADNAME)));
			}
			c.moveToNext();
		}
		c.close();
		db.close();

		return threadList;
	}
}
