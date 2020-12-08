import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UserAccount extends Account
{
	

	public UserAccount(String username, String password,ArrayList <Subject> subjects)

	{
		super(username, password, 1,subjects);
	}

	public static void printCategorizedTasks(String category, String userFile) throws IOException {

		System.out.println("--------------");

		System.out.println("Kategori: " + category);

		System.out.println("--------------");

		BufferedReader reader = new BufferedReader(new FileReader(userFile));

		String[] userList;
		String line;

		while ((line = reader.readLine()) != null) {

			userList = line.split(",");

			for (String word: userList) {

				if (word.equals(category))
					System.out.println(line.replace("," + category, ""));
			}
		}

		System.out.println("--------------");
	}

	public static void main(String[] args) throws IOException {
		printCategorizedTasks("Inköpslista", "Files/Erik.txt");
		printCategorizedTasks("Hemmasysslor", "Files/Erik.txt");
	}
	
}