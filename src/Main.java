import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Database database = new Database();
        String username;
        String password;
        int answer;
        String input;
        Scanner sc = new Scanner(System.in);

        while (true) {
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
                                            database.printUsers(user);
                                            System.out.println("Q. Avsluta");
                                            System.out.println("Ange siffran på konto som du vill ta bort eller skriv q för att avsluta");
                                            input = sc.next();


                                            //if (input)
                                            //database.getUsers().remove(Integer.parseInt(input) - 1);

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
                                        System.out.println("Välj kategori: ");

                                        Scanner scanner = new Scanner(new File("Files/subjects.txt"));

                                        while (scanner.hasNextLine()) {
                                            System.out.println(scanner.nextLine());
                                        }
                                        input = sc.nextLine();
                                        if (input.equals(1)) {
                                            System.out.println("Hello");
                                        }

                                    } else if (answer == 2) {


                                    } else if (answer == 3) {

                                        File file= new File("/Users/rakib/IdeaProjects/Grupprojekt11-utan-javaFX/Files/Erik.txt");
                                        BufferedReader br = new BufferedReader(new FileReader(file));
                                        if (database.getUsers().equals("Erik")) {
                                            String st;
                                            while ((st = br.readLine()) != null)
                                                System.out.println(st);

                                        }


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
                        database.getUsers().add(new UserAccount(username, password, answer));
                        //System.out.println(database.getUsers());
                        database.writeToFile("Files/users.txt");
                        break;
                    } else if (answer == 2) {
                        database.getUsers().add(new AdminAccount(username, password, answer));
                        database.writeToFile("Files/users.txt");
                        break;
                    } else {
                        System.out.println("Fel, försök igen!");
                    }

                }

            } else {
                System.out.println("Välj mellan möjliga alternativ");
            }

        }


    }

}