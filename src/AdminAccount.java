import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class AdminAccount extends Account {



    public AdminAccount(String username, String pass, List<Subject> subjects, List<Account> users) {
        super(username,pass,0,subjects,users);

    }

    public void removeUser(int id, String username) {
        for (Account user : super.getUsers()) {
            if (!(super.getUsername().equals(username)) && user.getUsername().equals(username) && user.getId() == id) {
                super.getUsers().remove(user);
                break;
            } else {
                System.out.println("Du kan inte ta bort denna användare");
                break;
            }
        }

    }

    public void addSubject(String subjectName) {
        super.getSubjects().add(new Subject(subjectName));
    }


    public void printUsers() {
        for (Account user : super.getUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + " " + "Username: " + super.getUsername() + " [Admin]";
    }

    @Override
    public boolean auth(String user, String pass) {
        return super.getUsername().equals(user) && super.getPass().equals(pass);
    }

}
