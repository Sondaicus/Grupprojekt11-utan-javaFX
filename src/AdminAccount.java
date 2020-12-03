import jdk.jfr.Category;

import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class AdminAccount extends Account {

    private ArrayList<Account> users;
    private ArrayList<Subject> subjects;

    public AdminAccount(String username, String pass, int accType) {
        super(username, pass, accType);
        //users = getDatabase().getUsers();
        //subjects = getDatabase().getSubjects();


    }

    public void removeUserAccount(String username) {
        users.removeIf(u -> u.getUsername().equals(username));
    }

    public void createSubject(String subjectName) {
        subjects.add(new Subject(subjectName));
    }

    @Override
    public String toString() {
        return super.getUsername() + "," + super.getPass() + "," + super.getAccountType();
    }

}
