import java.io.*;

public interface fileIO
{
	abstract void setDatabaseFolders();
	abstract void readAllUserFiles();
	abstract String[] getUserFilesFromID(int userID) throws IOException;
	abstract void removeUser(int userID) throws IOException;
	abstract void writeToIndividualUserFile(String userID, String userName, String[] information) throws IOException;
	abstract void overwriteFile(String fullFilePath, String[] information) throws IOException;
	abstract void overwriteFile(String fullFilePath, String information) throws IOException;
	abstract void addToList();
	abstract void removeFromList();
}
