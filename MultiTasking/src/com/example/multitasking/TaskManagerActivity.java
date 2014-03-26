package com.example.multitasking;

import android.app.Activity;

public class TaskManagerActivity extends Activity {

	protected MultiTaskingApplication getTaskManagerApplication() {
		// TODO Auto-generated method stub
		MultiTaskingApplication m1=(MultiTaskingApplication)getApplication();
		return m1;
	}

}
