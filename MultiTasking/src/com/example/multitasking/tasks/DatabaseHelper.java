package com.example.multitasking.tasks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME="database";
	public static final int DATABASE_VERSION=1;
	public static final String TASKS_TABLE = "tasks";
	public static final String TASK_ID = "id";
	public static final String TASK_NAME = "name";
	public static final String TASK_COMPLETE = "complete";
	
	

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createTable(db);

	}

	

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	protected void createTable(SQLiteDatabase db) {
		db.execSQL("create table" + TASKS_TABLE + " (" +"TASK_ID" + " integer primary key autoincrement," + TASK_NAME +" text," + TASK_COMPLETE + " text"+ ");");
		
	}

}
