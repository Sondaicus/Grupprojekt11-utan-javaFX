import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class AdminAccount extends Account {
    private ArrayList<Account> users;
    public AdminAccount(String username, String password,ArrayList<Account> users) {
        super(username, password, 0);
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
                break;
            }
        }
    }



    public void printUsers() {
        System.out.println("--------------");
        for (Account user : users) {
            System.out.println(user);
        }
        System.out.println("--------------");

    }
 /*

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
