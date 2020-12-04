import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class UserAccount extends Account  {

    public UserAccount(String username,String pass, List<Subject> subjects, List<Account> users) {
        super(username,pass,1,subjects, users);
    }

    @Override
    public String toString() {
        return super.getUsername() + "," + super.getPass() + "," + super.getAccountType();
    }

    @Override
    public boolean auth(String user, String pass) {
        return false;
    }


}
