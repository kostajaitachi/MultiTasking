package com.example.multitasking;

import java.util.ArrayList;



import com.example.multitasking.tasks.DatabaseHelper;
import com.example.multitasking.tasks.Task;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.multitasking.tasks.DatabaseHelper.*;

public class MultiTaskingApplication extends Application {

	private ArrayList<Task> currentTasks;
	private SQLiteDatabase database;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		DatabaseHelper helper =new DatabaseHelper(this);
		database = helper.getWritableDatabase();
		if(null==currentTasks){
			currentTasks=new ArrayList<Task>();
			//loadTasks();
		}
	}
	
	private void loadTasks() {
		currentTasks = new ArrayList<Task>();
		Cursor taskCursor =database.query(TASKS_TABLE,
				new String[]{TASK_ID,TASK_NAME,TASK_COMPLETE},
				null, null, null, null, String.format("%s%s",TASK_COMPLETE,TASK_NAME) 
						);
		taskCursor.moveToFirst();
		Task t;
		if(!taskCursor.isAfterLast()){
			do{
				long id= taskCursor.getLong(0);
				String name = taskCursor.getString(1);
				String boolValue = taskCursor.getString(2);
				boolean complete = Boolean.parseBoolean(boolValue);
				t=new Task(name);
				t.setId(id);
				t.setComplete(complete);
				currentTasks.add(t);
				
				
			}while(taskCursor.moveToNext());
		
			
		}
		
		taskCursor.close();
	}

	public void setCurrentTasks(ArrayList<Task> currentTasks){
		this.currentTasks=currentTasks;
	}
	
	public ArrayList<Task> getCurrentTasks(){
		return currentTasks;
	}
	
	
	public void addTask(Task t){
		assert(null!=t);
		/*
		ContentValues values=new ContentValues();
		values.put(TASK_NAME,t.getName());
		values.put(TASK_COMPLETE, Boolean.toString(t.isComplete()));
		long id=  database.insert(TASKS_TABLE, null, values);
		t.setId(id);*/
		currentTasks.add(t);
	}

}
