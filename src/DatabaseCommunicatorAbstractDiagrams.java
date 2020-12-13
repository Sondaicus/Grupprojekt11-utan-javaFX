import java.io.*;

public interface DatabaseCommunicatorAbstractDiagrams
{
	abstract void setSeeExecutionInfoInTerminal(boolean seeExecutionInfoInTerminal);
	abstract void setDatabaseFolders();
	abstract void readAllUserFiles() throws IOException;
	abstract String getUserFile(String username) throws IOException;
	abstract boolean removeUser(String username) throws IOException;
	abstract void setLeapsInALoopToUser();
	abstract void writeToFile(String fullFilePath, String information) throws IOException;
	abstract void overwriteFile(String fullFilePath, String[] information) throws IOException;
	abstract void overwriteFile(String fullFilePath, String information) throws IOException;
	abstract void removeFromList();
}
