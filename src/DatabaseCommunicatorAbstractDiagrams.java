import java.io.*;
import java.util.ArrayList;

public interface DatabaseCommunicatorAbstractDiagrams
{
	abstract void setDatabaseFolders();
	abstract void readAllUserFiles() throws IOException;
	abstract void setLeapsInALoopToUser();
	abstract void writeToFile(String fullFilePath, String information) throws IOException;
	abstract void overwriteFile(String fullFilePath, String information) throws IOException;
	abstract void setUserTxtFileDatabase(String oldFile);
	abstract String getUserTxtFileDatabase();
	abstract void seeTerminalInformation(boolean status);
	abstract  void printClassVariables();
}