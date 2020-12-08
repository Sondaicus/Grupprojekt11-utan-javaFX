import java.util.*;

public class UserAccount extends Account
{
	private ArrayList<Task> tasks;

	public UserAccount(String username, String password)
	{
		super(username, password, 1);


		
	}

	public void createTask(String taskName, String desc) {
		tasks.add(new Task(taskName,desc));
	}

	public void removeTask(String taskName) {
		for (Task task: tasks) {
			if (task.getTaskName().equalsIgnoreCase(taskName)) {
				tasks.remove(task);
				System.out.println("Uppgift borttaget!");
				break;
			}
		}
	}

	public void printTasks() {
		for (Task task : tasks) {
			System.out.println(task);
		}
	}


	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
}