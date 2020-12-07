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
		currentFullDatabseFile ,
		nextFullDatabseFile ,
		fullProjectPath ,
		fullFileNameString ,
		filesFolderPath ,
		userIDsFolderPath ,
		usersListFile ,
	
		nextOSFolder = "\\" ,
		thisFolder = "src" ,
		thisClass = "DatabaseRAM" ,
		fullClassPathCollective = thisFolder + nextOSFolder + thisClass + nextOSFolder;
	
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
		String thisMethod = "getUserFilesFromID";
		
		System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		
		
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
				System.out.println(thisClass + nextOSFolder + "readIndividualUserFiles" + nextOSFolder
				                   + "User not found (" + userID + ")");
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
		
		
		System.out.println("End method: " + fullClassPathCollective + thisMethod);
		
		
		return userIDAndName;
		
	}
	
	
	
	/*This method reads in the main- users.txt file, and other user related filed to the specific user. creates a
	temporary copy of the users.txt file, where it then removes the line with the specified user and then overrites
	the users.txt file, now without the specified user. To do this it reads the whole file first, then, it adds its
	values to a new string line by line, and when it comes to the specified user ID it stops reading. The it starts
	reading from the next file after the specified user, and saves its values to a new string. Once these who Strings
	 are complete they are put together into a new String, and that String is overwritten to the users.txt file.*/
	public void removeUser(int userID) throws IOException
	{
		String thisMethod = "removeUser";
		
		System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		
		
		String
			temporaryUsedDatabaseFile ,
			currentLineBeingRead ,
			userIDString ,
			newFilePart1 ,
			newFilePart2 ,
			completeNewFile;
		
		int
			userIDBreaker ,
			userIDInt ,
			nextLineBreaker ,
			newLineCheckStart ,
			part2Start ,
			newLineBlank1 ,
			newLineBlank2 ,
			nextBlankLineCounter;
		
		
		currentFullDatabseFile = "";
		newFilePart1 = "";
		newFilePart2 = "";
		
		
		inStream = new BufferedReader(new FileReader(usersListFile));
		
		/*Begin: reading the full user.txt file and saving it to a single String.*/
			OVERLOADCHECKER1 = new long[1000000];
			OVERLOADCHECKER2 = 0;
			while(true)
			{
				currentLineBeingRead = inStream.readLine();
				
				if(currentLineBeingRead == null)
				{
					break;
					
				}
				
				currentFullDatabseFile += currentLineBeingRead;
				currentFullDatabseFile += "\n";
				
				
				OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
				OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
			}
		/*End: reading the full user.txt file and saving it to a single String.*/
			
			inStream.close();
			
			
			newLineCheckStart = 0;
			temporaryUsedDatabaseFile = currentFullDatabseFile;
			nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
		
		
		/*Begin: saving the files lines to a separate String up until it finds the user (if it finds it).*/
			OVERLOADCHECKER1 = new long[1000000];
			OVERLOADCHECKER2 = 0;
			while(true)
			{
				currentLineBeingRead = temporaryUsedDatabaseFile.substring(newLineCheckStart, nextLineBreaker);
				temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(newLineCheckStart, nextLineBreaker + 1);
				userIDBreaker = currentLineBeingRead.indexOf("_");
				userIDString = currentLineBeingRead.substring(0, userIDBreaker);
				userIDInt = Integer.parseInt(userIDString);
				
				if(userIDInt == userID)
				{
					break;
					
				}
				
				else
				{
					newFilePart1 += currentLineBeingRead;
					newLineCheckStart = temporaryUsedDatabaseFile.indexOf("\n");
					
					if(newLineCheckStart != -1)
					{
						++newLineCheckStart;
						newFilePart1 += "\n";
						
						currentLineBeingRead = temporaryUsedDatabaseFile.substring(newLineCheckStart);
						nextLineBreaker = currentLineBeingRead.indexOf("\n");
						
						if(nextLineBreaker == -1)
						{
							nextLineBreaker = currentFullDatabseFile.length();
							
						}
						
					}
					
					else
					{
						break;
						
					}
					
				}
				
				
				OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
				OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
			}
			
			System.out.println("newFilePart1 : " + "@" + newFilePart1 + "@");
			
		/*End: saving the files lines to a separate String up until it finds the user (if it finds it).*/
		
		
		/*Start: saving the files lines after the specified user is found to a separate String.*/
			temporaryUsedDatabaseFile = currentFullDatabseFile;
			part2Start = temporaryUsedDatabaseFile.lastIndexOf(newFilePart1);
			newFilePart2 = temporaryUsedDatabaseFile.substring(part2Start + 1);
			
			/*
			part2Start = currentLineBeingRead.indexOf("\n");
			
			if(part2Start == -1)
			{
				newFilePart2 += currentLineBeingRead;
				
			}
			
			else
			{
				newFilePart2 = currentFullDatabseFile.substring(part2Start + 1);
				
			}*/
		/*End: saving the files lines after the specified user is found to a separate String.*/
		
		
		System.out.println("newFilePart2 : " + "£" + newFilePart2 + "£");
		
		
		//Combines the two files into a separate String to be written to the txt-file.
			completeNewFile = newFilePart1 + newFilePart2;
			
		System.out.println("completeNewFile : " + "#" + completeNewFile + "#");
			
			
		/*Start: if there are any blanks lines in the String they are removed here.*/
		
			nextBlankLineCounter= 0;
		
			OVERLOADCHECKER1 = new long[1000000];
			OVERLOADCHECKER2 = 0;
			while(true)
			{
				newLineBlank1 = completeNewFile.indexOf("\n", nextBlankLineCounter);
				
				if(newLineBlank1 == -1)
				{
					break;
					
				}
				
				newLineBlank2 = completeNewFile.indexOf("\n", newLineBlank1 + 1);
				
				if(newLineBlank2 == -1)
				{
					break;
					
				}
				
				else if(newLineBlank2 == 0)
				{
					completeNewFile =
					completeNewFile.substring(0, newLineBlank1) + completeNewFile.substring(newLineBlank2);
					
				}
				
				else
				{
					nextBlankLineCounter += newLineBlank1 + 1;
					
				}
				
				OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
				OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
			}
		
		System.out.println("completeNewFile (excessive blanklines removed) : " + "?" + completeNewFile + "?");
		
		/*End: if there are any blanks lines in the String they are removed here.*/
		
		overwriteFile(usersListFile, completeNewFile);
		
		
		System.out.println("End method: " + fullClassPathCollective + thisMethod);
		
	}
	
	
	
	public void writeToIndividualUserFile(String userID, String userName, String[] information) throws IOException
	{
		String thisMethod = "writeToIndividualUserFile";
		
		System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		
		
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
		
		
		System.out.println("End method: " + fullClassPathCollective + thisMethod);
		
	}
	
	
	
	public void overwriteFile(String fullFilePath, String[] information) throws IOException
	{
		String thisMethod = "overwriteFile (String information)";
		
		System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath)));
		
		System.out.println("File being overwritten: " + fullFilePath);
		
		
		for(int i = 0; i < information.length; i++)
		{
			outStream.println(information[i]);
			
		}
		
		outStream.close();
		
		
		System.out.println("End method: " + fullClassPathCollective + thisMethod);
	
	}
	
	
	
	public void overwriteFile(String fullFilePath, String information) throws IOException
	{
		String thisMethod = "overwriteFile (single String information)";
		
		System.out.println("Start method: " + fullClassPathCollective + thisMethod);
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(fullFilePath)));
		
		System.out.println("File being overwritten: " + fullFilePath);
		
		outStream.println(information);
		
		outStream.close();
		
		
		System.out.println("End method:: " + fullClassPathCollective + thisMethod);
		
	}
	
	
	
	public void addToList()
	{
	
	
	}
	
	
	
	public void removeFromList()
	{
	
	
	}
	
	
}