package com.example.multitasking;

import com.example.multitasking.tasks.Task;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToList extends TaskManagerActivity{

	private EditText taskNameEditText;
	private Button addButton;
	private Button cancelButton;
	protected boolean changesPending;
	private AlertDialog unsavedChangesDialog;
	private String taskName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adding_tasks);
		setViews();
	}

	private void setViews() {
		// TODO Auto-generated method stub
		taskNameEditText =(EditText)findViewById(R.id.task_name);
		addButton = (Button)findViewById(R.id.add_button);
		cancelButton = (Button)findViewById(R.id.cancel_button);
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				addTask();
			}
		});
		
		cancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				 cancel();
			}
		});
		
		taskNameEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				
				changesPending=true;
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				
				
			}
		});
	}

	protected void addTask() {
		
		taskName = taskNameEditText.getText().toString();
		Task t=new Task(taskName);
		getTaskManagerApplication().addTask(t);
		finish();
	}

	protected void cancel() {
		if(changesPending && !taskName.equals(" ")){
		unsavedChangesDialog =new AlertDialog.Builder(this)
		.setTitle(R.string.unsaved_changes_title)
		.setMessage(R.string.unsaved_changes_message)
		.setPositiveButton(R.string.add_task,new AlertDialog.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				addTask();
			}
		})
		.setNeutralButton(R.string.discard,new AlertDialog.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				finish();
			}
		})
		.setNegativeButton(R.string.cancel,new AlertDialog.OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				unsavedChangesDialog.cancel();
			}
		})
		.create();
		unsavedChangesDialog.show();
		
		}
		else
			finish();
	}

}
