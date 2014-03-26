package com.example.multitasking.adapter;

import java.util.ArrayList;

import com.example.multitasking.tasks.Task;
import com.example.multitasking.views.TaskListItem;
import com.example.multitasking.*;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TaskListAdapter extends BaseAdapter {
	
	private ArrayList<Task> tasks;
	private Context context;
	
	public TaskListAdapter(ArrayList<Task> tasks,Context context){
		super();
		this.tasks=tasks;
		this.context=context;
	}
	
	

	@Override
	public int getCount() {
		
		return tasks.size();
	}

	@Override
	public Task getItem(int position) {
		
		return (null==tasks)?null:tasks.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TaskListItem tli;
		if(null==convertView){
			tli=(TaskListItem)View.inflate(context, R.layout.task_list_item , null);
		}
		else{
			tli= (TaskListItem) convertView;
		}
		tli.setTask(tasks.get(position));
		return tli;
	}



	public void forceReload() {
		notifyDataSetChanged();
		
	}



	public void toggleTaskCompleteAtPoition(int position) {
		// TODO Auto-generated method stub
		Task t=tasks.get(position);
		t.toggleComplete();
		notifyDataSetChanged();
	}



	public void removeCompletedTasks() {
		ArrayList<Task> completeTasks = new ArrayList<Task>();
		for(Task task:tasks){
			if(task.isComplete()){
				completeTasks.add(task);
			}
		}
		
		tasks.removeAll(completeTasks);
		notifyDataSetChanged();
	}



}
