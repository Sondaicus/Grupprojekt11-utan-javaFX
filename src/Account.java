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
	

	public ArrayList <Subject>
			subjects;
	
	public Account(String username, String password, int accountType,ArrayList <Subject>
			subjects)
	{
		
		setUsername(username);
		setPassword(password);
		setAccountType(accountType);
		try {
			setId();
		} catch (IOException io) {
			io.printStackTrace();
		}
		setSubjects(subjects);

		
	}
	
	public void setUsername(String username)
	{
		this.username = username;
		
	}
	
	public void setPassword(String password)
	{
		this.password = password;
		
	}
	
	private void setId() throws IOException
	{
		id = CreateNewUserID.getAndSetIDs();
		
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
	


	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return getId() + " " + getUsername();
	}
}