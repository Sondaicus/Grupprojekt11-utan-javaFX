import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class AdminAccount extends Account {
    private ArrayList<Account> users;
    public AdminAccount(String username, String password,ArrayList<Account> users,ArrayList <Subject>
            subjects) {
        super(username, password, 0,subjects);
        setUsers(users);

    }

    public void setUsers(ArrayList<Account> users) {
        this.users = users;
    }

    public void removeAccount(int id, String username) {
        for (Account user : users) {
            if (user.getUsername().equals(username) && user.getId() == id) {
                users.remove(user);
                System.out.println("Användarkonto " + user.getUsername() + " borttaget!");
            }
        }
    }

    public void addSubject(String subjectName) {
        subjects.add(new Subject(subjectName));
    }

    public void printUsers() {
        System.out.println("--------------");
        for (Account user : users) {
            System.out.println(user);
        }
        System.out.println("--------------");

    }
 /*

    public AdminAccount(String username, String pass, List<Subject> subjects, List<Account> users) {
        super(username,pass,0,subjects,users);

    }

    public void removeUser(int id, String username) {
        for (Account user : super.getUsers()) {
            if ((user.getUsername().equals(username) && user.getId() == id) && !(super.getUsername().equals(username) && super.getId() == id)) {
                super.getUsers().remove(user);
                System.out.println(user.getUsername() + " borttagen");
                break;
            }

            if (super.getUsers().indexOf(user) == super.getUsers().size()-1) {
                System.out.println("Felaktig inmatning eller så används detta konto just nu!");
            }
        }

    }

    public void addSubject(String subjectName) {
        super.getSubjects().add(new Subject(subjectName));
    }


    public void printUsers() {
        System.out.println("--------------");
        for (Account user : super.getUsers()) {

            System.out.println(user);
        }
        System.out.println("--------------");
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
    }*/
}
