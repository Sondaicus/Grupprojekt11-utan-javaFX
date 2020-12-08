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
	public static String readFullFile(String filePath, boolean seeExecutionInfoInTerminal) throws IOException
	{
		String thisMethod = "readFullFile";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "Start: read full " + filePath + " file.");
		}
		
		
		BufferedReader
			inStream;
		
		String
			leapsInALoopToUser ,
			currentLineBeingRead ,
			currentFullDatabseFile;
		
		long
			OVERLOADCHECKER1[];
		
		int
			leapsInALoop ,
			OVERLOADCHECKER2;
		
		
		inStream = new BufferedReader(new FileReader(filePath));
		currentFullDatabseFile = "";
		
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
			
			currentFullDatabseFile += currentLineBeingRead;
			currentFullDatabseFile += "\n";
			
			
			++leapsInALoop;
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		inStream.close();
		
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 + "Full " + filePath + " file: " + "\n" + "$"+ currentFullDatabseFile + "$");
			System.out.println(tabular1 + "End: read full " + filePath + " file.");
		}
		
		return currentFullDatabseFile;
		
	}
	
	
	
	public static String removeSingleLineInString(String fullString, String objectLineIdentifier,
	                                              boolean seeExecutionInfoInTerminal)
	{
		/*Begin: saving the files lines to a separate String up until it finds the user (if it finds it).*/
		String thisMethod = "removeSingleLineInString";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
			System.out.println(tabular1 + "objectLineIdentifier: " + objectLineIdentifier);
		}
		
		
		String
			temporaryUsedDatabaseFile ,
			currentLineBeingRead ,
			objectLineComparator ,
			newFilePart1 ,
			newFilePart2 ,
			completeNewFile ,
			excessiveBlankLineChecker ,
			leapsInALoopToUser ,
			currentFullDatabseFile;
		
		long
			OVERLOADCHECKER1[];
		
		int
			objectComparerLocation ,
			nextLineBreaker ,
			newLineCheckStart ,
			part2Start ,
			leapsInALoop ,
			OVERLOADCHECKER2;
		
		boolean
			userFound;
		
		
		
		currentFullDatabseFile = "";
		newFilePart1 = "";
		newFilePart2 = "";
		userFound = false;
		
		
		/*Start: part 1*/
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular1 + "Start: creating section 1/2.");
				
			}
			
			
			newLineCheckStart = 0;
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
				currentLineBeingRead = temporaryUsedDatabaseFile.substring(0, nextLineBreaker);
				temporaryUsedDatabaseFile = temporaryUsedDatabaseFile.substring(nextLineBreaker + 1);
				
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "currentLineBeingRead = " + "\n" + "$" + currentLineBeingRead + "$");
					System.out.println(tabular2 + "temporaryUsedDatabaseFile = " + "\n" + "$" + temporaryUsedDatabaseFile + "$");
				}
				
				
				objectComparerLocation = currentLineBeingRead.indexOf("_");
				objectLineComparator = currentLineBeingRead.substring(0, objectComparerLocation);
				
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "objectComparerLocation = " + "$" + objectComparerLocation + "$");
				}
				
				
				if(objectLineIdentifier.equals(objectLineComparator))
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Strings succesfully matched by object!");
					}
					userFound = true;
					break;
					
				}
				
				else
				{
					newFilePart1 += currentLineBeingRead;
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "newFilePart1 added a new line. Current String: " + "\n" + newFilePart1);
					}
					
					
					newLineCheckStart = temporaryUsedDatabaseFile.indexOf("\n");
					
					if(newLineCheckStart != -1)
					{
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "Next line found");
						}
						
						
						++newLineCheckStart;
						newFilePart1 += "\n";
						currentLineBeingRead = temporaryUsedDatabaseFile.substring(newLineCheckStart);
						
						
						if(seeExecutionInfoInTerminal)
						{
							System.out.println(tabular2 + "currentLineBeingRead = " + "$" + currentLineBeingRead + "$");
						}
						
						
						nextLineBreaker = currentLineBeingRead.indexOf("\n");
						
						if(nextLineBreaker == -1)
						{
							nextLineBreaker = currentFullDatabseFile.length();
							
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
				if(!userFound)
				{
					System.out.println(tabular2 + "Comparative Strings by object not matched!");
				}
				System.out.println(tabular2 + "newFilePart1 : " + "$" + newFilePart1 + "$");
				System.out.println(tabular1 + "End: creating section 1/2.");
			}
		/*End: part 1*/
		
		
		/*Start: part 2*/
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
	
	
	/*Method removes excessive blank lines from any String*/
	public static String removeExcessiveBlankLines(String object, boolean seeExecutionInfoInTerminal)
	{
		String thisMethod = "removeExcessiveBlankLines";
		if(seeExecutionInfoInTerminal)
		{
			System.out.println("Start: " + fullClassPathCollective + thisMethod);
		}
		
		
		String
			excessiveBlankLineChecker ,
		
			leapsInALoopToUser;
		
		long
			OVERLOADCHECKER1[];
		
		int
			newLineBlank1 ,
			newLineBlank2 ,
			nextBlankLineCounter ,
		
			leapsInALoop ,
			OVERLOADCHECKER2;
		
		boolean
			resetBlankCounter;
		
		
		resetBlankCounter = false;
		nextBlankLineCounter = 0;
		
		leapsInALoop = 0;
		OVERLOADCHECKER1 = new long[1000000];
		OVERLOADCHECKER2 = 0;
		while(true)
		{
			leapsInALoopToUser = setLeapsInALoopToUser(leapsInALoop);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(leapsInALoopToUser);
				System.out.println(tabular2 + "nextBlankLineCounter = " + nextBlankLineCounter);
			}
			
			
			newLineBlank1 = object.indexOf("\n", nextBlankLineCounter);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "newLineBlank1 value = " + newLineBlank1);
			}
			
			
			if(newLineBlank1 == -1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "newLineBlank1: no blank lines found, exiting loop.");
				}
				
				
				break;
				
			}
			
			newLineBlank2 = object.indexOf("\n", newLineBlank1 + 1);
			if(seeExecutionInfoInTerminal)
			{
				System.out.println(tabular2 + "newLineBlank2 value = " + newLineBlank2);
			}
			
			
			if(newLineBlank2 == -1)
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "newLineBlank2: no blank lines found, exiting loop.");
				}
				
				
				break;
				
			}
			
			else
			{
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "newLineBlank2 test initiated.");
				}
				
				
				excessiveBlankLineChecker = object.substring(newLineBlank1, newLineBlank2 + 1);
				
				
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "excessiveBlankLineChecker = " + "$" + excessiveBlankLineChecker + "$");
				}
				
				
				if(excessiveBlankLineChecker.equals("\n" + "\n"))
				{
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Excessive blank line found, attempt to remove: ");
						System.out.println("$" + object + "$");
					}
					
					
					resetBlankCounter = true;
					object =
					object.substring(0 , newLineBlank1) + object.substring(newLineBlank1 + 1);
					
					
					if(seeExecutionInfoInTerminal)
					{
						System.out.println(tabular2 + "Result: ");
						System.out.println("$" + object + "$");
					}
					
					
				}
				
				else
				{
					System.out.println(tabular2 + "Excessive blank line not found.");
					
				}
				
			}
			
			
			if(resetBlankCounter)
			{
				nextBlankLineCounter = 0;
				if(seeExecutionInfoInTerminal)
				{
					System.out.println(tabular2 + "nextBlankLineCounter reset to 0.");
				}
				
			}
			
			else
			{
				nextBlankLineCounter += newLineBlank1 + 1;
				
			}
			
			
			++leapsInALoop;
			OVERLOADCHECKER1[OVERLOADCHECKER2] = OVERLOADCHECKER2;
			OVERLOADCHECKER2 = OVERLOADCHECKER2 + 1;
		}
		
		if(seeExecutionInfoInTerminal)
		{
			System.out.println(tabular2 +"object (excessive blanklines removed): " + "\n" + "$" + object + "$");
			System.out.println("End: " + fullClassPathCollective + thisMethod);
			
		}
		
		return object;
		
	}
	
}