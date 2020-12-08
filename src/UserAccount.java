import java.util.*;

public class UserAccount extends Account
{


	public UserAccount(String username, String password,ArrayList <Subject>
			subjects)
	{
		super(username, password, 1,subjects);
		
	}


	public void createTask(String subjectName, String taskName) {
		Subject subject = chooseSubject(subjectName);

		if (!(subject == null)) {
			subject.addToTasks(new Task(taskName));
		}

	}

	private Subject chooseSubject(String subjectName) {
		for (Subject subject : subjects) {
			if (subject.getSubjectName().equalsIgnoreCase(subjectName)) {
				return subject;
			}
		}

		return null;
	}
}