import javax.security.auth.Subject;
import java.io.IOException;
import java.util.*;

public class UserAccount extends Account
{
	public ArrayList <Subject>
		subjects;
	
	
	public UserAccount(String username, String password, int accountType) throws IOException
	{
		super(username, password, accountType);
		
	}
	
}