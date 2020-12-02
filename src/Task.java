/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Task {
    private String taskName;
    private String description;
    private String subject; //***


    public Task(String taskName,String description, String subject) {
        this.taskName = taskName;
        this.description = description;
        this.subject = subject;
    }

    public String getTaskName() {
        return taskName;
    }
}
