import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String användarnamn;
    private static String lösenord;
    private static String kontoTyp;
    private static AdminAccount admin;
    private static UserAccount user;
    private static ArrayList<Account> users = new ArrayList<>();
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static DatabaseCommunicator db;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        users.add(new UserAccount("x","x"));
        try {
            db = new DatabaseCommunicator();
        } catch (IOException io) {
            io.printStackTrace();
        }
        UI(sc);










    }

    private static void UI(Scanner sc) {
        while (true) {
            System.out.println("1. logga in" + "\n" // välj
                    + "2. skapa konto");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) { // logga in
                setInfo(sc);
                int userType = logInValidator(användarnamn, lösenord);
                if (userType == 1) {

                    omUser(sc);
                } else if (userType == 0) {
                    ifAdmin(sc);
                }
            } else if (answer.equalsIgnoreCase("2")) { // skapa konto
                setInfo(sc);
                System.out.println("1. vanlig användare" + "\n" // vanligt eller admin
                        + "2. admin");
                kontoTyp = sc.next(); // sätter kontotyp

                if (kontoTyp.equalsIgnoreCase("1")) {
                    createUser(användarnamn, lösenord);

                } else if (kontoTyp.equalsIgnoreCase("2")) {
                    createAdmin(användarnamn, lösenord, users);
                }
            }
        }
    }

    private static void createUser(String a, String l) {
        user = AccountCreator.createUser(a, l);
        try {
            boolean isSuccessful = db.createUser(a,l);


        if (isSuccessful) {
            users.add(user);
        } else {
            System.out.println("Användarnamn finns redan");
        }

        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    private static void createAdmin(String a, String l, ArrayList<Account> users) {
        admin = AccountCreator.createAdmin(a, l, users);
        try {
            boolean isSuccessful = db.createUser(a,l);


            if (isSuccessful) {
                users.add(admin);
            } else {
                System.out.println("Användarnamn finns redan");
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void omUser(Scanner sc) {
        while (true) {

        System.out.println("1. lägg till uppgift" + "\n"
                + "2. ta bort uppgift" + "\n"
                + "3. se alla uppgifter" + "\n"
                + "4. logga ut");
        String answer = sc.next();
        //String taskName;
        if (answer.equalsIgnoreCase("1")) {
            try {
            System.out.println("Skriv uppgiftsnamn");
            String taskName = sc.next();
            System.out.println("Skriv beskrivning");
            sc.nextLine();
            String desc = sc.nextLine();
            user.createTask(taskName, desc);
            db.addTaskToUser(user.getUsername(),taskName,desc);
            } catch (IOException io) {
                io.printStackTrace();
            }

            System.out.println("Uppgift tillagd!");
        } else if (answer.equals("2")) {
            System.out.println("Ange namn på upggiften");
            String taskName = sc.next();
            user.removeTask(taskName);
        } else if (answer.equals("3")) {
            user.printTasks();
        } else if (answer.equals("4")) {
            System.out.println("Loggar ut...");
            break;
        } else {
            System.out.println("Felaktig inmatning!");
        }
        }

    }

    private static void ifAdmin(Scanner sc) {

        while (true) {

            System.out.println("1. Ta bort ett konto" + "\n"
                    + "2. Se alla användare" + "\n"
                    + "3. logga ut");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) {

                System.out.println("Ange användarnamn: ");
                String userName = sc.next();
                try {


                    boolean[] isTrue = db.removeUser(userName);
                    System.out.println(isTrue[1]);
                    if (!isTrue[1]) {
                        admin.removeAccount(userName);
                    } else {
                        System.out.println("Fel uppstod");
                    }
                } catch (IOException io) {
                    io.printStackTrace();
                }

            } else if (answer.equals("2")) {

                admin.printUsers();

            } else if (answer.equals("3")) {

                System.out.println("Loggar ut...");
                break;

            } else {
                System.out.println("Felaktig inmatning!");
            }

        }
    }

    private static int logInValidator(String namn, String pass) {
        boolean finns = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(namn) && users.get(i).getPassword().equalsIgnoreCase(pass)) {
                finns = true;
                addTasksFromFile(users.get(i).getUsername());
                user = (UserAccount) users.get(i);
                user.setTasks(tasks);


                System.out.println("Välkommen " + namn + "!");
                return users.get(i).getAccountType();
            }
        }
        if (!finns) {
            System.out.println("Använadre finns inte!");
            return 2; // om user är ogiltig
        }
        return 0;
    }

    public static void addTasksFromFile(String username) {
        try {
            ArrayList<Object> getUserFile = db.getUserFile(username);
            String str = (String) getUserFile.get(1);
            String[] parts = str.split("_");
            for (int j = 0; j < parts.length - 1; j += 2) {
                tasks.add(new Task(parts[j], parts[j+1]));
                System.out.println(parts[j] + "j");
                System.out.println(parts[j+1] + " j+1");

            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void setInfo(Scanner sc) {
        System.out.println("Ange användarnam.");
        användarnamn = sc.next();
        System.out.println("Ange lösenord.");
        lösenord = sc.next();
    }

}
