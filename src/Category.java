import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Category {
    private String categoryName;
    private ArrayList<Task> tasks;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public void createTask(String taskName, String desc) {
        tasks.add(new Task(taskName,desc, categoryName));

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


}
