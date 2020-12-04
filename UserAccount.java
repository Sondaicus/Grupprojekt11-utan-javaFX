import javax.security.auth.Subject;
import java.util.*;

public class UserAccount extends Account
{
	public ArrayList <Subject>
		subjects;
	
	
	public UserAccount()
	{}
	
	public UserAccount(String username, String password, int id, int accountType)
	{
		super(username, password, id, accountType);
		
	}
	
}