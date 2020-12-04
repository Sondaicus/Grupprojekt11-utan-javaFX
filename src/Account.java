import java.util.*;

public class Account
{
	private String
		username ,
		password;
	
	private int
		id ,
		accountType;
	
	private ArrayList<Account>
		users;
	
	
	public Account()
	{
		users = new ArrayList<Account>();
		
	}
	
	public Account(String username, String password, int id, int accountType)
	{
		users = new ArrayList<Account>();
		
		setUsername(username);
		setPassword(password);
		setId(id);;
		setAccountType(accountType);
		
	}
	
	
	public void setUsername(String username)
	{
		this.username = username;
		
	}
	
	public void setPassword(String password)
	{
		this.password = password;
		
	}
	
	public void setId(int id)
	{
		this.id = id;
		
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
	
	public int getId()
	{
		return id;
		
	}
	
	public int getAccountType()
	{
		return accountType;
		
	}
	
	public ArrayList<Account> getUsers()
	{
		return users;
		
	}
	
}