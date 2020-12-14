import java.io.*;
import java.nio.file.*;
import java.util.*;

public interface DatabaseToRestOfProgramDiagram
{
	/*Decides if how the program works is shown in the terminal window.*/
	abstract void setSeeExecutionInfoInTerminal(boolean seeExecutionInfoInTerminal);
	
	/*Returns an ArrayList<Object> with two variables: 0 is a Boolean, and 1 is a String[][]. The Boolean result is
	if the user file was successfully read or not, and the String[][] is the contents of the user file
	(String[line][ {Task , Subject } ]), if the Boolean is false then the String[][] value is null.*/
	abstract ArrayList<Object> getUserFile(String username) throws IOException;
	
	/*Removes the specified user from the system, it has a return value of a boolean array with two fields. Field 0
	is weather or not the user was removed from the system, field 1 is if the users personal txt-file was
	successfully deleted in the folder. If field 1 is false then you likely need to restart the program and run the
	method again for it to work.*/
	abstract boolean[] removeUser(String username) throws IOException;
	
	/*Creates a new user, the method returns a boolean if the user was successfully created or not. If the returned
	boolean is false then it is because the username already exists in the system.*/
	abstract boolean createUser(String username, String password, int accountType) throws IOException;
	
	/*Adds a task to the specified user, returns a boolean array with two fields, both fields need to be true for the
	 task to be created. Field 0 represents if the user was found in the system, field 1 represents if the task was a
	  duplicate of an already existing task.*/
	abstract boolean[] addTaskToUser(String username, String taskInstance, String taskSubject) throws IOException;
	
	/*This method returns all the users from the database*/
	abstract String[][][] getAllUsers();
}