import java.io.*;
import java.util.*;


public interface StringMethodInterfaces
{
	/*Strings used in console-window for user to read.*/
	static String nextOSFolder = "\\";
	static String thisFolder = "src";
	static String thisClass = "StringMethodInterfaces";
	static String fullClassPathCollective = thisFolder + nextOSFolder + thisClass + nextOSFolder;
	static String tabular1 = "    ";
	static String tabular2 = tabular1 + tabular1;
	static String tabular3 = tabular2 + tabular1;
	
	
	
	public static String setLeapsInALoopToUser(int leapsInALoop)
	{
		String
		leapsInALoopToUser;
		
		leapsInALoopToUser = tabular3 + "leapsInALoop " + leapsInALoop;
		
		return leapsInALoopToUser;
		
	}
	
	
	/*Reads a full file and saves it to a single String.*/
	public static ArrayList<Object> readFullFile(String filePath, boolean seeExecutionInfoInTerminal) throws IOException
	{
		String thisMethod = "readFullFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "Start: read full " + filePath + " file.");
		}
		
		
		ArrayList<Object>
		returnList;
		
		BufferedReader
		inStream;
		
		String
		leapsInALoopToUser ,
		currentLineBeingRead ,
		fullFile;
		
		Boolean
		filePathLegitamate;
		
		long
		OVERLOADCHECKER1[];
		
		int
		leapsInALoop ,
		OVERLOADCHECKER2;
		
		
		returnList = new ArrayList<Object>(2);
		fullFile = null;
		
		
		try
		{
			inStream = new BufferedReader(new FileReader(filePath));
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "File found through path: " + filePath + ", file is being read.");
			}
			
			filePathLegitamate = true;
			
		}
		
		catch(java.io.FileNotFoundException e)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "File not found through path: " + filePath + ", process aborted.");
			}
			
			filePathLegitamate = false;
			
		}
		
		if(filePathLegitamate)
		{
			inStream = new BufferedReader(new FileReader(filePath));
			fullFile = "";
			
			leapsInALoop = 0;
			OVERLOADCHECKER1 = new long[1000000];
			OVERLOADCHECKER2 = 0;
			while(true)
			{
				leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(leapsInALoopToUser);
				}
				
				
				currentLineBeingRead = inStream.readLine();
				
				if(currentLineBeingRead == null)
				{
					break;
					
				}
				
				fullFile += currentLineBeingRead;
				fullFile += "\n";
				
				
				++leapsInALoop;
				OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
				OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
			}
			
			inStream.close();
			
		}
		
		
		returnList.add(0, filePathLegitamate);
		returnList.add(1, fullFile);
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "Full " + filePath + " file: " + "\n" + "$"+ fullFile + "$");
			System.out.println(tabular1 + "End: read full " + filePath + " file.");
		}
		
		return returnList;
		
	}
	
	
	
	public static ArrayList<Object> returnFullLineBySubstring(String fullString, String objectLineIdentifier,
	                                                          int objectIndexIdentifier, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "returnFullLineBySubstring";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "objectLineIdentifier: " + objectLineIdentifier);
			System.out.println(tabular1 + "objectIndexIdentifier: " + objectIndexIdentifier);
		}
		
		
		ArrayList<Object>
		returnList;
		
		String
		finalLine ,
		temporaryUsedDatabaseFile ,
		currentLineBeingReadFull ,
		currentLineBeingReadChopped ,
		objectLineComparator ,
		leapsInALoopToUser ,
		fullDatabseFile;
		
		Boolean
		lineFound;
		
		long
		OVERLOADCHECKER1[];
		
		int
		objectComparerLocation ,
		nextLineBreaker ,
		newLineCheckStart ,
		leapsInALoop ,
		OVERLOADCHECKER2;
		
		
		returnList = new ArrayList<Object>(2);
		objectComparerLocation = 0;
		fullDatabseFile = "";
		finalLine = null;
		lineFound = false;
		
		
		temporaryUsedDatabaseFile = fullString;
		nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
		leapsInALoop = 0;
		
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
				System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
			}
			
			nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
			currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(0, nextLineBreaker);
			temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(nextLineBreaker + 1);
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "currentLineBeingReadFull = " + "\n" + "$" + currentLineBeingReadFull + "$");
				System.out.println(tabular2 + "temporaryUsedDatabaseFile = " + "\n" + "$" + temporaryUsedDatabaseFile + "$");
			}
			
			currentLineBeingReadChopped = currentLineBeingReadFull;
			
			
			if(objectIndexIdentifier == 0)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectIndexIdentifier == 0, single read instance initiated, loop " +
					                   "skipped.");
				}
				
				
				objectComparerLocation = currentLineBeingReadChopped.indexOf("_");
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
				}
				
				
				if(objectComparerLocation != -1)
				{
					currentLineBeingReadChopped = currentLineBeingReadChopped.substring(0, objectComparerLocation);
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" +
						                   currentLineBeingReadChopped +  "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
					}
					
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectIndexIdentifier > 0, single read instance skipped, loop " + "starts.");
				}
				
				
				for(int i = 0; i < objectIndexIdentifier; i++)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(leapsInALoopToUser);
					}
					
					
					objectComparerLocation = currentLineBeingReadChopped.indexOf("_");
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
					}
					
					
					if(objectComparerLocation != -1)
					{
						currentLineBeingReadChopped = currentLineBeingReadChopped.substring(objectComparerLocation + 1);
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" + currentLineBeingReadChopped + "$");
						}
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
						}
						
					}
					
				}
				
			}
			
			try
			{
				objectLineComparator = currentLineBeingReadChopped.substring(0 , objectComparerLocation + 1);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator substring attempt succeded, " + "\n" + "objectLineComparator = " + "$" + objectLineComparator + "$");
				}
			}
			
			catch(StringIndexOutOfBoundsException e)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator substring attempt failed " +
					                   "(StringIndexOutOfBoundsException). objectLineComparator will be " +
					                   "set to complete currentLineBeingReadChopped String.");
				}
				
				
				objectLineComparator = currentLineBeingReadChopped;
				
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator = " + "\n" + "$" + objectLineComparator + "$");
				}
				
			}
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectComparerLocation = " + "$" + objectComparerLocation + "$");
			}
			
			
			try
			{
				if(objectLineComparator.length() > 1)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectLineComparator longer then 1 character.");
					}
					
					if(objectLineComparator.endsWith("_"))
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectLineComparator ends with \"_\".");
						}
						
						
						nextLineBreaker = objectLineComparator.indexOf("_");
						objectLineComparator = objectLineComparator.substring(0, nextLineBreaker);
						
						
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectLineComparator = " + "$" + objectLineComparator + "$");
						}
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectComparerLocation does not end with \"_\".");
						}
						
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation not longer then 1 character.");
					}
					
				}
				
			}
			
			catch(NullPointerException e)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation NullPointerException.");
				}
				
			}
			
			
			if(objectLineIdentifier.equals(objectLineComparator))
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Strings succesfully matched by object!");
				}
				lineFound = true;
				finalLine = currentLineBeingReadFull;
				break;
				
			}
			
			else
			{
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "finalLine did not match specified object, finalLine: " + "\n" + "$" +  finalLine + "$");
					System.out.println(tabular2 + "objectLineIdentifier: " + "\n" + "$" +  objectLineIdentifier + "$");
					System.out.println(tabular2 + "objectIndexIdentifier: " + "\n" + "$" +  objectIndexIdentifier + "$");
				}
				
				
				newLineCheckStart = temporaryUsedDatabaseFile.indexOf("\n");
				
				if(newLineCheckStart != -1)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Next line found");
					}
					
					
					++newLineCheckStart;
					currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(newLineCheckStart);
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadFull = " + "\n" + "$" + currentLineBeingReadFull + "$");
					}
					
					
					nextLineBreaker = currentLineBeingReadFull.indexOf("\n");
					
					if(nextLineBreaker == -1)
					{
						nextLineBreaker = fullDatabseFile.length();
						
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Next line not found");
					}
					break;
					
				}
				
			}
			
			++leapsInALoop;
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			if(!lineFound)
			{
				System.out.println(tabular2 + "Comparative Strings by object not matched!");
			}
			System.out.println(tabular2 + "lineFound = " + lineFound);
			System.out.println(tabular2 + "finalLine = " + "\n" + "$" + finalLine + "$");
			
		}
		
		
		returnList.add(0, lineFound);
		returnList.add(1, finalLine);
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "returnList.get(0) = " + returnList.get(0));
			System.out.println(tabular2 + "returnList.get(1) = " + returnList.get(1));
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return returnList;
		
	}
	
	
	
	public static ArrayList<Object> returnFullLineByStringLineIndex(String fullString, int indexIdentifier,
	                                                                boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "returnFullLineByStringLineIndex";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "fullString: " + "\n" + "$" + fullString + "$");
			System.out.println(tabular1 + "indexIdentifier: " + indexIdentifier);
		}
		
		
		ArrayList<Object>
		returnList;
		
		String
		returnLine ,
		temporaryUsedDatabaseFile ,
		currentLineBeingReadFull ,
		leapsInALoopToUser;
		
		Boolean
		lineFound ,
		loopContinue;
		
		boolean
		lastLineReadAttempt ,
		breakMethod;
		
		int
		nextLineBreaker ,
		rightNumberOfIterations ,
		leapsInALoop;
		
		
		returnList = new ArrayList<Object>(3);
		currentLineBeingReadFull = null;
		lastLineReadAttempt = false;
		breakMethod = false;
		rightNumberOfIterations = 0;
		
		
		if(indexIdentifier >= 1)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "indexIdentifier is set to logical value, method proceeds.");
			}
			
			
			temporaryUsedDatabaseFile = fullString;
			nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
			leapsInALoop = 0;
			for(int i = 0; i < indexIdentifier; i++)
			{
				leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(leapsInALoopToUser);
					System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
				}
				
				
				try
				{
					nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
					currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(0 , nextLineBreaker);
					temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(nextLineBreaker + 1);
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "New line found, String being cropped.");
						System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
						System.out.println(tabular2 + "currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
						System.out.println(tabular2 + "temporaryUsedDatabaseFile: " + "\n" + "$" + temporaryUsedDatabaseFile + "$");
					}
					
				}
				
				catch(StringIndexOutOfBoundsException e)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "New line not found (StringIndexOutOfBoundsException).");
					}
					
					
					if(!lastLineReadAttempt)
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "lastLineReadAttempt is true, attempting to read last line of " + "String.");
						}
						
						
						currentLineBeingReadFull = temporaryUsedDatabaseFile;
						
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
						}
						
						lastLineReadAttempt = true;
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "lastLineReadAttempt is false, exiting loop.");
						}
						
						loopContinue = false;
						breakMethod = true;
						break;
						
					}
					
				}
				
				++rightNumberOfIterations;
				
			}
			
			if(rightNumberOfIterations == indexIdentifier)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "rightNumberOfIterations is equal to indexIdentifier");
				}
				
				
				if(currentLineBeingReadFull.length() > 0)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadFull contains characters, line retrieval succeeded!");
					}
					
					
					returnLine = currentLineBeingReadFull;
					lineFound = true;
					
					if(!breakMethod)
					{
						loopContinue = true;
						
					}
					
					else
					{
						loopContinue = false;
						
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadFull contains no characters, line " +
						                   "retrieval failed!");
					}
					
					
					returnLine = null;
					lineFound = false;
					
					if(!breakMethod)
					{
						loopContinue = true;
						
					}
					
					else
					{
						loopContinue = false;
						
					}
					
				}
				
			}
			
			else
			{
				returnLine = null;
				lineFound = false;
				
				if(!breakMethod)
				{
					loopContinue = true;
					
				}
				
				else
				{
					loopContinue = false;
					
				}
				
			}
			
		}
		
		else
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "indexIdentifier is set to illogical value, method ends.");
			}
			
			
			returnLine = null;
			loopContinue = false;
			lineFound = false;
			
		}
		
		returnList.add(0, lineFound);
		returnList.add(1, loopContinue);
		returnList.add(2, returnLine);
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "returnList.get(0) = " + returnList.get(0));
			System.out.println(tabular2 + "returnList.get(1) = " + "\n" + "$" + returnList.get(1) + "$");
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return returnList;
		
	}
	
	
	
	public static String returnSubstringByLine(String fullString, int lineIndex,
	                                           int objectIndexIdentifier, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "returnSubstringByLine (full String, int index)";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "lineIndex: " + lineIndex);
			System.out.println(tabular1 + "objectIndexIdentifier: " + objectIndexIdentifier);
		}
		
		
		String
		returnedSubstring ,
		temporaryUsedDatabaseFile ,
		currentLineBeingReadFull ,
		currentLineBeingReadChopped ,
		objectLineComparator ,
		leapsInALoopToUser;
		
		int
		objectComparerLocation ,
		nextLineBreaker ,
		leapsInALoop ,
		totalLinesChecked;
		
		
		
		objectComparerLocation = 0;
		returnedSubstring = null;
		
		
		totalLinesChecked = 0;
		temporaryUsedDatabaseFile = fullString;
		nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
		leapsInALoop = 0;
		
		for(int i = 0; i < lineIndex; i++)
		{
			leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
				System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
			}
			
			
			nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
			temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(nextLineBreaker + 1);
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "temporaryUsedDatabaseFile = " + "\n" + "$" + temporaryUsedDatabaseFile + "$");
			}
			
			
			++totalLinesChecked;
			++leapsInALoop;
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "totalLinesChecked = " + totalLinesChecked);
		}
		
		
		nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
		}
		
		
		if(nextLineBreaker ==-1)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "nextLineBreaker illogical value, is set to full String length.");
			}
			
			
			nextLineBreaker = temporaryUsedDatabaseFile.length();
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
			}
			
		}
		
		
		currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(0, nextLineBreaker);
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "currentLineBeingReadFull = " + "\n" + "$" + currentLineBeingReadFull + "$");
		}
		
		
		currentLineBeingReadChopped = currentLineBeingReadFull;
		if(objectIndexIdentifier == 0)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectIndexIdentifier == 0, single read instance initiated, loop " +
				                   "skipped.");
			}
			
			
			objectComparerLocation = currentLineBeingReadChopped.indexOf("_");
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
			}
			
			
			if(objectComparerLocation != -1)
			{
				currentLineBeingReadChopped = currentLineBeingReadChopped.substring(0, objectComparerLocation);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" +
					                   currentLineBeingReadChopped + "$");
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
				}
				
			}
		}
		
		else
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectIndexIdentifier > 0, single read instance skipped, loop " +
				                   "starts.");
			}
			
			
			leapsInALoop = 0;
			for(int i = 0; i < objectIndexIdentifier; i++)
			{
				leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(leapsInALoopToUser);
				}
				
				
				objectComparerLocation = currentLineBeingReadChopped.indexOf("_");
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
				}
				
				
				if(objectComparerLocation != -1)
				{
					currentLineBeingReadChopped = currentLineBeingReadChopped.substring(objectComparerLocation + 1);
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" + currentLineBeingReadChopped + "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
					}
					
				}
				
				++leapsInALoop;
			}
			
		}
		
		
		try
		{
			objectLineComparator = currentLineBeingReadChopped.substring(0 , objectComparerLocation + 1);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectLineComparator substring attempt succeded, " + "\n" + "objectLineComparator = " + "$" + objectLineComparator + "$");
			}
		}
		
		catch(StringIndexOutOfBoundsException e)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectLineComparator substring attempt failed " +
				                   "(StringIndexOutOfBoundsException). objectLineComparator will be " +
				                   "set to complete currentLineBeingReadChopped String.");
			}
			
			
			objectLineComparator = currentLineBeingReadChopped;
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectLineComparator = " + "\n" + "$" + objectLineComparator + "$");
			}
			
		}
		
		
		try
		{
			if(objectLineComparator.length() > 1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator longer then 1 character.");
				}
				
				if(objectLineComparator.endsWith("_"))
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectLineComparator ends with \"_\".");
					}
					
					
					nextLineBreaker = objectLineComparator.indexOf("_");
					objectLineComparator = objectLineComparator.substring(0, nextLineBreaker);
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectLineComparator = " + "$" + objectLineComparator + "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation does not end with \"_\".");
					}
					
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation not longer then 1 character.");
				}
				
			}
			
			returnedSubstring = objectLineComparator;
			
		}
		
		catch(NullPointerException e)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectComparerLocation NullPointerException.");
			}
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "returnedSubstring = " + "\n" + "$" + returnedSubstring + "$");
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return returnedSubstring;
		
	}
	
	
	
	public static String returnSubstringByLine(String lineString,
	                                           int objectIndexIdentifier, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "returnSubstringByLine (single line)";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "objectIndexIdentifier: " + objectIndexIdentifier);
		}
		
		
		String
		returnedSubstring ,
		lineStringChopped ,
		objectLineComparator ,
		leapsInALoopToUser;
		
		int
		objectComparerLocation ,
		nextLineBreaker ,
		leapsInALoop;
		
		
		objectComparerLocation = 0;
		returnedSubstring = null;
		lineStringChopped = lineString;
		
		if(objectIndexIdentifier == 0)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectIndexIdentifier == 0, single read instance initiated, loop " +
				                   "skipped.");
			}
			
			
			objectComparerLocation = lineStringChopped.indexOf("_");
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
			}
			
			
			if(objectComparerLocation != -1)
			{
				lineStringChopped = lineStringChopped.substring(0, objectComparerLocation);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "lineStringChopped = " + "\n" + "$" +
					                   lineStringChopped+ "$");
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
				}
				
			}
			
		}
		
		else
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectIndexIdentifier > 0, single read instance skipped, loop " +
				                   "starts.");
			}
			
			
			leapsInALoop = 0;
			for(int i = 0; i < objectIndexIdentifier; i++)
			{
				leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(leapsInALoopToUser);
				}
				
				
				objectComparerLocation = lineStringChopped.indexOf("_");
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
				}
				
				
				if(objectComparerLocation != -1)
				{
					lineStringChopped = lineStringChopped.substring(objectComparerLocation + 1);
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "lineStringChopped = " + "\n" + "$" + lineStringChopped + "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
					}
					
				}
				
				++leapsInALoop;
			}
			
		}
		
		
		try
		{
			objectLineComparator = lineStringChopped.substring(0 , objectComparerLocation + 1);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectLineComparator substring attempt succeded, " + "\n" + "objectLineComparator = " + "$" + objectLineComparator + "$");
			}
		}
		
		catch(StringIndexOutOfBoundsException e)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectLineComparator substring attempt failed " +
				                   "(StringIndexOutOfBoundsException). objectLineComparator will be " +
				                   "set to complete currentLineBeingReadChopped String.");
			}
			
			
			objectLineComparator = lineStringChopped;
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectLineComparator = " + "\n" + "$" + objectLineComparator + "$");
			}
			
		}
		
		
		try
		{
			if(objectLineComparator.length() > 1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator longer then 1 character.");
				}
				
				if(objectLineComparator.endsWith("_"))
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectLineComparator ends with \"_\".");
					}
					
					
					nextLineBreaker = objectLineComparator.indexOf("_");
					objectLineComparator = objectLineComparator.substring(0, nextLineBreaker);
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectLineComparator = " + "$" + objectLineComparator + "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation does not end with \"_\".");
					}
					
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation not longer then 1 character.");
				}
				
			}
			
			returnedSubstring = objectLineComparator;
			
		}
		
		catch(NullPointerException e)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectComparerLocation NullPointerException.");
			}
			
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "returnedSubstring = " + "\n" + "$" + returnedSubstring + "$");
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return returnedSubstring;
		
	}
	
	
	
	
	public static String removeSingleLineInString(String fullString, String lineToRemove, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "removeSingleLineInString";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "lineToRemove: " + lineToRemove);
		}
		
		
		String
		temporaryUsedDatabaseFile ,
		newFilePart1 ,
		newFilePart2 ,
		completeNewFile;
		
		int
		part1End ,
		part2Start;
		
		boolean
		proceed;
		
		
		temporaryUsedDatabaseFile = fullString;
		newFilePart1 = null;
		newFilePart2 = null;
		proceed = true;
		
		/*Start: part 1*/
		if(proceed)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "Start: creating section 1/2.");
			}
			
			part1End = temporaryUsedDatabaseFile.indexOf(lineToRemove);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "part1End = " + part1End);
			}
			
			
			if(part1End == -1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Referenced line not found, program does not return new String.");
				}
				proceed = false;
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Referenced line found, program will return new String.");
				}
				
				
				newFilePart1 = temporaryUsedDatabaseFile.substring(0, part1End);
				
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "newFilePart1 = " + "\n" + "$" + newFilePart1 + "$");
				}
				
			}
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "End: creating section 1/2.");
			}
			
		}
		
		else
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "Section 1/2 skipped.");
			}
		}
		/*End: part 1*/
		
		
		/*Start: part 2*/
		if(proceed)
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "Start: creating section 2/2.");
			}
			
			
			temporaryUsedDatabaseFile = fullString;
			part2Start = newFilePart1.lastIndexOf("\n");
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "part2Start: " + part2Start);
			}
			
			
			temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(part2Start + 1);
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "temporaryUsedDatabaseFile: " + "$" + temporaryUsedDatabaseFile + "$");
			}
			
			
			part2Start = temporaryUsedDatabaseFile.indexOf("\n");
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "part2Start: " + part2Start);
			}
			
			
			newFilePart2 = temporaryUsedDatabaseFile.substring(part2Start + 1);
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "newFilePart2 : " + "$" + newFilePart2 + "$");
				System.out.println(tabular1 + "End: creating section 2/2.");
			}
			
		}
		
		else
		{
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "Section 2/2 skipped.");
			}
		}
		/*End: part 2*/
		
		/*Start: part 3*/
		completeNewFile = newFilePart1 + newFilePart2;
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "completeNewFile : " + "\n" + "$" + completeNewFile + "$");
		}
		
		
		/*End: part 3*/
		
		return completeNewFile;
		
	}
	
	
	
	public static int countInstancesBySubstring(String fullString, String objectLineIdentifier,
	                                            int objectIndexIdentifier, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "countInstancesBySubstring";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "objectLineIdentifier: " + objectLineIdentifier);
			System.out.println(tabular1 + "objectIndexIdentifier: " + objectIndexIdentifier);
		}
		
		
		String
		temporaryUsedDatabaseFile ,
		currentLineBeingReadFull ,
		currentLineBeingReadChopped ,
		objectLineComparator ,
		leapsInALoopToUser;
		
		long
		OVERLOADCHECKER1[];
		
		int
		resultInt ,
		objectComparerLocation ,
		nextLineBreaker ,
		newLineCheckStart ,
		leapsInALoop ,
		OVERLOADCHECKER2;
		
		boolean
		lastAttemptCorrector;
		
		
		resultInt = 0;
		objectComparerLocation = 0;
		temporaryUsedDatabaseFile = fullString;
		lastAttemptCorrector = true;
		
		leapsInALoop = 0;
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
			}
			
			nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
			}
			
			
			try
			{
				currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(0 , nextLineBreaker);
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile substring attempt succeded. " +
					                   "currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
				}
				
			}
			
			catch(StringIndexOutOfBoundsException e)
			{
				currentLineBeingReadFull = temporaryUsedDatabaseFile;
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile substring attempt failed, " +
					                   "StringIndexOutOfBoundsException. currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
				}
				
			}
			
			
			if(nextLineBreaker != -1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile != -1, String cuts 1 line.");
				}
				
				
				temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(nextLineBreaker + 1);
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile == -1, String value is erased.");
				}
				
				
				temporaryUsedDatabaseFile = "";
				
			}
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "temporaryUsedDatabaseFile = " + "\n" + "$" + temporaryUsedDatabaseFile + "$");
			}
			
			
			currentLineBeingReadChopped = currentLineBeingReadFull;
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" + currentLineBeingReadFull + "$");
			}
			
			
			
			if(objectIndexIdentifier == 0)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectIndexIdentifier == 0, single read instance initiated, loop " +
					                   "skipped.");
				}
				
				
				objectComparerLocation = currentLineBeingReadChopped.indexOf("_");
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
				}
				
				
				if(objectComparerLocation != -1)
				{
					objectLineComparator = currentLineBeingReadChopped.substring(0, objectComparerLocation);
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" +
						                   currentLineBeingReadChopped +  "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
					}
					
				}
				
			}
			
			else
			{
				for(int i = 0; i < objectIndexIdentifier; i++)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(leapsInALoopToUser);
					}
					
					
					objectComparerLocation = currentLineBeingReadChopped.indexOf("_");
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
					}
					
					
					if(objectComparerLocation != -1)
					{
						currentLineBeingReadChopped = currentLineBeingReadChopped.substring(objectComparerLocation + 1);
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "currentLineBeingReadChopped = " + "\n" + "$" + currentLineBeingReadChopped + "$");
						}
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectComparerLocation = -1, chop aborted.");
							objectComparerLocation = -1;
						}
						
					}
					
				}
				
			}
			
			try
			{
				objectLineComparator = currentLineBeingReadChopped.substring(0 , objectComparerLocation);
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator substring attempt succeded, " + "\n" + "objectLineComparator = " + "$" + objectLineComparator + "$");
				}
			}
			
			catch(StringIndexOutOfBoundsException e)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator substring attempt failed " +
					                   "(StringIndexOutOfBoundsException). objectLineComparator will be " +
					                   "set to complete currentLineBeingReadChopped String.");
				}
				
				
				objectLineComparator = currentLineBeingReadChopped;
				
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectLineComparator = " + "\n" + "$" + objectLineComparator + "$");
				}
				
				
			}
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "objectComparerLocation = " + objectComparerLocation);
			}
			
			
			try
			{
				if(objectLineComparator.length() > 1)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectLineComparator longer then 1 character.");
					}
					
					if(objectLineComparator.endsWith("_"))
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectLineComparator ends with \"_\".");
						}
						
						
						nextLineBreaker = objectLineComparator.indexOf("_");
						objectLineComparator = objectLineComparator.substring(0, nextLineBreaker);
						
						
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectLineComparator = " + "$" + objectLineComparator + "$");
						}
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "objectComparerLocation does not end with \"_\".");
						}
						
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "objectComparerLocation not longer then 1 character.");
					}
					
				}
				
			}
			
			catch(NullPointerException e)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation NullPointerException.");
				}
				
			}
			
			
			if(objectLineIdentifier.equals(objectLineComparator))
			{
				++resultInt;
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Strings succesfully matched by object, resultInt = " + resultInt);
				}
				
			}
			
			else
			{
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Strings did not match by object.");
					System.out.println(tabular2 + "objectLineIdentifier: " + "\n" + "$" +  objectLineIdentifier + "$");
					System.out.println(tabular2 + "objectIndexIdentifier: " + "\n" + "$" +  objectIndexIdentifier + "$");
				}
				
				
				newLineCheckStart = temporaryUsedDatabaseFile.indexOf("\n");
				
				if(newLineCheckStart != -1)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Next line found");
					}
					
					
					++newLineCheckStart;
					currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(newLineCheckStart);
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadFull = " + "\n" + "$" + currentLineBeingReadFull + "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Next line not found");
					}
					
					
					if(lastAttemptCorrector)
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "lastAttemptCorrector is true, one last lap will be made " +
							                   "and last line will be current String remainder.");
						}
						
						
						lastAttemptCorrector = false;
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "lastAttemptCorrector is false, loop is exited and no more " +
							                   "instances are compared and counted.");
						}
						
						
						break;
						
					}
					
				}
				
			}
			
			++leapsInALoop;
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "Iteration loop complete, resultInt = " + resultInt);
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return resultInt;
		
	}
	
	
	
	
	public static int countInstancesByFullLine(String fullString, String fullLineIdentifier, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "countInstancesByFullLine";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "fullLineIdentifier: " + fullLineIdentifier);
		}
		
		
		String
		temporaryUsedDatabaseFile ,
		currentLineBeingReadFull ,
		leapsInALoopToUser;
		
		long
		OVERLOADCHECKER1[];
		
		int
		resultInt ,
		nextLineBreaker ,
		newLineCheckStart ,
		leapsInALoop ,
		OVERLOADCHECKER2;
		
		boolean
		lastAttemptCorrector;
		
		
		resultInt = 0;
		temporaryUsedDatabaseFile = fullString;
		lastAttemptCorrector = true;
		
		leapsInALoop = 0;
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
			}
			
			nextLineBreaker = temporaryUsedDatabaseFile.indexOf("\n");
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "nextLineBreaker = " + nextLineBreaker);
			}
			
			
			try
			{
				currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(0 , nextLineBreaker);
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile substring attempt succeded. " +
					                   "currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
				}
				
			}
			
			catch(StringIndexOutOfBoundsException e)
			{
				currentLineBeingReadFull = temporaryUsedDatabaseFile;
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile substring attempt failed, " +
					                   "StringIndexOutOfBoundsException. currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
				}
				
			}
			
			
			if(nextLineBreaker != -1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile != -1, String cuts 1 line.");
				}
				
				
				temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(nextLineBreaker + 1);
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "temporaryUsedDatabaseFile == -1, String value is erased.");
				}
				
				
				temporaryUsedDatabaseFile = "";
				
			}
			
			
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "temporaryUsedDatabaseFile = " + "\n" + "$" + temporaryUsedDatabaseFile + "$");
			}
			
			
			
			
			
			if(fullLineIdentifier.equals(currentLineBeingReadFull))
			{
				++resultInt;
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Strings succesfully matched by object, resultInt = " + resultInt);
				}
				
			}
			
			else
			{
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "Strings did not match by object.");
				}
				
				
				newLineCheckStart = temporaryUsedDatabaseFile.indexOf("\n");
				
				if(newLineCheckStart != -1)
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Next line found");
					}
					
					
					++newLineCheckStart;
					currentLineBeingReadFull = temporaryUsedDatabaseFile.substring(newLineCheckStart);
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "currentLineBeingReadFull = " + "\n" + "$" + currentLineBeingReadFull + "$");
					}
					
				}
				
				else
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Next line not found");
					}
					
					
					if(lastAttemptCorrector)
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "lastAttemptCorrector is true, one last lap will be made " +
							                   "and last line will be current String remainder.");
						}
						
						
						lastAttemptCorrector = false;
						
					}
					
					else
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "lastAttemptCorrector is false, loop is exited and no more " +
							                   "instances are compared and counted.");
						}
						
						
						break;
						
					}
					
				}
				
			}
			
			++leapsInALoop;
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "Iteration loop complete, resultInt = " + resultInt);
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return resultInt;
		
	}
	
	
	
	
	
	
	
	/*Method removes excessive blank lines from any String*/
	public static String removeExcessiveBlankLines(String object, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "removeExcessiveBlankLines";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular2 + "object: " + "\n" + "$" + object + "$");
		}
		
		
		ArrayList<Object>
		resultHolderList;
		
		String
		newFile ,
		
		currentLineBeingReadFull ,
		leapsInALoopToUser;
		
		long
		OVERLOADCHECKER1[];
		
		int
		iterationsCounter ,
		
		leapsInALoop ,
		OVERLOADCHECKER2;
		
		boolean
		successLinePrint,
		successLineContinue;
		
		
		newFile = "";
		iterationsCounter = 1;
		
		leapsInALoop = 0;
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
			}
			
			resultHolderList = StringMethodInterfaces.returnFullLineByStringLineIndex(object, iterationsCounter,seeExecutionInfoInTerminal);
			successLinePrint = (boolean) resultHolderList.get(0);
			successLineContinue = (boolean) resultHolderList.get(1);
			
			if(successLinePrint)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 +"successLinePrint true, new line is added.");
				}
				
				
				currentLineBeingReadFull = (String) resultHolderList.get(2);
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "currentLineBeingReadFull: " + "\n" + "$" + currentLineBeingReadFull + "$");
				}
				
				
				currentLineBeingReadFull = currentLineBeingReadFull.trim();
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "currentLineBeingReadFull (trimmed): " + "\n" + "$" + currentLineBeingReadFull + "$");
				}
				
				
				newFile += currentLineBeingReadFull;
				newFile += "\n";
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "newFile: " + "\n" + "$" + newFile + "$");
				}
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 +"successLinePrint false, new line is not printed.");
				}
				
			}
			
			if(!successLineContinue)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 +"successLinePrint false, iteration is stopped.");
				}
				
				break;
				
			}
			
			++iterationsCounter;
			
			++leapsInALoop;
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 +"newFile (excessive blanklines removed): " + "\n" + "$" + newFile + "$");
		}
		
		
		newFile = newFile.trim();
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 +"newFile (trimmed): " + "\n" + "$" + newFile + "$");
			System.out.println("End: " + fullClassPathCollective + thisMethod);
		}
		
		
		return newFile;
		
	}
	
}