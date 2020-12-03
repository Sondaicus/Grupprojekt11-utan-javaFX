import java.io.*;
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
        subjects = new ArrayList<>();

            //readFile("Files/users.txt");
            //readFile("Files/subjects.txt");
            //readFile("Files/Erik.txt");
            //writeToFile("Files/users.txt");
           // writeToFile("Files/subjects.txt");
            //writeToFile("Files/Erik.txt");


        //readFile(".txt",subjects);
        //readFile(".txt",tasks);



    }

    public void readFile(String fileName) {
        try {
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
            } else if (fileName.contains("subjects.txt")) { //***
                String parts[] = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    subjects.add(new Subject(parts[i]));
                }

            } else {
                String parts[] = line.split(",");
                for (Subject subject : subjects) {

                    if (subject.toString().equalsIgnoreCase(parts[1])) {
                        subject.createTask(parts[0],parts[1]);
                    }
                }
            }
        }
        } catch (IOException io) {
            io.printStackTrace();
        }

        //users.forEach(u -> System.out.println(u + " 1"));

        /*for (Subject s : subjects) {
            System.out.println(s);
            System.out.println("----------");
            s.printTasks();
            System.out.println("----------");
        }*/




    }

    public void writeToFile(String fileName) {
        try {
            //PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
            FileWriter fileWriter = new FileWriter(fileName, true);


        if (fileName.contains("users.txt")) {

            fileWriter.write(users.get(users.size()-1) + "\n");
            fileWriter.close();

        } else if (fileName.contains("subjects.txt")) { /**/

                fileWriter.write(subjects.get(subjects.size()-1) + "\n");
                fileWriter.close();

        } else {
            //tasks
            for (Subject subject : subjects) {
                for (Task task : subject.getTasks()) {
                    fileWriter.write(task + "\n");
                }

            }
            fileWriter.close();
        }
        } catch (IOException io) {
            io.printStackTrace();
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

    public void printUsers(String user) {
        int i = 0;
        for (Account a : users) {
            if (!user.equals(a.getUsername())) {
                System.out.println(i + " " + a);
                i++;
            }
        }
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
