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
    private ArrayList<Task> tasks;
    //private AdminAccount adminAccount;
    //private UserAccount userAccount;
    public UserInterface(Scanner sc,ArrayList<Account> users, ArrayList<Task> tasks) {
        this.sc = sc;
        this.users = users;
        this.tasks = tasks;
    }




    public void start() {
        while (true) {
            System.out.println("Vill du logga in eller skapa konto?");
            System.out.println("1. Logga in");
            System.out.println("2. Skapa ett konto");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("1")) {
                Account user = login(users);

                if (user != null && user.getAccountType() == 0) {
                    AdminAccount adminAccount = (AdminAccount) user;
                    adminOptions(adminAccount);
                } else if (user != null && user.getAccountType() == 1) {
                    UserAccount userAccount = (UserAccount) user;
                    userAccount.setTasks(tasks);
                    userOptions(userAccount);
                }

            } else if (answer.equalsIgnoreCase("2")) {
                createAccount(users);
            } else {
                System.out.println("Felaktig inmatning1");
            }
        }
    }

    public void logInOrCreateAccount() {
        System.out.println("Vill du logga in eller skapa konto?");
        System.out.println("1. Logga in");
        System.out.println("2. Skapa ett konto");
        String answer = sc.nextLine();
    }



    public void createAccount(ArrayList<Account> users) {
        while (true) {
        System.out.println("Ange användarnamn:");
        String username = sc.nextLine();
        System.out.println("Ange Lösenord:");
        String pass = sc.nextLine();
        System.out.println("Ange kontotyp:");
        System.out.println("1. Admin");
        System.out.println("2. Vanlig användare");
        String accType = sc.nextLine();

        if (accType.equals("1")) {
            users.add(AccountCreator.createAdmin(username,pass,users));
            break;
        } else if (accType.equals("2")) {
            users.add(AccountCreator.createUser(username,pass));
            break;
        } else {
            System.out.println("Felaktig inmatning");
        }
        }


    }

    public void userOptions(UserAccount userAccount) {
        while (true) {
            System.out.println("Välj en av alternativen:");
            System.out.println("1. Lägg till en uppgift");
            System.out.println("2. Ta bort en uppgift");
            System.out.println("3. Se alla uppgifter");
            System.out.println("4. Logga ut");
            String answer = sc.nextLine();
            if (answer.equals("1")) {
                System.out.println("Ange namn på upggiften:");
                String taskName = sc.nextLine();
                System.out.println("Ange beskriving på upggiften");
                String desc = sc.nextLine();
                userAccount.createTask(taskName,desc);
            } else if (answer.equals("2")) {
                System.out.println("Ange namn på upggiften:");
                String taskName = sc.nextLine();
                userAccount.removeTask(taskName);
            } else if (answer.equals("3")) {
                userAccount.printTasks();
            } else if (answer.equals("4")) {
                break;
            } else {
                System.out.println("Felaktig inmatning");
            }
        }
    }

    public void adminOptions(AdminAccount adminAccount) {

    }

    public Account login(ArrayList<Account> users) {
        System.out.println("Ange användarnamn:");
        String username = sc.nextLine();
        System.out.println("Ange lösenord:");
        String pass = sc.nextLine();

        for (Account user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(pass)) {
                System.out.println("Inloggning lyckades");
                return user;
            }
        }
        System.out.println("Konto existerar inte");
        return null;
    }


}
