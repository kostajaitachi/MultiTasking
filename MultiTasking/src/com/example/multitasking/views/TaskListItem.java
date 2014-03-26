package com.example.multitasking.views;

import com.example.multitasking.tasks.Task;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

public class TaskListItem extends LinearLayout {
	
	private Task task;
	private CheckedTextView checkbox;
	@SuppressWarnings("unused")
	private boolean complete;
	

	public TaskListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		
	}
	
	public void setTask(Task task){
		this.task=task;
		checkbox.setText(task.getName());
		checkbox.setChecked(task.isComplete());
	}
	
	public Task getTask(){
		return task;
		}
	
	public void setComplete(boolean complete){
		//complete = !complete;
		this.complete=complete;
	}
	
	protected void onFinishInflate(){
		super.onFinishInflate();
		checkbox=(CheckedTextView)findViewById(android.R.id.text1);
	}

}
