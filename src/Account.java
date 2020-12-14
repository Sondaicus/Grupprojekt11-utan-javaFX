import java.io.IOException;
import java.util.*;

public abstract class Account
{
	private String
		username ,
		password;
	
	private int
		id ,
		accountType;
	
	public Account(String username, String password, int accountType)
	{
		
		setUsername(username);
		setPassword(password);
		setAccountType(accountType);
		/*try {
			//setId();
		} catch (IOException io) {
			io.printStackTrace();
		}*/

		
	}
	
	public void setUsername(String username)
	{
		this.username = username;
		
	}
	
	public void setPassword(String password)
	{
		this.password = password;
		
	}
	
	public void setAccountType(int accountType)
	{
		this.accountType = accountType;
		
	}
	
	
	public String getUsername()
	{
		return username;
		
	}
	
	public String getPassword()
	{
		return password;
		
	}
	
	public int getAccountType()
	{
		return accountType;
		
	}


	@Override
	public String toString() {
		return "Användarnamn: " + getUsername();
	}
}