import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Max Erling
 * Date: 2020-12-10
 * Copyright: MIT
 * Class: Java20B
 */
public class UserInterface {
    private Scanner sc;
    private ArrayList<Account> users;
    public UserInterface(Scanner sc,ArrayList<Account> users) {
        this.sc = sc;
        this.users = users;
    }




    public void start() {
        while (true) {
            System.out.println("Vill du logga in eller skapa konto?");
            System.out.println("1. Logga in");
            System.out.println("2. Skapa ett konto");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) {
                login(users);
            } else if (answer.equalsIgnoreCase("2")) {
                createAccount();
            } else {
                System.out.println("Felaktig inmatning");
            }
        }
    }

    public void logInOrCreateAccount() {
        System.out.println("Vill du logga in eller skapa konto?");
        System.out.println("1. Logga in");
        System.out.println("2. Skapa ett konto");
        String answer = sc.next();

        mainMenuOptions(answer);
    }



    public void createAccount() {

    }

    public void mainMenuOptions(String answer) {
        if (answer.equalsIgnoreCase("1")) {
            login();
        } else if (answer.equalsIgnoreCase("2")) {
            createAccount();
        } else {
            System.out.println("Felaktig inmatning");
        }
    }

    public void userOptions() {

    }

    public void adminOptions() {

    }

    public Account login(ArrayList<Account> users) {
        System.out.println("Ange användarnamn:");
        String username = sc.next();
        System.out.println("Ange Lösenord:");
        String pass = sc.next();

        for (Account user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(pass)) {
                return user;
            }
        }
        System.out.println("Konto existerar inte");
        return null;
    }


}
