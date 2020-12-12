import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        DatabaseCommunicator test = new DatabaseCommunicator();
        
        test.seeTerminalInformation(true);
        test.readAllUserFiles();
        
    }

}