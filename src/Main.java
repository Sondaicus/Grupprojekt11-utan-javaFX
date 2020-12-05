import java.util.ArrayList;
import java.util.InputMismatchException;
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
        users.add(new UserAccount("p","p",subjects,users));
        users.add(new AdminAccount("q","q",subjects,users));
        //a5.printUsers();

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
        int answer = 0;
        int alt = 0;
        int id = 0;
        String input;
        Scanner sc = new Scanner(System.in);
        AdminAccount activeAdmin = null;
        UserAccount activeUser = null;

        while (true) {

            System.out.println("Vill du logga in eller skapa ett konto?");
            System.out.println("1. Logga in");
            System.out.println("2. Skapa ett konto");

            try {
                answer = sc.nextInt();
            } catch (InputMismatchException in) {
                sc.next();
            }
                switch (answer) {
                    case 1:
                        System.out.println("Ange användarnamn");
                        username = sc.next();
                        System.out.println("Ange lösenord");
                        password = sc.next();

                        for (Account user : users) {
                            if (user.auth(username,password)) {
                                System.out.println("Inloggning lyckades");
                                if (user.getAccountType() == 0) {
                                    activeAdmin = (AdminAccount) user;
                                    activeAdmin.setActive(true);
                                    System.out.println("Välkommen " + activeAdmin.getUsername());
                                    break;
                                } else if (user.getAccountType() == 1) {
                                    activeUser = (UserAccount) user;
                                    activeUser.setActive(true);
                                    System.out.println("Välkommen " + activeUser.getUsername());
                                    break;
                                }
                            }
                        }



                        while (activeAdmin.isActive()) {
                                System.out.println("Välja alternativ:");
                                System.out.println("1. Ta bort ett konto");
                                System.out.println("2. Skapa ett ämne");
                                System.out.println("3. Se alla användare");
                                System.out.println("4. Logga ut");

                                try {
                                    alt = sc.nextInt();
                                } catch (InputMismatchException in) {
                                    sc.next();
                                }

                                if (alt == 1) {
                                    activeAdmin.printUsers();
                                    System.out.println("Vad för id?");
                                    try {
                                        id = sc.nextInt();
                                    } catch (InputMismatchException in) {
                                        sc.next();
                                    }
                                    System.out.println("Vad för användarnamn?");
                                    username = sc.next();
                                    activeAdmin.removeUser(id,username);


                                } else if (alt == 2) {
                                    System.out.println("Vilket ämne vill du lägga till?");
                                    input = sc.next();
                                    activeAdmin.addSubject(input);
                                } else if (alt == 3) {
                                    activeAdmin.printUsers();
                                } else if (alt == 4) {
                                    System.out.println("Loggar ut..");
                                    activeAdmin.setActive(false);
                                    break;

                                } else {
                                    System.out.println("Felaktig inmatning");
                                }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.println("Ange användarnamn");
                            username = sc.next();
                            System.out.println("Ange lösenord");
                            password = sc.next();
                            System.out.println("Typ av konto");
                            System.out.println("1. Vanlig användare");
                            System.out.println("2. Admin");

                            try {
                                 alt = sc.nextInt();
                            } catch (InputMismatchException in) {
                                sc.next();
                            }

                            if (alt == 1) {
                                Account adm = AccountCreator.createUser(username,password,subjects,users);
                                System.out.println("Användarkonto " + username + " skapat");
                                users.add(adm);
                                break;
                            } else if (alt == 2) {
                                Account user = AccountCreator.createAdmin(username,password,subjects,users);
                                System.out.println("Användarkonto " + username + " skapat");
                                users.add(user);
                                break;
                            } else {
                                System.out.println("Fel, försök igen!");
                            }
                        }
                        break;


                    default:
                        System.out.println("Välj mellan alternativen!");
                        break;
                }


        }



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



    public void createOrLoginPrompt() {
        System.out.println("Vill du logga in eller skapa konto?");
        System.out.println("1. Logga in");
        System.out.println("2. Skapa ett konto");


    }

}