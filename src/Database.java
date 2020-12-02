import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Database {
    private ArrayList<UserAccount> users;
    private ArrayList<Task> tasks;
    private ArrayList<Subject> subjects;

    public Database() {
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.subjects = new ArrayList<>();

        readFile("users.txt",users);
        readFile("categories.txt",subjects);
        readFile(".txt",tasks);



    }

    public void readFile(String fileName,ArrayList<?> list) {

    }

    public void writeToFile() {

    }

    public void removeFromFile() {

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<UserAccount> getUsers() {
        return users;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
