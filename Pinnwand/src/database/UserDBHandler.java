package database;

import java.util.ArrayList;

import com.example.pinnwand.PinnwandApplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserDBHandler {
	public static final String TAG = "UserDBHandler";
	// database fields
	private SQLiteDatabase db;
	private DBHandler dbHandler;
	private Context mContext;
	// usertable columns
	static final String TABLE_NAMEU = "User";
	static final String COL_UID = "_uId";
	private static final String COL_USERNAME = "username";
	private static final String COL_PASSWORD = "password";
	private static final String COL_FIRSTNAME = "firstName";
	private static final String COL_LASTNAME = "lastName";
	private static final String COL_EMAIL = "email";
	private static final String COL_COUNTRY = "country";
	private static final String COL_BDAY = "bDay";
	protected static final String CREATE_USER_TABLE = "CREATE TABLE "
			+ TABLE_NAMEU
			+ "("
			+ COL_UID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COL_USERNAME
			+ " TEXT, "
			+ COL_PASSWORD
			+ " TEXT, " 
			+ COL_FIRSTNAME 
			+ " TEXT, "
			+ COL_LASTNAME 
			+ " TEXT, " 
			+ COL_EMAIL 
			+ " TEXT, " 
			+ COL_COUNTRY
			+ " TEXT, "
			+ COL_BDAY 
			+ " TEXT "
			+ ")";

	public UserDBHandler(Context context) {
		mContext = context;
		dbHandler = new DBHandler(context); 
		// open the database
		try {
			open();
		} catch (SQLException e) {
			Log.e(TAG, "SQLException on openning database " + e.getMessage());
			e.printStackTrace();
		}

		Log.d("UserDBHandler", "constructor");
	}

	public void open() throws SQLException {
		db = dbHandler.getWritableDatabase();
	}

	public void close() {
		dbHandler.close();
	}

	// ================TABLE_NAMEU Functions================
	// neuen User in die tabelle
	public void addUser(User user) {
		Log.d("UserDBHandler", "addUser");
		db.insert(TABLE_NAMEU, null, toContentValues(user));
		db.close();
	}

	// change a user
	public void changeUser(int uid, User user) {
		Log.d("UserDBHandler", "changeUser");
		db.update(TABLE_NAMEU, toContentValues(user), COL_UID + " = " + uid,
				null);
	}

	public User getUser(int uid) {
		String[] columns = { COL_USERNAME, COL_PASSWORD, COL_FIRSTNAME,
				COL_LASTNAME, COL_EMAIL, COL_COUNTRY, COL_BDAY };
		Cursor cursor = db.query(TABLE_NAMEU, columns, COL_UID + " = " + uid,
				null, null, null, null);
		cursor.moveToFirst();
		ArrayList<String> values = new ArrayList<String>();
		Log.d("UserDBHandler.getUser", Integer.toString(uid));
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
	
	//check if the user and password is true
	public boolean verifizierung(String username, String password) {
		// @formatter:off
		open();
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
			int currentUid = cursor.getInt(cursor.getColumnIndex(COL_UID));	//save currentUid - know who is logged in
			PinnwandApplication appState = ((PinnwandApplication) mContext.getApplicationContext());
			appState.setCurrentUid(currentUid);
			Log.d("UserDBHandler", "verifizierung: currentUid set to " + currentUid);
			return true;
		} else {
			return false;
		}
	}

	//function to check if the registered username is taken
	public boolean checkIfExist(String username){
		open();
		String query = "SELECT * FROM " + TABLE_NAMEU + " WHERE "
				+ COL_USERNAME + "=" + "'" + username + "'";
		// @formatter:on
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		if ((cursor != null) && (cursor.getCount() > 0)) {
			return true;
		} else {
			return false;
		}
	}
	// print the database
	public String databaseToString() {
		String dbString = "";
		String query = "SELECT * FROM " + TABLE_NAMEU + " WHERE 1";
		
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

	public ContentValues toContentValues(User user) {
		ContentValues values = new ContentValues();
		values.put(UserDBHandler.COL_USERNAME, user.getUsername());
		values.put(UserDBHandler.COL_PASSWORD, user.getPassword());
		values.put(UserDBHandler.COL_FIRSTNAME, user.getFirstName());
		values.put(UserDBHandler.COL_LASTNAME, user.getLastName());
		values.put(UserDBHandler.COL_EMAIL, user.getEmail());
		values.put(UserDBHandler.COL_COUNTRY, user.getCountry());
		values.put(UserDBHandler.COL_BDAY, user.getbDay());
		return values;
	}
}
