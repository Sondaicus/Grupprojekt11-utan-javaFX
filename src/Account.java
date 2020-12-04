import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
abstract class Account {
     private String username;
     private String pass;
     private int accountType;
     private List<Subject> subjects;
     private List<Account> users;

     public Account(String username, String pass, int accType, List<Subject> subjects, List<Account> users) {
          this.username = username;
          this.pass = pass;
          this.accountType = accType;
          this.subjects = subjects;
          this.users = users;
     }

     public String getUsername() {
          return username;
     }

     public String getPass() {
          return pass;
     }

     public int getAccountType() {
          return accountType;
     }

     public List<Subject> getSubjects() {
          return subjects;
     }

     public List<Account> getUsers() {
          return users;
     }


     public abstract boolean auth(String user, String pass);

}
