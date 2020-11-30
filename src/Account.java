/**
 * Created by Max Erling
 * Date: 2020-11-30
 * Copyright: MIT
 * Class: Java20B
 */
public abstract class Account {
    private int id;
    private String username;
    private String pass;
    private int accountType;


    public Account(int id, String username,String pass,int accountType) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }
}
