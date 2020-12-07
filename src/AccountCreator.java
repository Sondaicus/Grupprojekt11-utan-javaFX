import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Erling
 * Date: 2020-12-04
 * Copyright: MIT
 * Class: Java20B
 */
public class AccountCreator {

    public static AdminAccount createAdmin(String username, String pass, ArrayList<Account> users) {


        if (!(username == null && pass == null && subjects == null)) {
            return new AdminAccount(username,pass,users);
        }

        return  null;
    }

    public static UserAccount createUser(String username, String pass, List<Subject> subjects,ArrayList<Account> users) {


         if (!(username == null && pass == null && subjects == null)) {
            return new UserAccount(username,pass);
        }

        return  null;
    }
}
