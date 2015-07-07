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
		Log.d("nhanh", "constructor");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("nhanh", "DBHandler.onCreate");
		db.execSQL(UserDBHandler.CREATE_USER_TABLE);
		db.execSQL(ThreadDBHandler.CREATE_THREAD_TABLE);
		db.execSQL(CommentDBHandler.CREATE_COMMENT_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("nhanh", "DBHandler.onUpgrade");
		db.execSQL("DROP TABLE IF EXISTS " + UserDBHandler.TABLE_NAMEU);
		db.execSQL("DROP TABLE IF EXISTS " + ThreadDBHandler.TABLE_NAMET);
		db.execSQL("DROP TABLE IF EXISTS " + CommentDBHandler.TABLE_NAMEC);

		onCreate(db);
	}
}
