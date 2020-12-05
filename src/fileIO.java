public interface fileIO
{
	abstract void setDatabaseFolder();
	abstract void readFromFile();
	abstract void setFilecontentsToList();
	abstract void writeToFile();
	abstract void overwriteFile();
	abstract void addToList();
	abstract void removeFromList();
}
