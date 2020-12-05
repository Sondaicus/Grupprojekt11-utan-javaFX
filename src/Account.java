import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
     private static AtomicInteger uniqueId = new AtomicInteger();
     private int id;
     private boolean active;

     public Account(String username, String pass, int accType, List<Subject> subjects, List<Account> users) {
          this.username = username;
          this.pass = pass;
          this.accountType = accType;
          this.subjects = subjects;
          this.users = users;
          this.id= uniqueId.getAndIncrement();
          this.active = false;
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

     public int getId() {
          return id;
     }

     public void setActive(boolean active) {
          this.active = active;
     }

     public boolean isActive() {
          return active;
     }

     public abstract boolean auth(String user, String pass);

}
