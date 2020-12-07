import java.util.*;
import java.io.*;

public interface CreateNewUserID
{
	public static int getAndSetIDs() throws IOException
	{
		String
			thisFolder = "src" ,
			thisClass = "CreateNewUserID" ,
			thisMethod = "getAndSetIDs" ,
			nextOSFolder = "\\" ,
			fullClassPathCollective = thisFolder + nextOSFolder + thisClass + nextOSFolder + thisMethod;
		
		
		System.out.println("Start method: " + fullClassPathCollective);
		
		
		File
			fullFileNameFile;
		
		String
			fullFileNameString ,
			fullProjectPath ,
			registeredUsersPath ,
			nextUserIDPath ,
			currentIDString ,
			nextUserIDString;
		
		BufferedReader
			inStream;
		
		PrintWriter
			outStream;
		
		int
			setFolderLocation ,
			nextUserIDInt ,
			currentUserID ,
			currentIDInt;
		
		
		fullFileNameString = "MainFolderIdentifyerTextFile.txt";
		fullFileNameFile = new File(fullFileNameString);
		fullProjectPath = fullFileNameFile.getAbsolutePath();
		setFolderLocation = fullProjectPath.indexOf(fullFileNameString);
		fullProjectPath = fullProjectPath.substring(0, setFolderLocation);
		nextUserIDPath = fullProjectPath + "\\NextUserID.txt";
		
		
		inStream = new BufferedReader(new FileReader(nextUserIDPath));
		
		
		try
		{
			currentIDString = inStream.readLine();
			System.out.println("NextUserID successfully read, next user ID: " + currentIDString + " " +
			                   "(nextUserIDPath" + "\\src\\CreateNewUserID\\getAndSetIDs" + ")");
			
			
			if(currentIDString.equals(""))
			{
				currentIDString = "1";
				System.out.println("NextUserID successfully read but file was empty, (nextUserIDPath" + "\\src" +
				                   "\\CreateNewUserID\\getAndSetIDs" + ") = no text");
				
			}
			
		}
		
		catch(FileNotFoundException e)
		{
			currentIDString = "1";
			System.out.println("NextUserID failed to read, (nextUserIDPath" + "\\src\\CreateNewUserID\\getAndSetIDs" + "), FileNotFoundException");
			
		}
		
		inStream.close();
		
		
		currentIDInt = Integer.parseInt(currentIDString);
		nextUserIDInt = currentIDInt;
		++nextUserIDInt;
		nextUserIDString = String.valueOf(nextUserIDInt);
		
		
		outStream = new PrintWriter(new BufferedWriter(new FileWriter(nextUserIDPath)));
		outStream.println(nextUserIDString);
		outStream.close();
		
		
		System.out.println("End method: " + fullClassPathCollective);
		
		
		return currentIDInt;
		
	}
	
}
