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

            if ((user.getUsername().equals(username) && user.getId() == id) && !(super.getUsername().equals(username) && super.getId() == id)) {
                super.getUsers().remove(user);
                System.out.println(user.getUsername() + " borttagen");
                break;
            } else {
                System.out.println("Felaktig inmatning eller så används detta konto just nu!");
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
        return "ID:" + super.getId() + " " + super.getUsername() + " [Admin]";
    }

    @Override
    public boolean auth(String user, String pass) {
        return super.getUsername().equals(user) && super.getPass().equals(pass);
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
    }
}
