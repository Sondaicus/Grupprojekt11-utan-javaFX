import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;


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
		allUserNames ,
		allUsersDatabasePaths ,
		allUsersDatabaseFiles;
	
	private static int
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
		setSeeExecutionInfoInTerminal(false);
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
	
	
	
	public void setUserTxtFileDatabase(String oldFile)
	{
		String
			newFile;
		
		boolean
			correctFormat;
		
		
		newFile = oldFile;
		correctFormat = newFile.endsWith("\n");
		
		if(!correctFormat)
		{
			newFile = newFile + "\n";
		}
		
		usersTxtFileDatabase = newFile;
		
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
		allUserNames = new String[userFilesQuantity];
		allUsersDatabasePaths = new String[userFilesQuantity];
		allUsersDatabaseFiles = new String[userFilesQuantity];
		
		leapsInALoop = 0;
		for(int i = 0; i < userFilesQuantity; i++)
		{
			setLeapsInALoopToUser();
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
			}
			
			
			currentCheckedUserName = StringMethodInterfaces.returnSubstringByLine(allUserTxtFile, i, 0,
			seeExecutionInfoInTerminal);
			
			allUserNames[i] = currentCheckedUserName;
			allUsersDatabasePaths[i] = usersFolderPath + nextOSFolder + currentCheckedUserName + txtFile;
			resultHolder = StringMethodInterfaces.readFullFile(allUsersDatabasePaths[i],
			seeExecutionInfoInTerminal);
			
			individualUserTxtFound = (boolean) resultHolder.get(0);
			if(individualUserTxtFound)
			{
				allUserNames[i] = currentCheckedUserName;
				currentUserTxtFile = (String) resultHolder.get(1);
			}
			
			else
			{
				currentUserTxtFile = null;
			}
			
			allUsersDatabaseFiles[i] = currentUserTxtFile;
			
			++leapsInALoop;
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
	public boolean[] removeUser(String username) throws IOException
	{
		String thisMethod = "removeUser";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "username: " + "\n" + "$" + username + "$");
		}
		
		boolean[]
			allResults;
		
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
		
		
		allResults = new boolean[2];
		subjectsPersonalFilePath = usersFolderPath + nextOSFolder + username + txtFile;
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "subjectsPersonalFilePath: " + subjectsPersonalFilePath);
		}
		
		
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
				
			}
			
			else
			{
				proceed = false;
				
			}
			
			allResults = deleteFile(subjectsPersonalFilePath);
			
		}
		
		else
		{
			allResults[0] = false;
			allResults[1] = false;
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return allResults;
		
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
		
		
		information = "\n" + information;
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath , true)));
		outStream.println(information);
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File being written to: " + fullFilePath);
			System.out.println("Information being written: " + "\n" + "$" + information + "$");
		}
		
		
		outStream.close();
		
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
		
		
		leapsInALoop = 0;
		for(int i = 0; i < information.length; i++)
		{
			setLeapsInALoopToUser();
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
			}
			
			
			outStream.println(information[i]);
			
			++leapsInALoop;
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
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath, false)));
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
	
	
	public boolean[] deleteFile(String fullFilePathString) throws IOException
	{
		String thisMethod = "deleteFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		File fullFileNameFile;
		
		boolean resultDeleted, resultThrowable;
		
		boolean[] allResults;
		
		Path fullFilePathPath;
		
		Throwable failedDeleteCauseThrowable;
		
		
		allResults = new boolean[2];
		resultThrowable = false;
		fullFilePathPath = Paths.get(fullFilePathString);
		fullFileNameFile = new File(fullFilePathString);
		resultDeleted = fullFileNameFile.delete();
		
		if(!resultDeleted)
		{
			try
			{
				resultDeleted = java.nio.file.Files.deleteIfExists(fullFilePathPath);
				
			}
			
			catch(java.nio.file.FileSystemException e)
			{
				failedDeleteCauseThrowable = e.getCause();
				
				if(failedDeleteCauseThrowable == null)
				{
					resultThrowable = true;
				}
				
			}
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			if(resultDeleted)
			{
				System.out.println(tabular1 + "The file at " + fullFilePathString + " was succesfully deleted, result = " + resultDeleted);
			}
			
			else
			{
				System.out.println(tabular1 + "The file at " + fullFilePathString + " was not deleted, result = " + resultDeleted);
			}
			
			
			if(resultThrowable)
			{
				System.out.println(tabular1 + "The file at " + fullFilePathString + " was could not be deleted (java" + ".nio.file.FileSystemException, cause = null). resultThrowable = " + resultThrowable);
			}
			
			else
			{
				System.out.println(tabular1 + "resultThrowable = " + resultThrowable);
			}
			
		}
		
		allResults[0] = resultDeleted;
		allResults[1] = resultThrowable;
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return allResults;
		
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
			userAddOnString ,
			userFileLocation;
		
		
		userFileLocation = usersFolderPath + nextOSFolder + username + txtFile;
		
		
		success = true;
		if(success)
		{
			usersFound = StringMethodInterfaces.countInstancesBySubstring(usersTxtFileDatabase, username, 0, seeExecutionInfoInTerminal);
			
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
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "userAddOnString = " + "\n" + "$" + userAddOnString + "$");
			}
			
			
			usersTxtFileDatabase = usersTxtFileDatabase + userAddOnString;
			usersTxtFileDatabase = StringMethodInterfaces.removeExcessiveBlankLines(usersTxtFileDatabase,
			seeExecutionInfoInTerminal);
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "usersTxtFileDatabase = " + "\n" + "$" + usersTxtFileDatabase + "$");
			}
			
			
			overwriteFile(usersListFilePath, usersTxtFileDatabase);
			overwriteFile(userFileLocation, "");
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "usersTxtFileDatabase = " + "\n" + "$" + usersTxtFileDatabase + "$");
			}
			
			
			readAllUserFiles();
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return success;
	
	}
	
	
	
	public boolean[] addTaskToUser(String username, String taskInstance, String taskSubject) throws IOException
	{
		String thisMethod = "addTaskToUser";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "username: " + "\n" + "$" + username + "$");
		}
		
		
		boolean
			procceed;
		
		boolean[]
			successes;
		
		int
			userID ,
			taskDuplicates;
		
		String
			lineToPrint ,
			pathToUse ,
			fullString;
		
		
		successes = new boolean[2];
		pathToUse = null;
		lineToPrint = taskInstance + "_" + taskSubject + "_";
		procceed = true;
		userID = -1;
		
		for(int i = 0; i < successes.length; i++)
		{
			successes[i] = false;
			
		}
		
		leapsInALoop = 0;
		if(procceed)
		{
			for(int i = 0; i < allUserNames.length; i++)
			{
				setLeapsInALoopToUser();
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(leapsInALoopToUser);
				}
				
				
				if(username.equals(allUserNames[i]))
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular1 + "User found in database, exiting loop.");
					}
					
					
					userID = i;
					pathToUse = allUsersDatabasePaths[userID];
					procceed = true;
					successes[0] = true;
					break;
					
				}
				
				else
				{
					procceed = false;
					
				}
				
				++leapsInALoop;
			}
			
		}
		
		if(procceed)
		{
			taskDuplicates = StringMethodInterfaces.countInstancesByFullLine(allUsersDatabaseFiles[userID],
			lineToPrint, seeExecutionInfoInTerminal);
			
			if(taskDuplicates == 0)
			{
				procceed = true;
				successes[1] = true;
				
			}
			
			else
			{
				procceed = false;
				
			}
			
		}
		
		if(procceed)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "pathToUse = " + pathToUse);
				System.out.println(tabular1 + "lineToPrint = " + "\n" + "$" + lineToPrint + "$");
			}
			
			allUsersDatabaseFiles[userID] = allUsersDatabaseFiles[userID] + lineToPrint;
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "allUsersDatabaseFiles[" + userID + "]: " + "\n" + "$" + allUsersDatabaseFiles[userID] + "$");
			}
			
			
			fullString = allUsersDatabaseFiles[userID];
			fullString = StringMethodInterfaces.removeExcessiveBlankLines(fullString, seeExecutionInfoInTerminal);
			
			overwriteFile(pathToUse, fullString);
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "allUsersDatabaseFiles[" + userID + "] = " + "\n" + "$" + allUsersDatabaseFiles[userID] + "$");
			}
			
		}
		
		else
		{
			System.out.println(tabular1 + "User not found in database, return value will be false.");
		}
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return successes;
		
	}
	
	
	
	public void printClassVariables()
	{
		String thisMethod = "printClassVariables";
		System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		
		System.out.println(tabular1 + "fullProjectPath: " + fullProjectPath);
		System.out.println(tabular1 + "filesFolderPath: " + filesFolderPath);
		System.out.println(tabular1 + "usersFolderPath: " + usersFolderPath);
		System.out.println(tabular1 + "usersListFilePath: " + usersListFilePath);
		System.out.println(tabular1 + "usersTxtFileDatabase: " + "\n" + "$" + usersTxtFileDatabase + "$");
		
		for(int i = 0; i < allUserNames.length; i++)
		{
			System.out.println(tabular2 + "allUserNames[" + i + "]: " + "\n" + "$" + allUserNames[i] + "$");
		}
		
		for(int i = 0; i < allUsersDatabasePaths.length; i++)
		{
			System.out.println(tabular2 + "allUsersDatabasePaths[" + i + "]: " + allUsersDatabasePaths[i]);
		}
	
		for(int i = 0; i < allUsersDatabaseFiles.length; i++)
		{
			System.out.println(tabular2 + "allUsersDatabaseFiles[" + i + "]: " + "\n" + "$" + allUsersDatabaseFiles[i] + "$");
		}
		
		System.out.println("End method: " + fullClassPathCollective + thisMethod);
	
	}
	
	
	
	public void testMethod() throws IOException
	{
		String fullfile = "hej_lösenord1_\n" + "hurdy_gurdy_\n" + "på_lösenord2_\n" + "dig_lösenord3_\n" +
		                  "hurdy_gurdy_\n";
		
		StringMethodInterfaces.returnFullLineByStringLineIndex(fullfile, 1,true);
	}
	
}