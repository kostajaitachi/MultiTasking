package com.example.multitasking;

//import java.util.ArrayList;

import com.example.multitasking.adapter.TaskListAdapter;
//import com.example.multitasking.tasks.Task;

import android.os.Bundle;
//import android.app.Application;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
//import android.widget.TextView;

public class TasksView extends ListActivity {

	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapter.forceReload();
		//showTasks();
	}
	private Button addButton;
	//private TextView task_list;
	private MultiTaskingApplication app;
	private TaskListAdapter adapter;
	private Button remove;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tasks_view);
		setViews();
		app = (MultiTaskingApplication)getApplication();
		adapter = new TaskListAdapter(app.getCurrentTasks(),this);
		setListAdapter(adapter);
		
		
	}

	private void setViews() {
		// TODO Auto-generated method stub
		addButton=(Button)findViewById(R.id.add_button);
		remove = (Button)findViewById(R.id.remove_button);
		//task_list=(TextView)findViewById(R.id.add_task_list);
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(TasksView.this,AddToList.class);
				startActivity(intent);
			}
		});
		
		remove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				removeCompletedTasks();
				
			}
		});
	}
	
	protected void removeCompletedTasks() {
		adapter.removeCompletedTasks();
		
	}

	/*
	private void showTasks(){
		ArrayList<Task> Tasks = getTaskManagerApplication().getCurrentTasks();
		/*to use normal bulleted list ... 
		 * StringBuffer sb=new StringBuffer();
		for(Task t:Tasks){
			sb.append(String.format("* %s\n",t.toString()));
		}
		task_list.setText(sb.toString());
		
	}*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tasks_view, menu);
		return true;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		adapter.toggleTaskCompleteAtPoition(position);
		
	}

}
