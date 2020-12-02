import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class UserAccount extends Account {
    private ArrayList<Category> categories;

    public UserAccount(int id, String username,String pass) {
        super(id,username,pass,1);
        this.categories = new ArrayList<Category>();
    }

}
