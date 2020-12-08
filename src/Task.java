public class Task
{
	private String
		taskName ,
		description;


	
	public Task(String taskName, String desc)
	{
		setTaskName(taskName);
		setDescription(desc);
		
	}
	


	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
		
	}
	
	public void setDescription(String description)
	{
		this.description = description;
		
	}
	
	
	public String getTaskName()
	{
		return taskName;
		
	}
	
	public String getDescription()
	{
		return description;
		
	}


	@Override
	public String toString() {
		return "* " + taskName + '\n' + "Beskrivning: " + description;
	}
}