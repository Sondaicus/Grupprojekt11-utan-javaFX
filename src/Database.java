import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Database {
    private ArrayList<UserAccount> users;
    private ArrayList<Category> categories;
    private ArrayList<Task> tasks;

    public Database() {
        this.users = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.tasks = new ArrayList<>();

        readFile("users.txt",users);
        readFile("categories.txt",categories);
        readFile(".txt",tasks);



    }

    public void readFile(String fileName,ArrayList<UserAccount> list) {

    }

    public void readFile(String fileName,ArrayList<Category> list) {

    }

    public void readFile(String fileName,ArrayList<Task> list) {

    }

    public void writeToFile() {

    }

    public void removeFromFile() {

    }

}
