import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static String användarnamn;
    private static String lösenord;
    private static String kontoTyp;
    private static AdminAccount admin;
    private static UserAccount user;
    private static ArrayList<Account> users = new ArrayList<>();

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        UI();


    }

    private static void UI() {
        while (true) {
            System.out.println("1. logga in" + "\n" // välj
                    + "2. skapa konto");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) { // logga in
                setInfo();
                int userType = logInValidator(användarnamn, lösenord);
                if (userType == 1) {
                    omUser();
                } else if (userType == 0) {
                    omAdmin();
                } else {
                    // här om user är ogiltig
                }
                break;
            } else if (answer.equalsIgnoreCase("2")) { // skapa konto
                setInfo();
                System.out.println("1. vanlig användare" + "\n" // vanligt eller admin
                        + "2. admin");
                kontoTyp = sc.next(); // sätter kontotyp

                if (kontoTyp.equalsIgnoreCase("1")) {
                    createUser(användarnamn, lösenord);

                } else if (kontoTyp.equalsIgnoreCase("2")) {
                    createAdmin(användarnamn, lösenord, users);
                }
                //break;
                System.out.println(users);
            }
        }
    }

    private static void createUser(String a, String l) {
        user = AccountCreator.createUser(a, l);
        users.add(user);
    }

    private static void createAdmin(String a, String l, ArrayList<Account> al) {
        admin = AccountCreator.createAdmin(a, l, al);
        users.add(admin);
    }

    private static void omUser() {
        System.out.println("1. lägg till uppgift" + "\n"
                + "2. ta bort uppgift" + "\n"
                + "3. se alla uppgifter" + "\n"
                + "4. logga ut");
        //String answer = sc.next();
        //String taskName;
        String desc = "";
        if (sc.next().equalsIgnoreCase("1")) {
            System.out.println("Skriv ämne");
            String taskName = sc.next();
            System.out.println("Skriv beskrining");
            sc.nextLine();
            desc = sc.nextLine();
            user.createTask(taskName, desc);
            user.printTasks(); // testar att skriva ut
        }
    }

    private static void omAdmin() {
        System.out.println("1. Ta bort ett konto" + "\n"
                + "2. Se alla användare" + "\n"
                + "3. logga ut");
    }

    private static int logInValidator(String namn, String pass) {
        boolean finns = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(namn) && users.get(i).getPassword().equalsIgnoreCase(pass)) {
                finns = true;
                System.out.println("Välkommen " + namn);
                return users.get(i).getAccountType();
            }
        }
        if (!finns) {
            System.out.println("User finns inte");
            return 2; // om user är ogiltig
        }
        return 0;
    }

    private static void setInfo() {
        System.out.println("Ange användarnam.");
        användarnamn = sc.next();
        System.out.println("Ange lösenord.");
        lösenord = sc.next();
    }

}