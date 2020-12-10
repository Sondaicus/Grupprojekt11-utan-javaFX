import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> users = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        UserInterface ui = new UserInterface(sc,users,tasks);
        ui.start();
    }

}