import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> users = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        UserAccount u = new UserAccount("q","q",subjects);
        AdminAccount a = new AdminAccount("p","p",users,subjects);
        a.createSubject("Hushåll");
        a.createSubject("Övrigt");

        u.createTask("Hushåll","Städa");
        u.createTask("Ö","Ö");
        u.createTask("Övrigt","Äta");
        u.createTask("Hushåll","Laga mat");


    }

}