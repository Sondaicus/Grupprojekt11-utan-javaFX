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
	
	/*This method returns all the users from the database as a String[][]. The first field contains each user
	(decided by line), and its size depends on the amount of users found in the system. The second field has room for 3
	variables; 1st is the user name, 2nd is password, 3rd is account type.*/
	abstract String[][] getAllUsers();
	
	/*This method removes the specified task from the specified user. If it exists and is removed the boolean is
	returned as true, if it doesnt find it and doesnt remove it it is false.*/
	abstract boolean removeTaskFromUser(String username, String task) throws IOException;
	
	/*This method removes all task of the specified subject from the specified user. It has two objects inside, the
	1st one is a Boolean, the second one an Integer. If the file to the user is found then the Boolean is true, if
	not it is false. The Integer counts how many lines containing the specified subject has been removed, if its
	value is 0 then no specified subjects were found, or the users personal file wasn't found.*/
	abstract ArrayList<Object> removeSubjectFromUser(String username, String subject) throws IOException;
}