package com.example.multitasking.tasks;

public class Task {
	private String name;
	private boolean complete;
	private long id;
	public Task(String taskname){
		name=taskname;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}

	public boolean isComplete() {
		
		return complete;
	}
	
	

	public void toggleComplete() {
		// TODO Auto-generated method stub
		complete=!complete;
	}

	
	
	public long getId(){
		return id;
	}


	public void setComplete(boolean complete) {
		this.complete=complete;
		
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id=id;
		
	}

	
	
	
	
	

}
