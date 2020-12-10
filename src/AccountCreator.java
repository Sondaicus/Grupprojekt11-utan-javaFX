import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Erling
 * Date: 2020-12-04
 * Copyright: MIT
 * Class: Java20B
 */
public class AccountCreator {

    public static AdminAccount createAdmin(String username, String pass,ArrayList<Account> users) {


            return new AdminAccount(username,pass,users);
    }

    public static UserAccount createUser(String username, String pass) {

            return new UserAccount(username,pass);

    }

    public static Account createAccount(String username, String pass,ArrayList<Account> users,ArrayList <Task>
            tasks, String accType) {

        if (accType.equalsIgnoreCase("admin")) {

            return new AdminAccount(username,pass,users);
        }

        if (accType.equalsIgnoreCase("user")) {
            return new UserAccount(username,pass);
        }

        return null;
    }
}
