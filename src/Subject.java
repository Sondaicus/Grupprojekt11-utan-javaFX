import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Subject {
    private String subjectName;
    private ArrayList<Task> tasks;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.tasks = new ArrayList<>();;
    }

    public void createTask(String taskName,String subjectName) {
        tasks.add(new Task(taskName, subjectName));

    }

    public void removeTask(String taskName) {
        for (Task task : tasks) {
            if (taskName.equalsIgnoreCase(task.getTaskName())) {
                tasks.remove(task);
            }
        }
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
