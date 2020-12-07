import java.util.*;

public class Subject
{
	private String
		subjectName;
	
	private ArrayList<Task>
		tasks;
	
	public Subject(String subjectName)
	{
		tasks = new ArrayList<Task>();
		setSubjectName(subjectName);
	}
	
	public void createTask(String taskName, String description)
	{
	
	}
	
	public void removeTask(String taskName)
	{
	
	}
	
	public void printTasks()
	{
	
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}