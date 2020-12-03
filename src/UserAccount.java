import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public class UserAccount extends Account {
    private ArrayList<Subject> subjects;

    public UserAccount(String username,String pass, int accType) {
        super(username,pass,accType);
        //this.subjects = getDatabase().getSubjects();
    }

    @Override
    public String toString() {
        return  super.getUsername() + "," + super.getPass() + "," + super.getAccountType();
    }
}
