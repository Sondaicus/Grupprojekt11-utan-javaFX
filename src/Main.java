import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> users = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        UserAccount u = new UserAccount("q","q");
        AdminAccount a = new AdminAccount("p","p",users);
        u.setTasks(tasks);

        u.createTask("Handla","Handla ägg och lök");
        u.createTask("Städa","Städa rummet och köket");
        u.createTask("Film","Kolla på The Desgin Pattern");

        u.removeTask("film");

        u.printTasks();

    }

}