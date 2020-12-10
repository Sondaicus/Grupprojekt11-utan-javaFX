import java.util.Scanner;

/**
 * Created by Max Erling
 * Date: 2020-12-10
 * Copyright: MIT
 * Class: Java20B
 */
public class UserInterface {
    private Scanner sc;
    public UserInterface(Scanner sc) {
        this.sc = sc;
    }


    public void start() {
        while (true) {
            System.out.println("Vill du logga in eller skapa konto?");
            System.out.println("1. Logga in");
            System.out.println("2. Skapa ett konto");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) {
                login();
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

        if (answer.equalsIgnoreCase("1")) {
            login();
        } else if (answer.equalsIgnoreCase("2")) {
            createAccount();
        } else {
            System.out.println("Felaktig inmatning");
        }
    }

    public Account login() {
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

    public void createAccount() {

    }

    public void userOptions() {

    }

    public void adminOptions() {

    }




}
