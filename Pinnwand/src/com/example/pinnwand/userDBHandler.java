package com.example.pinnwand;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class userDBHandler extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "user.db";
	private static final String TABLE_NAMEU = "User";
	private static final String COL_UID = "uId";
	public static final String COL_USERNAME = "userName";
	public static final String COL_PASSWORD = "password";
    public static final String COL_FIRSTNAME = "firstName"; 
    public static final String COL_LASTNAME = "lastName"; 
    public static final String COL_EMAIL = "email";
    public static final String COL_COUNTRY = "country";
    public static final String COL_BDAY = "bDay";
    
    public userDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
    	super (context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String query = "create table " + TABLE_NAMEU + " ("
		    		+ COL_UID + " integer primary key autoincrement, "
		    		+ COL_USERNAME + " text not null, "
		    		+ COL_PASSWORD + " text not null, "
		    		+ COL_FIRSTNAME + " text, "
		    		+ COL_LASTNAME + " text, "
		    		+ COL_EMAIL + " text, "
		    		+ COL_COUNTRY + " text, "
		    		+ COL_BDAY + " text "
		    		+ ");";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists" + TABLE_NAMEU);
		onCreate(db);
	}
	
	//neuen User in die tabelle
	public void addUser(User user){
		ContentValues values = new ContentValues();
		values.put(COL_USERNAME, user.getUsername());
		values.put(COL_PASSWORD, user.getPassword());
		values.put(COL_FIRSTNAME, user.getFirstName());
		values.put(COL_LASTNAME, user.getLastName());
		values.put(COL_EMAIL, user.getEmail());
		values.put(COL_COUNTRY, user.getCountry());
		values.put(COL_BDAY, user.getBDay());
		
		SQLiteDatabase db = getWritableDatabase();
		db.insert(TABLE_NAMEU, null, values);
		db.close();
	}
	
	//delete a user
	
	//change a user
   
    
}
