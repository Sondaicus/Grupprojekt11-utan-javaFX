import java.io.*;
import java.util.*;


public class DatabaseCommunicator implements DatabaseCommunicatorAbstractDiagrams , StringMethodInterfaces
{
	private static ArrayList<Account>
		allAccounts;
	
	private static File
		fullFileNameFile;
	
	/*Strings used in program logic*/
	private static String
		fullProjectPath ,
		fullFileNameString ,
		filesFolderPath ,
		usersFolderPath ,
		usersListFilePath ,
		usersTxtFileDatabase;
	
	private static String[]
		allUsersDatabaseFiles;
	
	
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
			allUserTxtFile;
		
		boolean
			allUserTxtFound;
		
		int
			userFilesQuantity;
		
		File
			currentTemporaryUserFile;
		
		ArrayList<File>
			allIndividualUserFiles;
		
		
		allIndividualUserFiles = new ArrayList <File>(0);
		resultHolder = StringMethodInterfaces.readFullFile(usersListFilePath , seeExecutionInfoInTerminal);
		allUserTxtFound = (boolean) resultHolder.get(0);
		allUserTxtFile = (String) resultHolder.get(1);
		
		if(allUserTxtFound)
		{
			setUserTxtFileDatabase(allUserTxtFile);
		}
		
		else
		{
			setUserTxtFileDatabase(null);
		}
		
		
		userFilesQuantity = new File(usersFolderPath).list().length;
		for(int i = 0; i < userFilesQuantity; i++)
		{
		
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular1 + "userFilesQuantity =  " + userFilesQuantity);
		}
		
		if(seeExecutionInfoInTerminal)
		{
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
			completeDatabseFile;
		
		ArrayList<Object>
			resultHolder;
		
		
		fileContents = null;
		proceed = true;
		resultHolder = new ArrayList<Object>(2);
		
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
		
		resultHolder = new ArrayList<Object>(2);
		
		if(proceed)
		{
			resultHolder = StringMethodInterfaces.returnFullLineBySubstring(fileContents , username , 0 , seeExecutionInfoInTerminal);
			userFound = (Boolean) resultHolder.get(0);
			lineRemoved = (String) resultHolder.get(1);
			
			if(userFound)
			{
				completeDatabseFile = StringMethodInterfaces.removeSingleLineInString(fileContents , lineRemoved , seeExecutionInfoInTerminal);
				overwriteFile(usersListFilePath , completeDatabseFile);
				
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
		userPersonalFolderFullPath = usersFolderPath + userPersonalFolderAdress;
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