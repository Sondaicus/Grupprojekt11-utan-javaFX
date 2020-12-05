import java.util.ArrayList;

public class AdminAccount extends Account
{
	public ArrayList<UserAccount>
		users;
	
	
	public AdminAccount(String username, String password, int id, int accountType)
	{
		super(username, password, id, accountType);
		
	}
	
	
	public void deleteUserAccount(UserAccount username)
	{
	
	}
	
}