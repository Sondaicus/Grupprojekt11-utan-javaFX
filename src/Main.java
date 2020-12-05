import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<>();
        Subject s1 = new Subject("Hushåll");
        Subject s2 = new Subject("Underhållning");
        subjects.add(s1);
        subjects.add(s2);

        List<Account> users = new ArrayList<>();

        AccountCreator.createAdmin("Hakim","pass",subjects,users);
        //a5.printUsers();

        UserAccount a1 = new UserAccount("Hakim","pass",subjects,users);
        AdminAccount a2 = new AdminAccount("Ad","pass",subjects,users);
        UserAccount a3 = new UserAccount("Kalle","pass",subjects,users);
        AdminAccount a4 = new AdminAccount("Ad","pass",subjects,users);

        users.add(AccountCreator.createUser("Hakim","pass",subjects,users));
        users.add(AccountCreator.createAdmin("Ad","pass",subjects,users));
        users.add(AccountCreator.createUser("Kalle","pass",subjects,users));
        users.add(AccountCreator.createAdmin("Ad","pass",subjects,users));
        a4.printUsers();
        System.out.println("-");
        //a4.removeUser(5,"Hakim");
        a4.removeUser(6,"Ad");
        System.out.println("-");
        a4.printUsers();

        //a2.addSubject("Övrigt");
        //a1.setUsers(users);
        //a2.setUsers(users);
        //a2.removeUser("Hakim");

        //System.out.println(users.get(0).getUsers());
        //System.out.println(a2.getUsers());
        //System.out.println(a1.getUsers());
        Database database = new Database();
        String username;
        String password;
        int answer;
        String input;
        Scanner sc = new Scanner(System.in);



        /*while (true) {
            System.out.println("Vill du logga in eller skapa konto?");
            System.out.println("1. Logga in");
            System.out.println("2. Skapa ett konto");
            answer = sc.nextInt();
            if (answer == 1) {
                database.readFile("Files/users.txt");
                while (true) {
                    System.out.println("Ange användarnamn");
                    username = sc.next();
                    System.out.println("Ange lösenord");
                    password = sc.next();

                    for (Account u : database.getUsers()) {
                        if (u.getUsername().equals(username) && u.getPass().equals(password)) {
                            System.out.println("Välkommen " + u.getUsername());
                            String user = u.getUsername();
                            while (true) {
                                if (u.getAccountType() == 0) {
                                    System.out.println("Välja alternativ:");
                                    System.out.println("1. Ta bort ett konto");
                                    System.out.println("2. Skapa ett ämne");
                                    System.out.println("3. Se alla användare");
                                    System.out.println("4. Avsluta");
                                    answer = sc.nextInt();

                                    if (answer == 1 ) {
                                        while (true) {

                                        }


                                    } else if (answer == 2 ) {

                                    } else if (answer == 3 ) {

                                    } else if (answer == 4) {
                                        System.exit(0);
                                    } else {

                                    }


                                } else if (u.getAccountType() == 1) {
                                    System.out.println("1. Lägg till en uppgift");
                                    System.out.println("2. Ta bort en uppgift");
                                    System.out.println("3. Se alla sysslor baserat på ämne");
                                    System.out.println("4. Avsluta");
                                    answer = sc.nextInt();


                                    if (answer == 1) {

                                    } else if (answer == 2) {

                                    } else if (answer == 3) {

                                    } else if (answer == 4) {
                                        System.exit(0);
                                    } else {

                                    }

                                } else {
                                    System.out.println("Oväntat fel! Avslutar...");
                                    System.exit(1);
                                }
                            }

                        }
                    }
                    System.out.println("Fel användarnamn eller lösenord, försök igen !");
                }


            } else if (answer == 2) {
                while (true) {
                    System.out.println("Ange användarnamn");
                    username = sc.next();
                    System.out.println("Ange lösenord");
                    password = sc.next();
                    System.out.println("Typ av konto");
                    System.out.println("1. Vanlig användare");
                    System.out.println("2. Admin");
                    answer = sc.nextInt();

                    if (answer == 1) {
                    } else if (answer == 2) {

                    } else {
                        System.out.println("Fel, försök igen!");
                    }

                }

            } else {
                System.out.println("Välj mellan möjliga alternativ");

            }

        }*/


    }

}