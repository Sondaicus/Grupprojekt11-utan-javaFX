import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        DatabaseCommunicator test = new DatabaseCommunicator();
        
        test.seeTerminalInformation(true);
        test.removeUser();
        
    }

}