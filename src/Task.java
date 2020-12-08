public class Task
{
	private String
		taskName ,
		description;
	
	private Subject
		subject;
	
	
	public Task()
	{}
	
	public Task(Subject subject)
	{
		setSubject(subject);
		
	}
	
	public Task(String taskName)
	{
		setTaskName(taskName);
		setDescription(description);
		
	}
	
	public Task(String taskName, String description, Subject subject)
	{
		setTaskName(taskName);
		setDescription(description);
		setSubject(subject);
		
	}
	
	
	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
		
	}
	
	public void setDescription(String description)
	{
		this.description = description;
		
	}
	
	public void setSubject(Subject subject)
	{
		this.subject = subject;
		
	}
	
	
	public String getTaskName()
	{
		return taskName;
		
	}
	
	public String getDescription()
	{
		return description;
		
	}
	
	public Subject getSubject()
	{
		return subject;
		
	}

	@Override
	public String toString() {
		return taskName;
	}
}