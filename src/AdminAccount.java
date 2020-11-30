import jdk.jfr.Category;

import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class AdminAccount extends Account {

    private ArrayList<UserAccount> users;
    private ArrayList<Category> categories;

    public AdminAccount(int id, String username, String pass) {
        super(id, username, pass, 0);
    }

    public void removeUserAccount(String username) {
        users.removeIf(u -> u.getUsername().equals(username));
    }

    public void createCategory(String categoryName) {
        categories.add(new Category(categoryName));
    }



}
