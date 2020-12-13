import java.io.*;
import java.util.*;


public class DatabaseCommunicator implements DatabaseCommunicatorAbstractDiagrams , StringMethodInterfaces
{
	private static ArrayList<Account>
		allAccounts;
	
	/*Strings used in program logic*/
	private static String
		fullProjectPath ,
		filesFolderPath ,
		usersFolderPath ,
		usersListFilePath ,
		usersTxtFileDatabase;
	
	private static String[]
		allUsersDatabasePaths ,
		allUsersDatabaseFiles;
	
	private static long
		OVERLOADCHECKER1[];
	
	private static int
		OVERLOADCHECKER2 ,
		leapsInALoop;
	
	private static boolean
		seeExecutionInfoInTerminal;
	
	/*Strings used in console-window for user to read.*/
	private static String
		txtFile = ".txt" ,
		nextOSFolder = "\\" ,
		thisFolder = "src" ,
		thisClass = "DatabaseCommunicator" ,
		fullClassPathCollective = thisFolder + nextOSFolder + thisClass + nextOSFolder ,
		leapsInALoopToUser ,
		tabular1 = "    " ,
		tabular2 = tabular1 + tabular1 ,
		tabular3 = tabular2 + tabular1;
	
	
	
	DatabaseCommunicator() throws IOException
	{
		setDatabaseFolders();
		readAllUserFiles();
		
	}
	
	
	DatabaseCommunicator(boolean seeExecutionInfoInTerminal) throws IOException
	{
		setSeeExecutionInfoInTerminal(seeExecutionInfoInTerminal);
		setDatabaseFolders();
		readAllUserFiles();
		
	}
	
	
	
	public void setSeeExecutionInfoInTerminal(boolean seeExecutionInfoInTerminal)
	{
		this.seeExecutionInfoInTerminal = seeExecutionInfoInTerminal;
		
	}
	
	
	
	public void setDatabaseFolders()
	{
		File
			fullFileNameFile;
		
		String
			fullFileNameString;
		
		int
			setFolderLocation;
		
		fullFileNameString = "MainFolderIdentifyerTextFile.txt";
		fullFileNameFile = new File(fullFileNameString);
		fullProjectPath = fullFileNameFile.getAbsolutePath();
		setFolderLocation = fullProjectPath.indexOf(fullFileNameString);
		fullProjectPath = fullProjectPath.substring(0, setFolderLocation);
		
		filesFolderPath = fullProjectPath + "\\Files";
		
		usersFolderPath = filesFolderPath + "\\Users";
		
		usersListFilePath = filesFolderPath + "\\users.txt";
		
	}
	
	
	
	public String getUserTxtFileDatabase()
	{
		return usersTxtFileDatabase;
		
	}
	
	
	
	public void setUserTxtFileDatabase(String usersTxtFileDatabase)
	{
		this.usersTxtFileDatabase = usersTxtFileDatabase;
		
	}
	
	
	
	public void setLeapsInALoopToUser()
	{
		leapsInALoopToUser = tabular3 + "leapsInALoop " + leapsInALoop;
		
	}
	
	
	
	public void seeTerminalInformation(boolean status)
	{
		seeExecutionInfoInTerminal = status;
		
	}
	
	
	
	public void readAllUserFiles() throws IOException
	{
		String thisMethod = "readAllUserFiles";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
			
		ArrayList<Object>
			resultHolder;
		
		String
			allUserTxtFile ,
			currentCheckedUserName ,
			currentUserTxtFile;
		
		boolean
			allUserTxtFound ,
			individualUserTxtFound;
		
		int
			userFilesQuantity;
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular1 + "Start: reading users.txt.");
		}
		
		
		resultHolder = StringMethodInterfaces.readFullFile(usersListFilePath, seeExecutionInfoInTerminal);
		allUserTxtFound = (boolean) resultHolder.get(0);
		allUserTxtFile = (String) resultHolder.get(1);
		
		if(allUserTxtFound)
		{
			allUserTxtFile = StringMethodInterfaces.removeExcessiveBlankLines(allUserTxtFile, seeExecutionInfoInTerminal);
			setUserTxtFileDatabase(allUserTxtFile);
		}
		
		else
		{
			setUserTxtFileDatabase(null);
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular1 + "End: reading users.txt.");
		}
		
		
		userFilesQuantity = new File(usersFolderPath).list().length;
		allUsersDatabasePaths = new String[userFilesQuantity];
		allUsersDatabaseFiles = new String[userFilesQuantity];
		for(int i = 0; i < userFilesQuantity; i++)
		{
			currentCheckedUserName = StringMethodInterfaces.returnSubstringByLine(allUserTxtFile, i, 0,
			seeExecutionInfoInTerminal);
			
			allUsersDatabasePaths[i] = usersFolderPath + nextOSFolder + currentCheckedUserName + txtFile;
			resultHolder = StringMethodInterfaces.readFullFile(allUsersDatabasePaths[i],
			seeExecutionInfoInTerminal);
			
			individualUserTxtFound = (boolean) resultHolder.get(0);
			if(individualUserTxtFound)
			{
				currentUserTxtFile = (String) resultHolder.get(1);
			}
			
			else
			{
				currentUserTxtFile = null;
			}
			
			allUsersDatabaseFiles[i] = currentUserTxtFile;
		
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular1 + "userFilesQuantity =  " + userFilesQuantity);
			
			for(int i = 0; i < userFilesQuantity; i++)
			{
				System.out.println(tabular2 + "allUsersDatabasePaths[" + i + "] = " + "\n" +  allUsersDatabasePaths[i]);
				System.out.println(tabular2 + "allUsersDatabaseFiles[" + i + "] = " + "\n" + "$" +
				                   allUsersDatabaseFiles[i] + "$");
			}
			
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
	
		
	}
	
	
	
	public String getUserFile(String username) throws IOException
	{
		String thisMethod = "getUserFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		String
			userFilePath ,
			userFileContents;
		
		ArrayList<Object>
			resultHolder;
		
		boolean
			fileReadResult;
		
		
		userFilePath = usersFolderPath + nextOSFolder + username + txtFile;
		resultHolder = StringMethodInterfaces.readFullFile(userFilePath, seeExecutionInfoInTerminal);
		
		fileReadResult = (boolean) resultHolder.get(0);
		
		if(fileReadResult)
		{
			userFileContents = (String) resultHolder.get(1);
		}
		
		else
		{
			userFileContents = null;
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return userFileContents;
		
	}
	
	
	
/*	public String getUserData(String username) throws IOException
	{
	
	}*/
	
	
	
	
	/*This method reads in the main- users.txt file, and other user related filed to the specific user. creates a
	temporary copy of the users.txt file, where it then removes the line with the specified user and then overrites
	the users.txt file, now without the specified user. To do this it reads the whole file first, then, it adds its
	values to a new string line by line, and when it comes to the specified user ID it stops reading. The it starts
	reading from the next file after the specified user, and saves its values to a new string. Once these who Strings
	 are complete they are put together into a new String, and that String is overwritten to the users.txt file.*/
	public boolean removeUser(String username) throws IOException
	{
		String thisMethod = "removeUser";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		boolean
			proceed ,
			userFound ,
			fileFound;
		
		String
			lineRemoved ,
			fileContents ,
			allUsersTxtFile ,
			subjectsPersonalFilePath;
		
		ArrayList<Object>
			resultHolder;
		
		
		subjectsPersonalFilePath = usersFolderPath + username + txtFile;
		fileContents = null;
		proceed = true;
		
		if(proceed)
		{
			resultHolder = StringMethodInterfaces.readFullFile(usersListFilePath , seeExecutionInfoInTerminal);
			
			fileFound = (Boolean) resultHolder.get(0);
			fileContents = (String) resultHolder.get(1);
			
			if(fileFound)
			{
				proceed = true;
				
			}
			
			else
			{
				proceed = false;
				
			}
			
		}
		
		if(proceed)
		{
			resultHolder = StringMethodInterfaces.returnFullLineBySubstring(fileContents , username , 0 , seeExecutionInfoInTerminal);
			userFound = (Boolean) resultHolder.get(0);
			lineRemoved = (String) resultHolder.get(1);
			
			if(userFound)
			{
				allUsersTxtFile = StringMethodInterfaces.removeSingleLineInString(fileContents , lineRemoved , seeExecutionInfoInTerminal);
				allUsersTxtFile =  StringMethodInterfaces.removeExcessiveBlankLines(allUsersTxtFile, seeExecutionInfoInTerminal);
				overwriteFile(usersListFilePath , allUsersTxtFile);
				deleteFile(subjectsPersonalFilePath);
				
			}
			
			else
			{
				proceed = false;
				
			}
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return proceed;
		
	}
	
	
	
	public void writeToFile(String fullFilePath, String information) throws IOException
	{
		String thisMethod = "writeToFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		PrintWriter
			outStream;
	
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(information , true)));
		outStream.println(information);
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File being written to: " + fullFilePath);
			System.out.println("Information being written: " + "\n" + "$" + information + "$");
		}
		
		
		outStream.close();
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
	}
	
	
	
	public void overwriteFile(String fullFilePath, String[] information) throws IOException
	{
		String thisMethod = "overwriteFile (String[] information)";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		PrintWriter
			outStream;
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath)));
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File being overwritten: " + fullFilePath);
		}
		
		
		for(int i = 0; i < information.length; i++)
		{
			outStream.println(information[i]);
			
		}
		
		outStream.close();
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
	}
	
	
	
	public void overwriteFile(String fullFilePath, String information) throws IOException
	{
		String thisMethod = "overwriteFile (single String information)";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		PrintWriter
			outStream;
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath)));
		outStream.println(information);
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File being overwritten: " + fullFilePath);
		}
		
		
		outStream.close();
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method:: " + fullClassPathCollective + thisMethod);
		}
		
	}
	
	
	public void deleteFile(String fullFilePath)
	{
		String thisMethod = "deleteFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		File
			fullFileNameFile;
		
		boolean
			result;
		
		
		fullFileNameFile = new File(fullFilePath);
		result = fullFileNameFile.delete();
		
		
		if(seeExecutionInfoInTerminal)
		{
			if(result)
			{
				System.out.println(tabular1 + "The file at " + fullFilePath + " was succesfully deleted, result = " + result);
			}
			
			else
			{
				System.out.println(tabular1 + "The file at " + fullFilePath + " was not deleted, result = " + result);
			}
			
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
	}
	
	
	
	public boolean createUser(String username, String password) throws IOException
	{
		String thisMethod = "createUser";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		boolean
			success;
		
		int
			usersFound;
		
		String
			userAddOnString;
		
		
		success = true;
		if(success)
		{
			usersFound = StringMethodInterfaces.countInstancesBySubstring(usersTxtFileDatabase , username , 1 , seeExecutionInfoInTerminal);
			
			if(usersFound == 0)
			{
				success = true;
				
			}
			
			else
			{
				success = false;
				
			}
			
		}
		
		if(success)
		{
			userAddOnString = username + "_" + password + "_";
			usersTxtFileDatabase = usersTxtFileDatabase + userAddOnString;
			usersTxtFileDatabase = StringMethodInterfaces.removeExcessiveBlankLines(usersTxtFileDatabase, seeExecutionInfoInTerminal);
			writeToFile(usersListFilePath, userAddOnString);
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return success;
	
	}
	
	
	
	public void removeFromList()
	{
	
	}
	
	
	
	public void testMethod() throws IOException
	{
	
	}
	
}