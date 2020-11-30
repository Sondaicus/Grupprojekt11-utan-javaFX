/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Task {
    private String taskName;
    private String description;
    private Category category; //***


    public Task(String taskName,String description, Category category) {
        this.taskName = taskName;
        this.description = description;
        this.category = category;
    }
}
