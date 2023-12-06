package Admin_Task_Management_System;


/*
 A Task Management System is a software application or tool designed to help individuals,
  teams, or organizations organize, track, and manage tasks and activities efficiently.
  It provides a structured way to create, assign, prioritize, and monitor tasks 
  to ensure that work is completed in a timely and organized manner. 
  Task Management Systems are widely used in various contexts, including personal productivity,
   project management, and team collaboration.
 */

public class Task {
	
	
	private int taskId;
    private String taskName;
    private String description;
    private String status;
    
    public Task()
    {
    	
    }
    
	public int getTaskId() 
	{
		return taskId;
	}
	
	public void setTaskId(int taskId) 
	{
		this.taskId = taskId;
	}
	
	public String getTaskName() 
	{
		return taskName;
	}
	
	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public Task(int taskId, String taskName, String description, String status) 
	{
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.status = status;
	}

	
	@Override
	public String toString() 
	{
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", status="
				+ status + "]";
	}

   

}
