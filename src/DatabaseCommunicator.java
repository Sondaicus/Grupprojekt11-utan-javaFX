import java.io.*;
import java.util.*;


public class DatabaseCommunicator implements fileIO
{
	private static ArrayList<Account>
		allAccounts;
	
	private static File
		fullFileNameFile;
	
	/*Strings used in program logic*/
	private static String
		dataBaseFolder ,
		currentFullDatabseFile ,
		nextFullDatabseFile ,
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
		OVERLOADCHECKER2 ,
		leapsInALoop;
	
	private static boolean
		seeExecutionInfoInTerminal;
	
	/*Strings used in console-window for user to read.*/
	private static String
		nextOSFolder = "\\" ,
		thisFolder = "src" ,
		thisClass = "DatabaseCommunicator" ,
		fullClassPathCollective = thisFolder + nextOSFolder + thisClass + nextOSFolder ,
		leapsInALoopToUser ,
		tabular1 = "    " ,
		tabular2 = tabular1 + tabular1 ,
		tabular3 = tabular2 + tabular1;
	
	
	
	DatabaseCommunicator()
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
	
	
	public void setLeapsInALoopToUser()
	{
		leapsInALoopToUser = tabular3 + "leapsInALoop " + leapsInALoop;
		
	}
	
	
	
	public void readAllUserFiles()
	{
		allAccounts = new ArrayList<Account>();
		
	}
	
	
	public void seeTerminalInformation(boolean status)
	{
		seeExecutionInfoInTerminal = status;
		
	}
	
	
	
	public String[] getUserFilesFromID(int userID) throws IOException
	{
		String thisMethod = "getUserFilesFromID";
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
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
		
		
		leapsInALoop = 0;
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			setLeapsInALoopToUser();
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
			}
			
			
			lineBeingRead = inStream.readLine();
			
			
			if(lineBeingRead.equals(null))
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(thisClass + nextOSFolder + "readIndividualUserFiles" + nextOSFolder + "User not found (" + userID + ")");
				}
				
				
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
			
			
			++leapsInALoop;
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
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return userIDAndName;
		
	}
	
	
	
	/*This method reads in the main- users.txt file, and other user related filed to the specific user. creates a
	temporary copy of the users.txt file, where it then removes the line with the specified user and then overrites
	the users.txt file, now without the specified user. To do this it reads the whole file first, then, it adds its
	values to a new string line by line, and when it comes to the specified user ID it stops reading. The it starts
	reading from the next file after the specified user, and saves its values to a new string. Once these who Strings
	 are complete they are put together into a new String, and that String is overwritten to the users.txt file.*/
	public void removeUser() throws IOException
	{
		String thisMethod = "removeUser";
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		String
			temporaryUsedDatabaseFile ,
			currentLineBeingRead ,
			userIDString ,
			newFilePart1 ,
			newFilePart2 ,
			completeNewFile ,
			excessiveBlankLineChecker;
		
		int
			userIDBreaker ,
			userIDInt ,
			nextLineBreaker ,
			newLineCheckStart ,
			part2Start ,
			newLineBlank1 ,
			newLineBlank2 ,
			nextBlankLineCounter;
		
		boolean
			userFound ,
			resetBlankCounter;
		
		
		
		currentFullDatabseFile = StringMethodInterfaces.readFullFile(usersListFile, seeExecutionInfoInTerminal);
		completeNewFile = StringMethodInterfaces.removeSingleLineInString(currentFullDatabseFile,
		"2" , seeExecutionInfoInTerminal);
		
		/*Start: if there are any blanks lines in the String they are removed here.*/
			completeNewFile = StringMethodInterfaces.removeExcessiveBlankLines(completeNewFile, seeExecutionInfoInTerminal );
		/*End: if there are any blanks lines in the String they are removed here.*/
		
	//	overwriteFile(usersListFile, completeNewFile);
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
	}
	
	
	
	public void writeToIndividualUserFile(String userID, String userName, String[] information) throws IOException
	{
		String thisMethod = "writeToIndividualUserFile";
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		String
			userPersonalFolderAdress ,
			userPersonalFolderFullPath ,
			userPersonalCompleteFile;
		
		
		userPersonalFolderAdress = "\\" + userID;
		userPersonalFolderFullPath = userIDsFolderPath + userPersonalFolderAdress;
		userPersonalCompleteFile = userPersonalFolderFullPath + userName;
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(userPersonalCompleteFile , true)));
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File being written to: " + userPersonalCompleteFile);
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
	
	
	
	public void overwriteFile(String fullFilePath, String[] information) throws IOException
	{
		String thisMethod = "overwriteFile (String information)";
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
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
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath)));
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File being overwritten: " + fullFilePath);
		}
		
		
		outStream.println(information);
		
		outStream.close();
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method:: " + fullClassPathCollective + thisMethod);
		}
		
	}
	
	
	
	public void addToList()
	{
	
	
	}
	
	
	
	public void removeFromList()
	{
	
	
	}
	
	
}