import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> users = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        users.add(new UserAccount("p","p",subjects));
        users.add(new AdminAccount("q","q",users,subjects));
        AdminAccount a1 = (AdminAccount) users.get(1);


    }

}