import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String användarnamn = null;
        String lösenord = null;
        String kontoTyp = null;


        while (true) {
            System.out.println("Vill du logga in skriv 1" + "\n" + "vill du skapa konto skriv 2");
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
                System.out.println("För vanlig användare skriv 1" + "\n" + "För admin skriv 2");
                kontoTyp = sc.next();

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