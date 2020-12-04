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

    public void removeUser(String username) {
        for (Account user : super.getUsers()) {
            if (!(super.getUsername().equals(username)) && user.getUsername().equals(username)) {
                super.getUsers().remove(user);
            } else {
                System.out.println("Du kan inte ta bort denna användare");
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
        return super.getUsername() + "," + super.getPass() + "," + super.getAccountType();
    }

    @Override
    public boolean auth(String user, String pass) {
        return super.getUsername().equals(user) && super.getPass().equals(pass);
    }

}
