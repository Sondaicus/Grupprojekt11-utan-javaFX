import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Erling
 * Date: 2020-12-04
 * Copyright: MIT
 * Class: Java20B
 */
public class AccountCreator {

    public static AdminAccount createAdmin(String username, String pass,ArrayList<Account> users,ArrayList <Subject> subjects) {


            return new AdminAccount(username,pass,users,subjects);
    }

    public static UserAccount createUser(String username, String pass,ArrayList <Subject>
            subjects) {

            return new UserAccount(username,pass,subjects);

    }

    public static Account createAccount(String username, String pass,ArrayList<Account> users,ArrayList <Subject> subjects, String accType) {

        if (accType.equalsIgnoreCase("admin")) {

            return new AdminAccount(username,pass,users,subjects);
        }

        if (accType.equalsIgnoreCase("user")) {
            return new UserAccount(username,pass,subjects);
        }

        return null;
    }
}
