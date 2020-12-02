/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Task {
    private String taskName;
    private String description;
    private String category; //***


    public Task(String taskName,String description, String category) {
        this.taskName = taskName;
        this.description = description;
        this.category = category;
    }

    public String getTaskName() {
        return taskName;
    }
}
