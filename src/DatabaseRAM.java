import java.io.*;
import java.util.*;


public class DatabaseRAM implements fileIO
{
	private static ArrayList<Account>
		allAccounts;
	
	private static File
		fullFileNameFile;
	
	private static String
		dataBaseFolder ,
		fullDatabseFile ,
		fullProjectPath ,
		fullFileNameString ,
		filesFolderPath ,
		userIDsFolderPath ,
		usersListFile;
	
	private static BufferedReader
		inStream;
	
	private static PrintWriter
		outStream;
	
	private static long
		OVERLOADCHECKER1[];
	
	private static int
		OVERLOADCHECKER2;
	
	
	
	
	DatabaseRAM()
	{
		setDatabaseFolders();
		readAllUserFiles();
		
	}
	
	
	
	
	public void setDatabaseFolders()
	{
		int
			setFolderLocation;
		
		fullFileNameString = "MainFolderIdentifyerTextFile.txt";
		fullFileNameFile = new File(fullFileNameString);
		fullProjectPath = fullFileNameFile.getAbsolutePath();
		setFolderLocation = fullProjectPath.indexOf(fullFileNameString);
		fullProjectPath = fullProjectPath.substring(0, setFolderLocation);
		
		filesFolderPath = fullProjectPath + "\\Files";
		
		userIDsFolderPath = filesFolderPath + "\\UserIDsFolder";
		
		usersListFile = filesFolderPath + "\\users.txt";
		
	}
	
	
	
	public void readAllUserFiles()
	{
		allAccounts = new ArrayList<Account>();
		
	}
	
	
	public String[] getUserFilesFromID(int userID) throws IOException
	{
		String[]
			userIDAndName;
		
		String
			readIDString ,
			readNameString ,
			restLineHolder ,
			lineBeingRead;
		
		int
			idBreak ,
			nameBreak ,
			readIDToInt;
		
		boolean
			userFound;
		
		
		inStream = new BufferedReader(new FileReader(usersListFile));
		userIDAndName = new String[2];
		userFound = false;
		
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			lineBeingRead = inStream.readLine();
			
			
			if(lineBeingRead.equals(null))
			{
				System.out.println("DatabaseRAM\\readIndividualUserFiles\\User not found (" + userID + ")");
				readIDString = "";
				readNameString = "";
				break;
				
			}
			
			
			idBreak = lineBeingRead.indexOf("_");
			readIDString = lineBeingRead.substring(0, idBreak);
			restLineHolder = lineBeingRead.substring(idBreak + 1);
			nameBreak = restLineHolder.indexOf("_");
			readNameString = restLineHolder.substring(0, nameBreak);
			readIDToInt = Integer.parseInt(readIDString);
			
			
			if(readIDToInt == userID)
			{
				userFound = true;
				readNameString = readNameString + ".txt";
				break;
				
			}
			
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		
		if(userFound)
		{
			userIDAndName[0] = readIDString;
			userIDAndName[1] = readNameString;
			
		}
		
		else
		{
			userIDAndName[0] = null;
			userIDAndName[1] = null;
			
		}
		
		return userIDAndName;
		
	}
	
	
	
	public void removeUser(int userID)
	{
	
	
	}
	
	
	
	public void writeToIndividualUserFile(String userID, String userName, String[] information) throws IOException
	{
		String
			userPersonalFolderAdress ,
			userPersonalFolderFullPath ,
			userPersonalCompleteFile;
		
	
		userPersonalFolderAdress = "\\" + userID;
		userPersonalFolderFullPath = userIDsFolderPath + userPersonalFolderAdress;
		userPersonalCompleteFile = userPersonalFolderFullPath + userName;
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(userPersonalCompleteFile , true)));
		
		
		System.out.println("File being written to: " + userPersonalCompleteFile);
		
		
		for(int i = 0; i < information.length; i++)
		{
			outStream.println(information[i]);
		
		}
		
		outStream.close();
		
	}
	
	
	
	public void overwriteFile(String fullFilePath, String[] information) throws IOException
	{
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath)));
		
		System.out.println("File being overwritten: " + fullFilePath);
		
		
		for(int i = 0; i < information.length; i++)
		{
			outStream.println(information[i]);
			
		}
		
		outStream.close();
	
	}
	
	
	
	public void addToList()
	{
	
	
	}
	
	
	
	public void removeFromList()
	{
	
	
	}
	
	
}