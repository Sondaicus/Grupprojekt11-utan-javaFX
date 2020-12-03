/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Task {
    private String taskName;
    private String description;
    private String subjectName; //***


    public Task(String taskName, String subjectName) {
        this.taskName = taskName;
        this.description = description;
        this.subjectName = subjectName;
    }

    public String getTaskName() {
        return taskName;
    }


    public String toString() {
        return taskName + "," + subjectName;
    }
}
