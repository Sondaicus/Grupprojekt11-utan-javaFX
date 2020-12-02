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
    private Database d;


    public Account(int id, String username,String pass,int accountType) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.accountType = accountType;
        this.d = new Database();
    }

    public String getUsername() {
        return username;
    }

    public Database getDatabase() {
        return d;
    }
}
