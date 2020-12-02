import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class Database {
    private ArrayList<Account> users;
    private ArrayList<Task> tasks;
    private ArrayList<Subject> subjects;

    public Database() {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
        subjects = new ArrayList<>();

        try {
            readFile("Files/users.txt");
        } catch (IOException io) {
            System.out.println("IOException");
            io.printStackTrace();
        }

        //readFile("categories.txt",subjects);
        //readFile(".txt",tasks);



    }

    public void readFile(String fileName) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        while (((line = bufferedReader.readLine()) != null)) {

            if (fileName.contains("users.txt")) {

                String parts[] = line.split(",");
                //int id = Integer.parseInt(parts[0]);
                String username = parts[0];
                String pass = parts[1];
                int accType = Integer.parseInt(parts[2]);

                if (accType == 1) {
                    users.add(new UserAccount(username,pass,accType));
                } else if (accType == 0) {
                    users.add(new AdminAccount(username,pass,accType));
                }
            }




        }

        users.forEach(u -> System.out.println(u));


    }

    public void writeToFile() {
        //users.add(new UserAccount())
        for (Account user : users) {

        }

    }

    public void removeFromFile() {

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Account> getUsers() {
        return users;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
