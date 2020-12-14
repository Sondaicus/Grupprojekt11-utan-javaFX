import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DatabaseCommunicator implements DatabaseCommunicatorAbstractDiagrams , DatabaseToRestOfProgramDiagram , StringMethodInterfaces
{
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
	
	
	
	public String[][][] getAllUsers()
	{
		String thisMethod = "getAllUsers";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		String[][][]
			resultsToReturn;
		
		String
			baseFileFull ,
			baseFileTempLine ,
			baseFileSubstring1 ,
			baseFileSubstring2 ,
			baseFileSubstring3;
		
		int
			arrayFields;
		
		
		resultsToReturn = new String[0][0][0];
		
		
		
		baseFileFull = getUserTxtFileDatabase();
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return resultsToReturn;
		
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
		
		
		try
		{
			userFilesQuantity = new File(usersFolderPath).list().length;
		}
		
		catch(NullPointerException e)
		{
			userFilesQuantity = 0;
		}
		
		
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
	
	
	
	public ArrayList<Object> getUserFile(String username) throws IOException
	{
		String thisMethod = "getUserFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		int
			lineLoops ,
			lineLoopsToLines ,
			approvedLineLoops;
		
		String
			userFilePath ,
			fullUserFileContentsSingleString ,
			temporaryUserFileContentsSingleString ,
			subString1 ,
			subString2;
		
		String[][]
			userFileContentsHolder ,
			userFileContentsFinal ,
			lastCorrectChecker;
		
		ArrayList<Object>
			finalResultReader ,
			finalResultSender ,
			temporarySubstringHolder;
		
		Boolean
			fileReadResult;
		
		boolean
			countLine ,
			breakLoop;
		
		
		approvedLineLoops = 0;
		userFilePath = usersFolderPath + nextOSFolder + username + txtFile;
		finalResultReader = StringMethodInterfaces.readFullFile(userFilePath, seeExecutionInfoInTerminal);
		
		fileReadResult = (Boolean) finalResultReader.get(0);
		
		if(fileReadResult)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "fileReadResult is true, chopping file begins.");
			}
			
			
			fullUserFileContentsSingleString = (String) finalResultReader.get(1);
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "fullUserFileContentsSingleString: " + "\n" + "$" + fullUserFileContentsSingleString + "$");
			}
			
			
			lineLoops = StringMethodInterfaces.countTotalNumberOfLines(fullUserFileContentsSingleString, seeExecutionInfoInTerminal);
			lineLoopsToLines = lineLoops + 1;
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "lineLoops = " + lineLoops);
				System.out.println(tabular1 + "lineLoopsToLines = " + lineLoopsToLines);
			}
			
			
			userFileContentsHolder = new String[lineLoops][2];
			
			for(int i = 1; i < lineLoopsToLines; i++)
			{
				temporarySubstringHolder = StringMethodInterfaces.returnFullLineByStringLineIndex(fullUserFileContentsSingleString, i,	seeExecutionInfoInTerminal);
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular1 + "temporarySubstringHolder: " + "\n" + "$" + temporarySubstringHolder + "$");
				}
				
				
				countLine = (boolean) temporarySubstringHolder.get(0);
				breakLoop =  (boolean) temporarySubstringHolder.get(1);
				
				if(countLine)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular1 + "countLine is true, adding elements to String[][] begins.");
					}
					
					
					temporaryUserFileContentsSingleString =  (String) temporarySubstringHolder.get(2);
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "temporaryUserFileContentsSingleString: " + "\n" + "$" + temporaryUserFileContentsSingleString + "$");
					}
					
					
					subString1 = StringMethodInterfaces.returnSubstringByLine(temporaryUserFileContentsSingleString,
					0, seeExecutionInfoInTerminal);
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "subString1: " + "\n" + "$" + subString1 + "$");
					}
					
					
					subString2 = StringMethodInterfaces.returnSubstringByLine(temporaryUserFileContentsSingleString,
					1, seeExecutionInfoInTerminal);
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "subString2: " + "\n" + "$" + subString2 + "$");
					}
					
					
					userFileContentsHolder[approvedLineLoops][0] = subString1;
					userFileContentsHolder[approvedLineLoops][1] = subString2;
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "userFileContentsHolder[" + approvedLineLoops + "][0]: " +
						                   "\n" + "$" + userFileContentsHolder[approvedLineLoops][0] + "$");
						System.out.println(tabular2 + "userFileContentsHolder[" + approvedLineLoops + "][1]: " +
						                   "\n" + "$" + userFileContentsHolder[approvedLineLoops][1] + "$");
					}
					
					
					++approvedLineLoops;
					
				}
				
				if(breakLoop)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular1 + "breakLoop is true, exiting loop.");
					}
					
					
					break;
					
				}
				
			}
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "approvedLineLoops = " + approvedLineLoops);
			}
			
			
			userFileContentsFinal = new String[approvedLineLoops][2];
			for(int i = 0; i < approvedLineLoops; i++)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Strings being saved loop " + i + ".");
				}
				
				
				userFileContentsFinal[i][0] = userFileContentsHolder[i][0];
				userFileContentsFinal[i][1] = userFileContentsHolder[i][1];
				
			}
			
		}
		
		else
		{
			userFileContentsFinal = null;
		}
		
		finalResultSender = new ArrayList <Object>(2);
		finalResultSender.add(0, fileReadResult);
		finalResultSender.add(1, userFileContentsFinal);
		
		
		if(seeExecutionInfoInTerminal)
		{
			lastCorrectChecker = (String[][]) finalResultSender.get(1);
			
			System.out.println(tabular1 + "lastCorrectChecker.length = " + lastCorrectChecker.length);
			
			
			for(int i = 0; i < lastCorrectChecker.length; i++)
			{
				System.out.println(tabular2 + "lastCorrectChecker[" + i + "][0] = " + lastCorrectChecker[i][0]);
				System.out.println(tabular2 + "lastCorrectChecker[" + i + "][0] = " + lastCorrectChecker[i][1]);
				
			}
			
		}
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("End method: " + fullClassPathCollective + thisMethod);
		}
		
		
		return finalResultSender;
		
	}
	
	
	
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
	
	
	
	public void overwriteFile(String fullFilePath, String information) throws IOException
	{
		String thisMethod = "overwriteFile (single String information)";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		}
		
		
		PrintWriter
			outStream;
		
		File
			secondaryUserFile;
		
		boolean
			secondaryFileCreated;
		
		
		secondaryFileCreated = false;
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("File to be overwritten: " + fullFilePath);
		}
		
		
		try
		{
			outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath , false)));
			outStream.println(information);
			outStream.close();
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "Successfully wrote to file.");
			}
			
			
		}
		
		catch(java.io.FileNotFoundException e)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "File was not found, attempting to create a new one and a new folder.");
			}
			
			
			secondaryUserFile = new File(usersFolderPath);
			
			secondaryFileCreated = secondaryUserFile.mkdir();
			
			if(secondaryFileCreated)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "New directory successfully created.");
				}
				
				secondaryUserFile = new File(fullFilePath);
				
				secondaryFileCreated = secondaryUserFile.createNewFile();
				
				if(secondaryFileCreated)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "New txt-file successfully created.");
					}
					
					
					outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath , false)));
					outStream.println(information);
					outStream.close();
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "New file was written to.");
					}
					
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "New file was not written to, printing to file failed.");
				}
				
			}
			
		}
		
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
		
		
		File
			fullFileNameFile;
		
		boolean
			resultDeleted, resultThrowable;
		
		boolean[]
			allResults;
		
		Path
			fullFilePathPath;
		
		Throwable
			failedDeleteCauseThrowable;
		
		
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
	
	
	
	public boolean createUser(String username, String password, int accountType) throws IOException
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
			userAddOnString = username + "_" + password + "_" + accountType + "_";
			
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
			
			allUsersDatabaseFiles[userID] = allUsersDatabaseFiles[userID] + "\n" + lineToPrint;
			
			
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
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "User not found in database, return value will be false.");
			}
			
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
	
}