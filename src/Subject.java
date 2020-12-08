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

	public void addToTasks(Task task)
	{
		tasks.add(task);
	}
	
	public void removeTask(String taskName)
	{
	
	}
	
	public void printTasks()
	{
	
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return subjectName;
	}
}