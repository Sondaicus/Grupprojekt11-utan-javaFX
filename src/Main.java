import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String användarnamn;
        String lösenord;
        String kontoTyp;
        AdminAccount admin;
        UserAccount user;




        while (true) {

            System.out.println("1. logga in" + "\n"
                    + "2. skapa konto");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("1")) {
                System.out.println("Ange användarnam.");
                användarnamn = sc.next();
                System.out.println("Ange lösenord.");
                lösenord = sc.next();
                break;
            } else if (answer.equalsIgnoreCase("2")) {
                System.out.println("Ange användarnam.");
                användarnamn = sc.next();
                System.out.println("Ange lösenord.");
                lösenord = sc.next();
                System.out.println("1. vanlig användare" + "\n"
                        + "2. admin");
                kontoTyp = sc.next();

                AccountCreator.

                if (kontoTyp.equalsIgnoreCase("1")) {
                    kontoTyp = "user";
                    System.out.println("1. lägg till uppgift" + "\n"
                            + "2. ta bort uppgift" + "\n"
                            + "3. se alla uppgifter" + "\n"
                            + "4. logga ut");
                } else if (kontoTyp.equalsIgnoreCase("2")) {
                    kontoTyp = "admin";
                    System.out.println("1. Ta bort ett konto" + "\n"
                            + "2. Se alla användare" + "\n"
                            + "3. logga ut");
                }
                break;
            }
        }

    }

}