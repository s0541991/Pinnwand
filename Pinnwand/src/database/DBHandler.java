package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

	protected static final int DATABASE_VERSION = 2;
	protected static final String DATABASE_NAME = "user.db";

	/**
	 * Constructor should be private to prevent direct instantiation. make call
	 * to static method "getInstance()" instead.
	 */
	public DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d("DBHandler", "constructor");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("DBHandler", "onCreate");
		//=================Zentrale Datenbank Verbindung Versuch fehlgeschlagen============
//		Connection connect = null;
//		
//	String driver = "jdbc.mysql.jdbc.Driver";
//
//		try {
//			Class.forName(driver).newInstance();
//			String connString = "jdbc:mysql://141.45.176.41:3306/s0539895?";
//			String root = "s0539895";
//			String password = "wb59Sw88";
//
//			connect = DriverManager.getConnection(connString, root, password) ;
//
//			Log.w("nhanh", "open");
//
//			Statement createTableU = connect.createStatement();
//			ResultSet reset = createTableU
//					.executeQuery(UserDBHandler.CREATE_USER_TABLE);
//
//			connect.close();
//		} catch (Exception e) {
//			Log.w("Error nhanh", "" + e.getMessage());
//		}

		db.execSQL(UserDBHandler.CREATE_USER_TABLE);
		db.execSQL(ThreadDBHandler.CREATE_THREAD_TABLE);
		db.execSQL(CommentDBHandler.CREATE_COMMENT_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("nhanh", "DBHandler.onUpgrade");
//		db.execSQL("DROP TABLE IF EXISTS " + UserDBHandler.TABLE_NAMEU);
//		db.execSQL("DROP TABLE IF EXISTS " + ThreadDBHandler.TABLE_NAMET);
//		db.execSQL("DROP TABLE IF EXISTS " + CommentDBHandler.TABLE_NAMEC);

		onCreate(db);
	}
}
