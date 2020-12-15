import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        try {
            db = new DatabaseCommunicator();
        } catch (IOException io) {
            io.printStackTrace();
        }
        UI(sc);

    }

    private static void UI(Scanner sc) {
        String[][] list = db.getAllUsers();
        for (int i = 0; i < list.length;i++) {
            String userName = list[i][0];
            String password = list[i][1];
            String accountType = list[i][2];
            int accType = Integer.valueOf(accountType);
            if (accType == 0) {
                AdminAccount oldAdmin = AccountCreator.createAdmin(userName,password,users);
                users.add(oldAdmin);
            } else if (accType == 1) {
                UserAccount oldUser = AccountCreator.createUser(userName,password);
                users.add(oldUser);
            } else {
                System.out.println("Fel");
            }
        }
        while (true) {
            System.out.println("Välj mellan följande alternativ");
            System.out.println("1. Logga in" + "\n" // välj
                    + "2. Skapa konto");
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
                System.out.println("1. Vanlig Användare" + "\n" // vanligt eller admin
                        + "2. Admin");
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
            boolean isSuccessful = db.createUser(a, l, 1);


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
            boolean isSuccessful = db.createUser(a, l, 0);


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

            System.out.println("1. Lägg till uppgift" + "\n"
                    + "2. Ta bort uppgift" + "\n"
                    + "3. Se alla uppgifter" + "\n"
                    + "4. Logga ut");
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
                    db.addTaskToUser(user.getUsername(), taskName, desc);
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
                    + "3. Logga ut");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) {

                System.out.println("Ange användarnamn: ");
                String userName = sc.next();
                try {


                    boolean[] isTrue = db.removeUser(userName);
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

                int loginUser = users.get(i).getAccountType();

                if (loginUser == 0) {
                    admin = (AdminAccount) users.get(i);
                } else if (loginUser == 1) {
                    user = (UserAccount) users.get(i);
                    addTasksFromFile(users.get(i).getUsername());
                    user.setTasks(tasks);
                }


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

            if (getUserFile.get(1) instanceof String[][]) {
                String[][] list = (String[][]) getUserFile.get(1);
                tasks.clear();
                for (int i = 0; i < list.length; i++) {
                    String taskName = Arrays.toString(new String[]{list[i][0]});
                    String desc = Arrays.toString(new String[]{list[i][1]});
                    taskName = taskName.substring(1, taskName.length() - 1);
                    desc = desc.substring(1, desc.length() - 1);
                    tasks.add(new Task(taskName, desc));
                }


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
