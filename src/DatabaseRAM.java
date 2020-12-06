import java.io.*;
import java.util.*;


public class DatabaseRAM implements fileIO
{
	private static ArrayList<Account>
		allAccounts;
	
	private static String
		dataBaseFolder ,
		fullDatabseFile ,
		fullPath ,
		fullFileName;
	
	
	DatabaseRAM()
	{
		allAccounts = new ArrayList<Account>();
		
	}
	
	
	public void setDatabaseFolder()
	{
		int
			setFolderLocation;
		
		fullFileName = "MainFolderIdentifyerTextFile.txt";
		fullPath = fullFileName.getAbsolutePath();
		setFolderLocation = fullPath.indexOf(fullFileName);
		fullPath = fullPath.substring(0, setFolderLocation);
		
	}
	
	public void readFromFile()
	{
	
	
	}
	
	public void setFilecontentsToList()
	{
	
	
	}
	
	public void writeToFile()
	{
	
	
	}
	
	public void overwriteFile()
	{
	
	
	}
	
	public void addToList()
	{
	
	
	}
	
	public void removeFromList()
	{
	
	
	}
	
	
}